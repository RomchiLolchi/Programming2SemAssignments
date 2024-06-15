package determinant;

import java.util.Arrays;

public class Determinant {
    public int determinant(int[][] array, int size) {
        if (size == 1) return array[0][0];
        if (size == 2) return array[0][0] * array[1][1] - array[0][1] * array[1][0];

        double result = 0;
        int[][] submatrix;
        for (int column = 0; column < array.length; column++) {
            submatrix = new int[array.length - 1][array.length - 1];
            int[][] rowTrimmedArray = Arrays.copyOfRange(array, 1, array.length);
            for (int row = 0; row < rowTrimmedArray.length; row++) {
                int[] firstHalf = Arrays.copyOfRange(rowTrimmedArray[row], 0, column);
                int[] secondHalf = Arrays.copyOfRange(rowTrimmedArray[row], column + 1, rowTrimmedArray[row].length);
                int[] completeNewRow = Arrays.copyOf(firstHalf, firstHalf.length + secondHalf.length);
                System.arraycopy(secondHalf, 0, completeNewRow, firstHalf.length, secondHalf.length);
                submatrix[row] = completeNewRow;
            }
            result += array[0][column] * determinant(submatrix, submatrix.length) * Math.pow(-1, column % 2);
        }
        return (int) result;
    }
}