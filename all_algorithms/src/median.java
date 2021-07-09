import java.util.Arrays;

public class median {
    //find median in array
    //o(1)
    public static int findMedian(int arr[]){
        int med=arr[0];
        for (int i = 1; i < 64 && i< arr.length; i+=2) {
            if(arr[i]>med){
                med=arr[i];
            }else if(arr[i+1]>med){
                med=arr[i+1];
            }
        }
        return med;
    }

    //find all num tat are grater then median
    //o(n)
    public static int[] findMedArray(int [] a,int[]b){
        int c[]=new int[a.length];
        //if firs num in a is grater then last num in b
        if(a[0]>=b[b.length-1]){
            for (int k = 0; k < a.length; k++) {
                c[k]=a[k];
            }
            return c;
        }

        for (int i = 0 ,j=b.length-1; i < a.length && j>=0; i++,j--) {
            if(a[i]>b[j]){
                c[i]=a[i];
            }else{
                c[i]=b[j];
            }
        }

        return c;
    }

    public static void main(String[] args) {
        int []arr={1,20,34,100};
        int []b={5,8,10,32};
        int c[]={1,3,4,5,6,8,9};
        int d[]={10,87,64,23,445};
        int a[]=new int[70];
        for (int i = 0; i < a.length; i++) {
            a[i]=i;
        }
        System.out.println(Arrays.toString(findMedArray(arr,b)));
        System.out.println(Arrays.toString(findMedArray(d,c)));
        System.out.println(findMedian(a));



    }
}
