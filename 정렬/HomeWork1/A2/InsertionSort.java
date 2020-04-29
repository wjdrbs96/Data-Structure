package Data_Structure.정렬.HomeWork1.A2;

public class InsertionSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable key;

        int j = 0;
        for (int i = 1; i < n; ++i) {
            key = a[i];
            j = i - 1;

            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }
}
