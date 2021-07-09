import java.util.ArrayList;
import java.util.List;

public  class airplane_problem {
    static class node
    {
        double x , y, total;
        int num_path;
        public node(double y,double x)
        {
            this.x = x;
            this.y = y;
            this.total = Double.MAX_VALUE;
            this.num_path = 1;
        }
    }
    public static void create_way_to_airplane(node[][] mat)
    {
        for (int i = 0; i < mat[0].length; i++) {
            if(i == 0)
                mat[0][i].total =0;
            else
                mat[0][i].total = mat[0][i-1].total + mat[0][i-1].x;
        }
        for (int i = 1; i <mat.length ; i++) {
            mat[i][0].total = mat[i-1][0].total + mat[i-1][0].y;
        }
        for (int i = 1; i <mat.length ; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if((mat[i-1][j].y+mat[i-1][j].total) == (mat[i][j-1].x+mat[i][j-1].total)) {
                    mat[i][j].total = mat[i - 1][j].y + mat[i - 1][j].total;
                    mat[i][j].num_path = mat[i - 1][j].num_path + mat[i][j-1].num_path;
                }
                else if((mat[i-1][j].y+mat[i-1][j].total) < (mat[i][j-1].x+mat[i][j-1].total))
                {
                    mat[i][j].total = mat[i - 1][j].y + mat[i - 1][j].total;
                    mat[i][j].num_path = mat[i - 1][j].num_path;
                }
                else
                {
                    mat[i][j].total = mat[i][j-1].x + mat[i][j-1].total;
                    mat[i][j].num_path = mat[i][j-1].num_path;
                }
            }
        }
    }
    public static double shotest_path_airplane(node[][] mat)
    {
        create_way_to_airplane(mat);
        int row_size = mat.length, col_size = mat[0].length;
        return mat[row_size-1][col_size-1].total;
    }
    public static int number_of_short_path(node[][]mat)
    {
        create_way_to_airplane(mat);
        int row_size = mat.length, col_size = mat[0].length;
        return mat[row_size-1][col_size-1].num_path;
    }

    public static String one_short_path(node[][]way)
    {
        create_way_to_airplane(way);
        String short_path = "";
        int i = way.length-1 ,j= way[0].length-1;

        while (i>0 && j>0)
        {
            if(way[i-1][j].y+way[i-1][j].total == way[i][j].total)
            {
                short_path = short_path + '1';
                i--;
            }
            else
            {
                short_path = short_path + '0';
                j--;
            }
        }
        while(j>0)
        {
            short_path = short_path + '0';
            j--;
        }
        while(i>0)
        {
            short_path = short_path + '1';
            i--;
        }
        return short_path;
    }

    
    public static List<String> all_short_path(long number , node[][]way)
    { String path = "";
        List<String> all_path = new ArrayList<>();
        while(all_path.size()<number)
        {
            create_path(all_path,way,way.length,way[0].length,path);
        }
        return all_path;
    }
    public static void create_path(List<String> all_path,node[][] mat,int i, int j,String path)
    {
        if(i>0 && j>0)
        {
            if((mat[i-1][j].total + mat[i-1][j].y)==(mat[i][j-1].total + mat[i][j-1].x) )
            {
                String new_path = path + '1';
                create_path(all_path,mat,i-1,j,new_path );
                create_path(all_path,mat,i,j-1,path + '0');
            }
            else if((mat[i-1][j].total + mat[i-1][j].y) < (mat[i][j-1].total + mat[i][j-1].x))
            {
                create_path(all_path,mat,i-1,j,path + '1');
            }
            else
            {
                create_path(all_path,mat,i,j-1,path + '0');
            }
        }
        else if(i == 0 && j == 0)
            all_path.add(path);
        else if(i>0)
        {
            while(i>0) {
                path = path + '1';
                i--;
            }
            all_path.add(path);
        }
        else if(j>0)
        {
            while(j>0) {
                path = path + '0';
                j--;
            }
            all_path.add(path);
        }
    }
    public static void main (String [] args)
    {
        node [][] way = new node[4][4];
        way[0][0] = new node(4,2);
        way[0][1] = new node(2,3);
        way[0][2] = new node(10,1);
        way[0][3] = new node(9,0);

        way[1][0] = new node(2,5);
        way[1][1] = new node(1,3);
        way[1][2] = new node(2,4);
        way[1][3] = new node(1,0);

        way[2][0] = new node(1,2);
        way[2][1] = new node(6,7);
        way[2][2] = new node(1,2);
        way[2][3] = new node(1,0);

        way[3][0] = new node(0,5);
        way[3][1] = new node(0,1);
        way[3][2] = new node(0,3);
        way[3][3] = new node(0,0);
        System.out.println(shotest_path_airplane(way));
    }
}