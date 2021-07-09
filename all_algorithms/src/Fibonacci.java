public class Fibonacci {

    public static int findFibo(int n) {
        int[][] ans = {{1, 1}, {1, 0}};
        int[][] a = {{1, 1}, {1, 0}};
        n=n-2;

        while(n!=0){
            if(n%2==1){
              ans=mulMat(a,ans);
            }
            a=mulMat(a,a);
            n=n/2;

        }
        return ans[0][0];
    }

    public static int[][] mulMat(int[][] m1, int[][] m2) {
        int[][] ans = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = m1[i][0]*m2[0][j] + m1[i][1]*m2[1][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findFibo(6));
    }





}
