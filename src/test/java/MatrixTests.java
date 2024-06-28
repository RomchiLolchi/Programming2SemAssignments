import determinant.Matrix;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MatrixTests {

    @ParameterizedTest
    @MethodSource("matricesAndDeterminantsProvider")
    void determinantTest(Float[][] matrix, int expected) {
        assert Matrix.determinant(matrix, matrix.length) == expected;
    }

    static Stream<Arguments> matricesAndDeterminantsProvider() {
        return Stream.of(
                Arguments.arguments(new Float[][]{{1f, 2f}, {3f, 4f}}, -2),
                Arguments.arguments(new Float[][]{{1f, 2f, 4f}, {3f, 4f, 2f}, {0f, 2f, 4f}}, 12),
                Arguments.arguments(new Float[][]{{1f, 0f, 2f, -1f}, {3f, 0f, 0f, 5f}, {2f, 1f, 4f, -3f}, {1f, 0f, 5f, 0f}}, 30),
                Arguments.arguments(new Float[][]{{2f, 9f, 4f}, {7f, 5f, 3f}, {6f, 1f, 8f}}, -360),
                Arguments.arguments(new Float[][]{{4f, 0f, 0f, 0f, 1f}, {0f, 3f, 0f, 0f, 1f}, {0f, 0f, 2f, 0f, 1f}, {0f, 0f, 0f, 1f, 1f}, {1f, 1f, 1f, 1f, 1f}}, -26),
                Arguments.arguments(new Float[][]{{1f, 0f, 0f, 0f, 0f, 0f}, {0f, 2f, 0f, 0f, 0f, 0f}, {0f, 0f, 3f, 0f, 0f, 0f}, {0f, 0f, 0f, 4f, 0f, 0f}, {0f, 0f, 0f, 0f, 5f, 0f}, {0f, 0f, 0f, 0f, 0f, 6f}}, 720),
                Arguments.arguments(new Float[][]{{1f, 0f, 0f, 0f, 0f, 0f, 0f}, {0f, 1f, 0f, 0f, 0f, 0f, 0f}, {0f, 0f, 1f, 0f, 0f, 0f, 0f}, {0f, 0f, 0f, 1f, 0f, 0f, 0f}, {0f, 0f, 0f, 0f, 1f, 0f, 0f}, {0f, 0f, 0f, 0f, 0f, 1f, 0f}, {0f, 0f, 0f, 0f, 0f, 0f, 1f}}, 1)
        );
    }
}