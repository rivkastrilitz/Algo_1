public class LCS {

    //o(n*m)
    public static int[][]build_matrix(String a,String b){
        int row= a.length()+1,col=b.length()+1;
        int matrix[][]=new int [row][col]; //in row we put a and in col b
        for (int i = 0; i <row ; i++) {
            matrix[i][0]=0;
        }
        for (int i = 0; i <col ; i++) {
            matrix[0][i]=0;
        }

        for (int i = 1; i <row ; i++) {
            for (int j = 1; j < col; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                }else{
                    matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-1]);
                }
            }
        }

        return matrix;
    }

    public static int lcslen(String a,String b){
       int mat[][]= build_matrix(a,b);
       return mat[mat.length-1][mat[0].length-1];
    }

    //o(n+m)
    public static String findLCS(String A,String B){
        int matrix[][]=build_matrix(A,B);
        int row=matrix.length,col=matrix[0].length;
        int LCSlength=matrix[row-1][col-1];
        String ans="";
        int i=row-1,j=col-1;
        int k=LCSlength-1;
        while (k>=0){
            if(A.charAt(i-1)==B.charAt(j-1)){
                ans=A.charAt(i-1)+ans;
                i--;
                j--;
                k--;
            }else if(matrix[i][j]==matrix[i][j-1]) {
                j--;
            }else i--;
        }

        return ans;
    }

    //אלגוריתם המוצא את המחרוזת הקצרה ביותר כך שאס אחד ואס שתיים תתי מחרוזות שלה
//    public static String findminforSub(String s1,String s2){
//
//        String lcs=findLCS(s1,s2);
//        int len=s1.length()+s2.length()-lcs.length();
//        int i=0,j=0,l=0;
//        String ans="";
//        while (len>0){
//            if(s1.charAt(i)==lcs.charAt(l)){
//
//                while(s2.charAt(j)!=lcs.charAt(l)){
//                    ans=ans+s2.charAt(j);
//                    j++;
//                    len--;
//                }
//                ans=ans+s1.charAt(i);
//                i++;
//                j++;
//                l++;
//                len--;
//
//            }else if(s2.charAt(j)==lcs.charAt(l)){
//                while(s1.charAt(i)!=lcs.charAt(l)){
//                    ans=ans+s1.charAt(i);
//                    i++;
//                    len--;
//                }
//                ans=ans+s2.charAt(j);
//                i++;
//                j++;
//                l++;
//                len--;
//            }
//            else{
//                ans=ans+s1.charAt(i);
//                i++;
//                ans=ans+s2.charAt(j);
//                j++;
//                len=len-2;
//            }
//        }
//        return ans;
//
//    }
    public static String longestContains(String s1,String s2){
        String lcs = findLCS(s1,s2);
        String ans = "";
        int i = 0 , j = 0 , k = 0;
        while(k < lcs.length() && i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)&&s2.charAt(j) == lcs.charAt(k)){
                ans+= s1.charAt(i);
                i++;
                j++;
                k++;
            }
            else{
                if(s1.charAt(i) == lcs.charAt(k)){
                    ans += s2.charAt(j++);

                }
                else{
                    if(s2.charAt(j) == lcs.charAt(k)){
                        ans += s1.charAt(i++);
                    }
                    else{
                        ans += s1.charAt(i++);
                        ans += s2.charAt(j++);}

                }
            }
        }

        while(i < s1.length()){
            ans += s1.charAt(i++);
        }
        while(j < s2.length()){
            ans+= s2.charAt(j++);
        }
        return ans;
    }

    public static void main(String[] args) {
        String a="amastryttt";
        String b="ahastrrt";
        System.out.println(lcslen(a,b));
        System.out.println(findLCS(a,b));
        System.out.println(longestContains("abcbdab","bdcaba"));
    }


}
