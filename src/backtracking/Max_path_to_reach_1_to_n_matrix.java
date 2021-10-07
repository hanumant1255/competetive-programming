package backtracking;

public class Max_path_to_reach_1_to_n_matrix {

    static int count=0;
    public static void main(String[] args) {

        int [][]mat={
                {
                    1,2,3,4
                },
                {
                        4,5,6,7
                },
                {
                        8,9,10,11
                }
        };
        maxtixRec(mat,mat.length,mat[0].length,0,0,0);
        System.out.println(count);

    }

    private static void maxtixRec(int[][] mat, int m, int n, int i, int j, int idx) {

        if(i==m-1){
            count++;
            System.out.println("i "+count);

            return;
        }
        if(j==n-1){
            count++;
            System.out.println("j "+count);

            return;
        }
        maxtixRec(mat,m,n,i+1,j,idx++);
        maxtixRec(mat,m,n,i,j+1,idx++);

    }
}
