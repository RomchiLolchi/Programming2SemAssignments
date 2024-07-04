package search.linear;

public class StaticList {
    public static Integer linearSearch(Integer value, Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}
