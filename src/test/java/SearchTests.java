import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import search.linear.LinearSearch;

import java.util.stream.Stream;

public class SearchTests {

    private static final LinearSearch linearSearch = new LinearSearch();

    @ParameterizedTest
    @MethodSource("arraysAndIndexesProvider")
    void linearSearchTest(int target, int[] array, int expected) {
        assert linearSearch.linearSearch(target, array) == expected;
    }

    static Stream<Arguments> arraysAndIndexesProvider() {
        return Stream.of(
                Arguments.arguments(7, new int[]{5, 3, 7, 1, 9, 8}, 2),
                Arguments.arguments(10, new int[]{5, 3, 7, 1, 9, 8}, -1),
                Arguments.arguments(5, new int[]{}, -1),
                Arguments.arguments(1, new int[]{1, 2, 3, 4, 5}, 0),
                Arguments.arguments(5, new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.arguments(2, new int[]{4, 2, 5, 2, 3, 5, 1, 2, 5}, 1)
        );
    }
}