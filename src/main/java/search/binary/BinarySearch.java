package search.binary;

//todo rename
public class BinarySearch {
    public static Integer binarySearch(Integer value, Integer[] array) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];
            if (guess == value) {
                return mid;
            }
            if (guess > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
