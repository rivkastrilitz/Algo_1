public class Numbers_game {

    //מטריצה עם הפרשים
    public static int[][] build_mat(int game[]){
        int mat[][]=new int[game.length][game.length];
        int a=0,b=0;

        for (int i = 0; i < mat.length; i++) {
            mat[i][i]=game[i];
        }
        int n=mat.length;

        for (int i = mat.length-3; i >=0 ; i--) {
            for (int j = i+1; j< mat.length  ; j++) {

                mat[i][j]=Math.max(mat[j][j]-mat[i][j-1],mat[i][i]-mat[i+1][j]);
            }

        }
        return mat;
    }
    public static int find_best_div(int arr[]){
        int mat[][]=build_mat(arr);
        return mat[0][mat.length-1];
    }


    public  static void game(int arr[]){
        int i=0,j=arr.length-1;
        int mat[][]=build_mat(arr);
        int first=0;
        int second=0;
        for (int k = 0; k < arr.length/2; k++) {
            if(mat[i][i]-mat[i+1][j]>mat[j][j]-mat[i][j-1]){
               first+= arr[i];
               i++;
            }else{
                first+=arr[j];
                j--;
            }
            if(i!=j){
                if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1]){
                    second+= arr[i];
                    i++;
                }else{
                    second+=arr[j];
                    j--;
                }

            }else{
                second+=arr[i];
            }

        }
        if(arr.length%2==1){
            first+=arr[i];
        }

        System.out.println("first sum ="+first+" "+"second sum ="+second);


    }

    public static void main(String[] args) {
        int arr[]={1,3,5,6,8};
        System.out.println(find_best_div(arr));
        game(arr);
    }






}
