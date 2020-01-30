package Data_Structures;

public class BinarySearch {
    static int[] list = {1, 3, 5, 6, 7, 9, 11, 20, 30};
    public static void main(String[] args) {
        System.out.println(Binary_Search(5, 0, list.length - 1));
        // 해당 값의 인덱스를 return, 없으면 -1 return
    }

    public static int Binary_Search(int key, int left, int right) {
        int mid;

        if (left <= right) {
            mid = (left + right) / 2;
            if (key == list[mid]) return mid;

            else if (key > list[mid]) {
                return Binary_Search(key, mid + 1, right);
            }

            else {
                return Binary_Search(key, left, mid - 1);
            }
        }

        return -1;
    }
}
