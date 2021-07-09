public class my_airplain {

    public static double shortPath(node[][] mat) {
        int n = mat[0].length;
        int m = mat.length;

        mat[0][0].total=0;

        for (int i = 1; i < m; i++) {

            mat[i][0].total = mat[i - 1][0].y + mat[i - 1][0].total;
            mat[i][0].num_path = 1;
        }

        for (int i = 1; i < n; i++) {

            mat[0][i].total = mat[0][i - 1].x + mat[0][i - 1].total;
            mat[0][i].num_path = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                double a = mat[i - 1][j].total + mat[i - 1][j].y;
                double b = mat[i][j - 1].total + mat[i][j - 1].x;
                if (a < b) {
                    mat[i][j].total = a;
                    mat[i][j].num_path = mat[i - 1][j].num_path;
                }
                if (a >b) {
                    mat[i][j].total = b;
                    mat[i][j].num_path = mat[i][j - 1].num_path;
                }
                if (a == b) {
                    mat[i][j].total = b;
                    mat[i][j].num_path = mat[i][j - 1].num_path + mat[i - 1][j].num_path;

                }
            }
        }
        return mat[m - 1][n - 1].total;
    }
    /**
     * returns true if the given point is on one of the shortest paths
     * Complexity: O(n*m) but if we call buildMatrixFromTheEnd() first and then call isOnBestPath
     * the answer is in O(1)
     */
    public boolean isOnBestPath(node [][]mat, int i,int j) {
        buildMatrixFromTheEnd(mat);
        double cheapestPrice=shortPath(mat);
        return (mat[i][j].total + mat[i][j].totalFromEnd) == cheapestPrice;
    }

    /**
     * the same like build matrix but now we build it from the end to (0,0)
     * Complexity: O(n*m)
     */
    private void buildMatrixFromTheEnd(node mat [][]){
        int n = mat.length-1, m = mat[0].length-1;
        for (int i = n-1; i >= 0; i--){
            mat[i][m].totalFromEnd = mat[i][m].y +  mat[i+1][m].totalFromEnd;
        }
        for (int j = m-1; j >= 0; j--){
            mat[n][j].totalFromEnd = mat[n][j+1].totalFromEnd +  mat[n][j].x;
        }
        for (int i = n-1; i >= 0; i--){
            for (int j = m-1; j >= 0; j--){
                double y = mat[i+1][j].totalFromEnd + mat[i][j].y;
                double x = mat[i][j+1].totalFromEnd + mat[i][j].x;
                mat[i][j].totalFromEnd = x <= y ? x : y;
            }
        }
    }


    public static int minPriceWuthDeadArea(node[][] mat, Point p1, Point p2) {
        node[][] mat2 = createNewMatrix(mat, p1, p2);
        return minPrice(mat2);
    }

    private static node[][] createNewMatrix(node[][] mat, Point p1, Point p2) {
        int n = mat.length;
        int m = mat[0].length;
        node[][] newMat = new node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i >= p1.y && i <= p2.y && j >=p1.x && j <= p2.x) {
                    newMat[i][j] = new node(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
                }
                else {
                    newMat[i][j] = new node(mat[i][j].x, mat[i][j].y);
                }
            }
        }
        return newMat;
    }

    public static int minPrice(node[][] mat) {
        int n = mat.length, m = mat[0].length;
        mat[0][0].total = 0;
        for (int i = 1; i < n; i++) { mat[i][0].total = mat[i-1][0].total + mat[i-1][0].y;}
        for (int i = 1; i < m; i++) { mat[0][i].total = mat[0][i-1].total + mat[0][i-1].x;}
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j].total = Math.min(mat[i-1][j].total + mat[i-1][j].y, mat[i][j-1].total + mat[i][j-1].x);
            }
        }
        if(mat[n-1][m-1].total == Double.POSITIVE_INFINITY) return -1;
        return (int) mat[n-1][m-1].total;
    }


    public static void main(String[] args) {
        node[][] mat = new node[4][4];
        mat[0][0] = new node(1, 2);
        mat[0][1] = new node(1, 1);
        mat[0][2] = new node(1, 3);
        mat[0][3] = new node(0, 1);

        mat[1][0] = new node(2, 3);
        mat[1][1] = new node(5, 1);
        mat[1][2] = new node(6, 3);
        mat[1][3] = new node(0, 1);

        mat[2][0] = new node(2, 4);
        mat[2][1] = new node(7, 1);
        mat[2][2] = new node(2, 3);
        mat[2][3] = new node(0, 1);

        mat[3][0] = new node(2, 0);
        mat[3][1] = new node(1, 0);
        mat[3][2] = new node(1, 0);
        mat[3][3] = new node(0, 0);


        System.out.println(shortPath(mat));

    }


   static class node {
        double x, y, total,totalFromEnd;
        int num_path ;

        public node(double x, double y) {
            this.x = x;
            this.y = y;
            this.total = 0;
            this.num_path = 0;
            this.totalFromEnd = 0;
        }




    }




    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }

    }


}