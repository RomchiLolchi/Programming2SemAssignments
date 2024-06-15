package sort.bubble;

public class BubbleSort {
    public int[] bubbleSorting(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
