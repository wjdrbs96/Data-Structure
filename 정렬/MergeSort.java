package Data_Structure.정렬;

public class MergeSort {
    static int[] sorted = new int[8];

    public static void merge(int list[], int left, int mid, int right){
        int i = left, j = mid + 1, k = left, l;

        while(i <= mid && j <= right) {
            if (list[i] <= list[j]) {
                sorted[k++] = list[i++];
            } else {
                sorted[k++] = list[j++];
            }
        }

        if (i > mid){
            for (l = j; l <= right; l++){
                sorted[k++] = list[l];
            }
        }
        else {
            for (l = i; l <= mid; l++){
                sorted[k++] = list[l];
            }
        }

        for (l = left; l <= right; l++){
            list[l] = sorted[l];
        }
    }

    public static void merge_sort(int list[], int left, int right){
        int mid;
        if (left < right){
            mid = (left + right) / 2;
            merge_sort(list, left, mid);
            merge_sort(list,mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    public static void main(String[] args){
        int[] list = {27, 10, 12, 20, 25, 13, 15, 22};
        merge_sort(list,0,list.length - 1);

        for (int q = 0; q < list.length; q++){
            System.out.print(list[q] + " ");
        }

    }
}
