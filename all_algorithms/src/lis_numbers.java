import java.util.Arrays;

public class lis_numbers {


    public static int lisLen(int arr[]){
        int ans[]=new int[arr.length];
        ans[0]=arr[0];

        int lis_len=1;
        for (int i = 1; i < arr.length ; i++) {
            int index= Arrays.binarySearch(ans,0,lis_len,arr[i]);
            if(index<0)index=-index-1;
            ans[index]=arr[i];
            if(index==lis_len){
                lis_len++;
            }
        }
        return lis_len;
    }

    public static int[] lis(int[] arr){

        int mat[][]=new int [arr.length][arr.length];
        mat[0][0]=arr[0];
        int lis_len=1;
        for (int i = 1; i < arr.length; i++) {
            int index=binarySearchBetween(mat,lis_len,arr[i]);

            if(index==lis_len){
                lis_len++;
            }
            mat[index][index]=arr[i];
            //copy
            for (int j = 0; j < index; j++) {
                mat[index][j]=mat[index-1][j];
            }
        }
        //insert to ans
        int []ans=new int[lis_len];
        for (int i = 0; i < lis_len; i++) {
            ans[i]=mat[lis_len-1][i];

        }

        return ans;
    }
    private static int binarySearchBetween(int[][] mat, int end, int v) {
        if(v > mat[end-1][end-1]) return end;
        if(v < mat[0][0]) return 0;
        int high = end, low = 0;
        while(low <= high) {
            if(low == high)return low;
            int mid = (low + high)/2;
            if(mat[mid][mid] == v) return mid;
            if(mat[mid][mid] > v) high = mid;
            else low = mid+1;
        }
        return -1;
    }




    public static void main(String[] args) {
        System.out.println(lisLen(new int[]{1,3,10,8,9,6}));
        System.out.println(Arrays.toString(lis(new int[]{1,3,10,8,9,6})));
    }

}
