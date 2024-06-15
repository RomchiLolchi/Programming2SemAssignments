import determinant.Determinant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DeterminantTests {

    private static final Determinant determinant = new Determinant();

    @ParameterizedTest
    @MethodSource("matricesAndDeterminantsProvider")
    void determinantTest(int[][] matrix, int expected) {
        assert determinant.determinant(matrix, matrix.length) == expected;
    }

    static Stream<Arguments> matricesAndDeterminantsProvider() {
        return Stream.of(
                Arguments.arguments(new int[][]{{1, 2}, {3, 4}}, -2),
                Arguments.arguments(new int[][]{{1, 2, 4}, {3, 4, 2}, {0, 2, 4}}, 12),
                Arguments.arguments(new int[][]{{1, 0, 2, -1}, {3, 0, 0, 5}, {2, 1, 4, -3}, {1, 0, 5, 0}}, 30),
                Arguments.arguments(new int[][]{{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, -360),
                Arguments.arguments(new int[][]{{4, 0, 0, 0, 1}, {0, 3, 0, 0, 1}, {0, 0, 2, 0, 1}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}}, -26),
                Arguments.arguments(new int[][]{{1, 0, 0, 0, 0, 0}, {0, 2, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0}, {0, 0, 0, 4, 0, 0}, {0, 0, 0, 0, 5, 0}, {0, 0, 0, 0, 0, 6}}, 720),
                Arguments.arguments(new int[][]{{1, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 1}}, 1)
        );
    }
}