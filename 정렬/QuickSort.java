package Data_Structure.정렬;

public class QuickSort {
    static int partition(int[] list, int left, int right){

        int pivot;
        pivot = list[left];

        while (left < right) {
            while ((list[left] < pivot) && (left < right))
                left++;
            while ((list[right] > pivot) && (left < right))
                right--;

            if (left < right) {
                int temp = list[left];
                list[left] = list[right];
                list[right] = temp;
            }
        }

        return left;
    }


    static void quick_sort(int[] list, int left, int right){
        if(left < right){
            int q = partition(list, left, right);
            quick_sort(list, left,q - 1);
            quick_sort(list,q + 1, right);
        }
    }

    public static void main(String[] args){
        int[] list = {5,3,8,4,9,1,6,2,7};
        quick_sort(list,0,list.length-1);

        for(int i=0; i<list.length; i++){
            System.out.print(list[i] + " ");
        }

    }
}
