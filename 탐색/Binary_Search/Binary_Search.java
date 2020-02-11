package Data_Structure.탐색.Binary_Search;

public class Binary_Search {
    static int[] list = {5, 3, 6, 7, 4, 2, 8, 10, 9, 1};

    public static int Search_binary(int key, int low, int high) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;
            if (key == list[mid]) {
                return mid;
            }
            else if (key < list[mid]) {
                return Search_binary(key, low, mid - 1);
            }
            else {
                return Search_binary(key, mid + 1, high);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Search_binary(3,0, list.length -1));

    }
}
