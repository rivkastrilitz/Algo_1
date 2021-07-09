public class crystalBall3 {

    public static int findFloor(int []arr,int k){

        int floor=1;

        while(floor*(floor+1)/2< arr.length){
            floor++;
        }
        int x=floor;

        while (floor<arr.length){

          if( k<arr[floor]) {
              int broken1=floor;
              floor=floor-(x+1);
              int floor2=1;
              while(floor2*(floor2+1)/2< broken1){
                  floor2++;
              }
              int y=floor2;
              while(true){

                  if(k<arr[floor2]){
                      floor2=floor2-(y+1);
                      while (arr[floor2]<k){
                          floor2++;
                          if(arr[floor2]>k)return floor2;
                      }

                  }else{
                      floor2=floor2+(--y);
                  }

              }
          }

          floor=floor+(--x);

        }
        return floor;
    }

    public static void main(String[] args) {
        int arr[]={1,4,5,6,7,5,4,3,5,6,9,9,9,9,9};
        System.out.println(findFloor(arr,8));
    }

}


