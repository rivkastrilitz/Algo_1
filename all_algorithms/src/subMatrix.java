public class subMatrix {

    //size of matrix
    public static int findsSize(int [][]mat){
        int n=mat.length;
        int m=mat[0].length;
        int help[][]=new int[n][m];
        int max=0;
        help[0][0]=mat[0][0];
        for (int i = 1; i < m ; i++) {
            help[0][i]=mat[0][i];
        }
        for (int i = 1; i < n; i++) {
            help[i][0]=mat[i][0];
        }

        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                if(mat[i][j]==1){
                    help[i][j] = ( findMin(help[i][j-1],help[i-1][j],help[i-1][j-1]) ) +1;
                    if(help[i][j]>max){
                        max=help[i][j];
                    }
                }else{
                    help[i][j]=0;
                }

            }

        }

        return max;
    }


    //number of matrix in size x
    //o(n)+o(m)+o(n*m)
    public static int findsNumberOf(int [][]mat,int x){
        int n=mat.length;
        int m=mat[0].length;
        int help[][]=new int[n][m];
        int counter=0;
        help[0][0]=mat[0][0];
        for (int i = 1; i < m ; i++) {
            help[0][i]=mat[0][i];
        }
        for (int i = 1; i < n; i++) {
            help[i][0]=mat[i][0];
        }

        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                if(mat[i][j]==1){
                    help[i][j] = ( findMin(help[i][j-1],help[i-1][j],help[i-1][j-1]) ) +1;
                    if(help[i][j]>=x){
                        counter++;
                    }
                }else{
                    help[i][j]=0;
                }

            }

        }

      return counter;
    }





    public static int findMin(int x,int y,int z){
       int min=Math.min(x,y);
       if(z<min){
           min=z;
       }
       return min;
    }

    public static void main(String[] args) {

        int matrix[][]=new int[3][4];
        matrix[0][0]=1;
        matrix[0][1]=1;
        matrix[0][2]=1;
        matrix[0][3]=1;
        matrix[1][0]=1;
        matrix[1][1]=1;
        matrix[1][2]=1;
        matrix[1][3]=1;
        matrix[2][0]=1;
        matrix[2][1]=1;
        matrix[2][2]=0;
        matrix[2][3]=0;
        System.out.println(findsSize(matrix));
        System.out.println(findsNumberOf(matrix,2));



    }


}
