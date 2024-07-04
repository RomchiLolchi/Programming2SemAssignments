package sort.selection;

//todo rename
public class SelectionSort {
    public static Integer[] selectionSort(Integer[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
