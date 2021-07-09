package fromPriviousTests;

public class prob2_p9_crystalBall {

   public static int findFlor(int tower[],int a){
      int NumFloor=tower.length;

      int flor=1;
      while (NumFloor>flor*(flor+1)/2){
          flor++;
      }

      int x=flor;
      while (flor<tower.length && tower[flor]<a ){
          flor+=(--x);
      }
       System.out.println("first ball broke at flor:"+flor);
      int flor2=flor-(x+1);
       while (tower[flor2]<a){
           flor2++;
       }
       System.out.println("secound ball broke at flor:"+flor2);
       return flor2;
   }

    public static void main(String[] args) {
        int arr[]=new int[10];
        arr[0]=0;
        arr[1]=8;
        arr[2]=0;
        arr[3]=4;
        arr[4]=1;
        arr[5]=6;
        arr[6]=5;
        arr[7]=3;
        arr[8]=13;
        arr[9]=11;

        System.out.println(findFlor(arr,10));

    }









}
