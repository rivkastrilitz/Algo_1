public class lis_number2 {
    public static int [] findlis(int arr[]){
        int mat[][]=new int[arr.length][arr.length];
        mat[0][0]=arr[0];
        int lis_len=1;
        int index=0;

        for (int i = 1; i < arr.length ; i++) {
            index=binaryserch(mat,arr[i],lis_len);//return num of the row
            copy(mat,index);
            mat[index][index]=arr[i];
            if (index==lis_len){
                lis_len++;
            }
        }
        int ans[]=new int[lis_len];
        for (int i = 0; i < lis_len; i++) {
            ans[i]=mat[lis_len-1][i];
        }

        return ans;
    }

    public static int[][]copy(int mat[][],int index){
        for (int i = 0; i < index; i++) {
            mat[index][i]=mat[index-1][i];

        }
        return mat;
    }
    public static int binaryserch(int mat[][],int i,int lis_length){
        int start=0,end=lis_length;

        if(i<mat[0][0])return 0;
        if(i>mat[lis_length-1][lis_length-1])return lis_length;

        while (start<=end){
            if(start==end)return start;
            int mid=(start+end)/2;
            if(mat[mid][mid]==i)return mid;
            if(mat[mid][mid]<i){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return -1;


    }
    //////////////part 2///////////////////

    public static int findLislen(int arr[],int k){
        if(arr.length==1&&k!=0)return -1;
        int mat[][]=new int[arr.length][arr.length];
        mat[0][0]=arr[0];
        int lis_len=1;
        int index=0;

        for (int i = 1; i < arr.length ; i++) {
            if (Math.abs(arr[i] - mat[index][index]) == k) {
                index++;
                copy(mat, index);
                mat[index][index] = arr[i];
                if (index == lis_len) {
                    lis_len++;
                }
            }
        }

        return lis_len;

    }


}
