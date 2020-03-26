package Data_Structure.정렬;

public class BubbleSort {
    static int[] list;
    public static void bubbleSort() {
        int tmp = 0;
        for (int i = list.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] > list[j + 1]) {
                    tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        list = new int[]{5, 3, 8, 1, 2, 7};
        bubbleSort();

        for (int k : list) {
            System.out.print(k + " ");
        }
    }
}
