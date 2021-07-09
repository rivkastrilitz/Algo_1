public class Min_Max_In_Array {

    //o(n) comparison=3n/2
    public static void findMinAndMax(int arr[]){
        int min=arr[0];
        int max=arr[1];
        if(arr[0]>arr[1]){
            min=arr[1];
            max=arr[0];
        }
        for (int i = 2; i < arr.length-1 ; i+=2) {
            if(arr[i]<arr[i+1]){
                if(arr[i]<min)
                    min=arr[i];
                if (arr[i+1]>max)
                    max=arr[i+1];
            }else{
                if(arr[i+1]<min)
                    min=arr[i+1];
                if (arr[i]>max)
                    max=arr[i];
            }

            if(arr.length%2==1){
                if(arr[arr.length-1]>max)max=arr[arr.length-1];
            }else if(arr[arr.length-1]<min)min=arr[arr.length-1];

        }

        System.out.println("max in array is"+" "+max+" "+"min in array is"+" "+min);

    }

    public static void main(String[] args) {
        int arr[]={1,5,6,-2,3,4,8,9,3,2,9,10};
        findMinAndMax(arr);
    }











}
