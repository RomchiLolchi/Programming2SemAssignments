package determinant;

import java.util.Arrays;

public class Matrix {
    public static Float determinant(Float[][] matrix, Integer size) {
        if (size == 1) return matrix[0][0];
        if (size == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double result = 0;
        Float[][] submatrix;
        for (int column = 0; column < matrix.length; column++) {
            submatrix = new Float[matrix.length - 1][matrix.length - 1];
            Float[][] rowTrimmedArray = Arrays.copyOfRange(matrix, 1, matrix.length);
            for (int row = 0; row < rowTrimmedArray.length; row++) {
                Float[] firstHalf = Arrays.copyOfRange(rowTrimmedArray[row], 0, column);
                Float[] secondHalf = Arrays.copyOfRange(rowTrimmedArray[row], column + 1, rowTrimmedArray[row].length);
                Float[] completeNewRow = Arrays.copyOf(firstHalf, firstHalf.length + secondHalf.length);
                System.arraycopy(secondHalf, 0, completeNewRow, firstHalf.length, secondHalf.length);
                submatrix[row] = completeNewRow;
            }
            result += matrix[0][column] * determinant(submatrix, submatrix.length) * Math.pow(-1, column % 2);
        }
        return (float) result;
    }
}