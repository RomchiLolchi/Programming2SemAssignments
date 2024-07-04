import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sort.bubble.BubbleSort;
import sort.insertion.InsertionSort;
import sort.selection.SelectionSort;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortTests {

    @ParameterizedTest
    @MethodSource("arraysAndSortedArraysProvider")
    void bubbleSortTest(Integer[] array, Integer[] expected) {
        assert Arrays.equals(BubbleSort.bubbleSorting(array), expected);
    }

    @ParameterizedTest
    @MethodSource("arraysAndSortedArraysProvider")
    void insertionSortTest(Integer[] array, Integer[] expected) {
        assert Arrays.equals(InsertionSort.insertionSort(array), expected);
    }

    @ParameterizedTest
    @MethodSource("arraysAndSortedArraysProvider")
    void selectionSortTest(Integer[] array, Integer[] expected) {
        assert Arrays.equals(SelectionSort.selectionSort(array), expected);
    }

    static Stream<Arguments> arraysAndSortedArraysProvider() {
        return Stream.of(
                Arguments.arguments(new Integer[]{64, 34, 25, 12, 22, 11, 90}, new Integer[]{11, 12, 22, 25, 34, 64, 90}),
                Arguments.arguments(new Integer[]{}, new Integer[]{}),
                Arguments.arguments(new Integer[]{1}, new Integer[]{1}),
                Arguments.arguments(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}),
                Arguments.arguments(new Integer[]{-1, -3, -2, 0}, new Integer[]{-3, -2, -1, 0}),
                Arguments.arguments(new Integer[]{5, 2, 9, 1, 5, 6}, new Integer[]{1, 2, 5, 5, 6, 9}),
                Arguments.arguments(new Integer[]{5, 5, 5, 1,}, new Integer[]{1, 5, 5, 5})
        );
    }
}
