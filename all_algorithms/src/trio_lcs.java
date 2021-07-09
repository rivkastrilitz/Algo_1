public class trio_lcs {

    public static int[][][] lcsFor3(String s1,String s2,String s3 ){

        int mat[][][]=new int[s1.length()][s2.length()][s3.length()];
        for (int x = 0; x < s1.length(); x++) {
            mat[x][0][0]=0;
        }
        for (int y = 0; y < s2.length(); y++) {
            mat[0][y][0]=0;
        }
        for (int z = 0; z < s3.length() ; z++) {
            mat[0][0][z]=0;
        }


        for (int x = 1; x < s1.length(); x++) {
            for (int y = 1; y < s2.length(); y++) {
                for (int z = 1; z < s3.length(); z++) {
                    if(s1.charAt(x-1)==s2.charAt(y-1)&& s2.charAt(y-1)==s3.charAt(z-1)){
                        mat[x][y][z]=mat[x-1][y-1][z-1];

                    }else{
                        int a =mat[x-1][y][z];
                        int b=mat[x][y-1][z];
                        int c=mat[x][y][z-1];
                        mat[x][y][z]=findMax(a,b,c);
                    }
                }
            }
        }

     return mat;
    }



public static int findMax(int x,int y,int z){
        int max=x;
        if(y>max){
            max=y;
        }
        if(z>max){
            max=z;
        }
        return max;
}
}
