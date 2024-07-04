package sort.insertion;

//todo rename
public class InsertionSort {
    public static Integer[] insertionSort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}