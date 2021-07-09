public class crystal_ball {

    public static int numberOfBreaks(int []arr,int a){
        int floor=1;

        int n= arr.length;
        while (floor*(floor+1)/2<n){
            floor++;
        }
        int x=floor;

        while(floor<n){
            if(arr[floor]>a){
              floor=floor-(x+1);
              while(true){
                  floor++;
                  if(arr[floor]>a)
                      return n-floor;
              }

            }else{
                floor=floor+(--x);
            }

        }
      return -1;
    }

    public static int numberOfCheking(int []arr,int a){
        int floor=1;

        int n= arr.length;
        while (floor*(floor+1)/2<n){
            floor++;
        }
        int x=floor;
        int chek=0;

        while(floor<n){
            if(arr[floor]>a){
                floor=floor-(x+1);
                while(true){
                    floor++;
                    chek++;
                    if(arr[floor]>a)
                        return chek;
                }

            }else{
                floor=floor+(--x);
                chek++;
            }

        }
        return chek;
    }

    public static int floorindex(int []arr,int a){
        int floor=1;

        int n= arr.length;
        while (floor*(floor+1)/2<n){
            floor++;
        }
        int x=floor;
        boolean flag=true;
        while(floor<n){
            if(arr[floor]>a){
                floor=floor-(x+1);
                while(flag){
                    floor++;
                    if(arr[floor]>a)
                        return floor;
                }

            }else{
                floor=floor+(--x);
            }

        }
        return -1;
    }


    public static int matrix(int n,int k ){
        //if there is one flor or no floor
        if(n==1 ||n==0)return n;
        //if there is only onr egg check each floor
        if(k==1)return  n;
        int min=n;

        for (int i = 0; i <=n ; i++) {
            int res=Math.max(matrix(k-1,i-1),(matrix(k,k-i)));
            if(res<min)min=res;

        }

        return min+1;
    }



    public static void main(String[] args) {
        int []a={1,2,4,6,7,5,38,9,10,11};
        System.out.println(numberOfBreaks(a,5));
        System.out.println(floorindex(a,4));
        System.out.println(numberOfCheking(a,8));
    }






}
