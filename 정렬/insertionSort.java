package Data_Structure.정렬;

public class insertionSort {
    public static void main(String[] args){
        int[] list = {5,3,8,1,2,7};
        int i, j, tmp, key;

        for (i = 1; i < list.length; i++){
            key = list[i];
            for (j = i - 1; j >= 0 && key < list[j]; j--){
                list[j + 1] = list[j];
            }
            list[j + 1] = key;
        }

        for (int k = 0; k < list.length; k++){
            System.out.print(list[k] + " ");
        }
    }
}
