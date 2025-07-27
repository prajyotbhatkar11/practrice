package practice.strivers;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        System.out.println(matrix.length);
        System.out.println(Arrays.deepToString(setMatrixZeroBrutForce(matrix)));
    }

    public static int[][] setMatrixZeroBrutForce(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    setRow(matrix,i);
                    setColumn(matrix,j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
    public static void setRow(int[][] matrix, int i) {
        for (int j =0; j<matrix[i].length;j++){
            if (matrix[i][j] !=0){
                matrix[i][j] = -1;
            }
        }

    }

    public static void setColumn(int[][] matrix, int  j) {
        for (int i =0; i<matrix.length;i++){
            if (matrix[i][j] !=0){
                matrix[i][j] = -1;
            }
        }
    }
}
