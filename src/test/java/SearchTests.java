import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import search.binary.BinarySearch;
import search.linear.StaticList;

import java.util.stream.Stream;

public class SearchTests {

    @ParameterizedTest
    @MethodSource("arraysAndIndexesProvider")
    void linearSearchTest(int target, Integer[] array, int expected) {
        assert StaticList.linearSearch(target, array) == expected;
    }

    @ParameterizedTest
    @MethodSource("sortedArraysAndIndexesProvider")
    void binarySearchTest(int target, Integer[] array, int expected) {
        assert BinarySearch.binarySearch(target, array) == expected;
    }

    static Stream<Arguments> arraysAndIndexesProvider() {
        return Stream.of(
                Arguments.arguments(7, new Integer[]{5, 3, 7, 1, 9, 8}, 2),
                Arguments.arguments(10, new Integer[]{5, 3, 7, 1, 9, 8}, -1),
                Arguments.arguments(5, new Integer[]{}, -1),
                Arguments.arguments(1, new Integer[]{1, 2, 3, 4, 5}, 0),
                Arguments.arguments(5, new Integer[]{1, 2, 3, 4, 5}, 4),
                Arguments.arguments(2, new Integer[]{4, 2, 5, 2, 3, 5, 1, 2, 5}, 1)
        );
    }

    static Stream<Arguments> sortedArraysAndIndexesProvider() {
        return Stream.of(
                Arguments.arguments(4, new Integer[]{1, 2, 3, 4, 5, 6}, 3),
                Arguments.arguments(6, new Integer[]{1, 2, 3, 4, 5, 6}, 5),
                Arguments.arguments(1, new Integer[]{1, 2, 3, 4, 5, 6}, 0),
                Arguments.arguments(7, new Integer[]{1, 2, 3, 4, 5, 6}, -1),
                Arguments.arguments(5, new Integer[]{}, -1),
                Arguments.arguments(-10, new Integer[]{-10, -5, 0, 5, 10}, 0),
                Arguments.arguments(10, new Integer[]{-10, -5, 0, 5, 10}, 4),
                Arguments.arguments(4, new Integer[]{4}, 0),
                Arguments.arguments(3, new Integer[]{4}, -1)
        );
    }
}
