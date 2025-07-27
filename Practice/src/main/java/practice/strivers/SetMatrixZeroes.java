package practice.strivers;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        System.out.println(matrix.length);
//        System.out.println(Arrays.deepToString(setMatrixZeroBrutForce(matrix)));
        System.out.println(Arrays.deepToString(setMatrixZeroOptimal(matrix)));
    }

    public static int[][] setMatrixZeroBrutForce(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    setRow(matrix, i);
                    setColumn(matrix, j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    public static void setRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }

    }

    public static void setColumn(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public static int[][] setMatrixZeroOptimal(int[][] matrix) {
        //int row = matrix[..][0]
        //int col = matrix[0][..]
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0){
            for (int j = 0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0){
            for (int i = 0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
