package basic.arrays;

public class RotateMatrix {

    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<=matrix.length-1;i++){
            for(int j=0;j<=matrix.length-1;j++){
                System.out.print(matrix[i][j]);
            }System.out.println();
        }
        System.out.println("****ROTATION******");
        rotate(matrix);
        for(int i=0;i<=matrix.length-1;i++){
            for(int j=0;j<=matrix.length-1;j++){
                System.out.print(matrix[i][j]);
            }System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n  - j -1 ][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
