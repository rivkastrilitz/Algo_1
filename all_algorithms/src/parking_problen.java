public class parking_problen {

    //o(n^2) if all cars are v.
    public static int numOfCars(CycleList parking){
         parking.getHead().setData('v');
         Node temp=parking.getHead().getNext();
         boolean flag=true;
         int counter=1;
         while (flag==true){
             if(temp.getData()=='v'){
                 temp.setData('w');
                 int back=counter;
                 while(back>0){
                     temp=temp.getPrev();
                     back--;
                 }
                 //arrived to first
                 if(temp.getData()=='w'){
                     flag=false;

                 }else{
                     counter=1;
                     temp=parking.getHead().getNext();

                 }
             }else{
                 temp=temp.getNext();
                 counter++;
             }
         }
     return counter;
    }


    public static boolean isLoop(CycleList parking){
        Node temp=parking.getHead();
        Node turtle=temp;
        Node rabbit=temp;
        boolean flag=true;

        while (flag==true){
          if(turtle.getNext()==null||rabbit.getNext().getNext()==null){
              return false;
          }else{

              turtle=turtle.getNext();
              rabbit=rabbit.getNext().getNext();
              if(turtle.getData()== rabbit.getData()){
                  return true;
              }

          }

        }
       return false;
    }

    public static int findArmLen(CycleList parking){
        int ans=-1;
        boolean flag=true;
        boolean met=false;
        Node turtle=parking.getHead();
        Node rabbit=parking.getHead();
        while (flag==true){
           if(turtle.getNext()==null||rabbit.getNext().getNext()==null) flag=false;
           else {
               turtle=turtle.getNext();
               rabbit=rabbit.getNext().getNext();
           }
           if(turtle.getData()==rabbit.getData()){
               flag=false;
               met=true;
           }
        }


        rabbit=parking.getHead();
        while (met==true){
            ans++;
            if(turtle.getData()==rabbit.getData()){
                met=false;
            }else{
                rabbit=rabbit.getNext();
                turtle=turtle.getNext();
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        CycleList parking=new CycleList();

        parking.add('s');
        parking.add('k');
        parking.add('v');
        parking.add('s');
        parking.add('v');
        parking.add('e');

        System.out.println(numOfCars(parking));
        System.out.println(isLoop(parking));

    }


}
