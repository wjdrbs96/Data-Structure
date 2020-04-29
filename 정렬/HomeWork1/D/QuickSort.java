package Data_Structure.정렬.HomeWork1.D;

public class QuickSort {

    public static int partition(Comparable[] a, int left, int right) {
        Comparable pivot;
        pivot = a[left];

        while (left < right) {
            while (a[left].compareTo(pivot) < 0 && left < right) {
                left++;
            }
            while (a[right].compareTo(pivot) > 0 && left < right) {
                right--;
            }

            if (left < right) {
                Comparable temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }

        return left;
    }

    public static void sort(Comparable[] a, int left, int right) {
        if (left < right) {
            int q = partition(a, left, right);
            sort(a, left, q - 1);
            sort(a, q + 1, right);
        }
    }

}
