import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sort.bubble.BubbleSort;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortTests {

    private static final BubbleSort bubbleSort = new BubbleSort();

    @ParameterizedTest
    @MethodSource("arraysAndSortedArraysProvider")
    void bubbleSortTest(int[] array, int[] expected) {
        System.out.println(Arrays.toString(bubbleSort.bubbleSorting(array)));
        assert Arrays.equals(bubbleSort.bubbleSorting(array), expected);
    }

    static Stream<Arguments> arraysAndSortedArraysProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{64, 34, 25, 12, 22, 11, 90}, new int[]{11, 12, 22, 25, 34, 64, 90}),
                Arguments.arguments(new int[]{}, new int[]{}),
                Arguments.arguments(new int[]{1}, new int[]{1}),
                Arguments.arguments(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.arguments(new int[]{-1, -3, -2, 0}, new int[]{-3, -2, -1, 0})
        );
    }
}
