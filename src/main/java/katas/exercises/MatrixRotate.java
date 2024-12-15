package katas.exercises;

public class MatrixRotate {

    /**
     * Rotates the given square matrix 90 degrees clockwise in place.
     *
     * @param matrix the 2D square matrix to rotate
     */
    public static void rotateMatrix(int[][] matrix) {
        int len = matrix.length;
        int[][] result = new int[len][len];
        int cnt = 0, i, j;
        for (int[] row : matrix) {
            for (int num : row) {
                i = (cnt % len);
                j = (len - 1) - (cnt / len) % (len);

                result[i][j] = num;
                cnt++;
            }
        }
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                matrix[i][j] = result[i][j];
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("Matrix after 90-degree clockwise rotation:");
        printMatrix(matrix);
    }

    /**
     * Helper method to print a 2D matrix.
     *
     * @param matrix the matrix to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
