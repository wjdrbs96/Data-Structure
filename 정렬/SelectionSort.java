package Algorithm;

public class SelectionSort {
    public static void main(String[] args){
        int[] list = {5,3,8,1,2,7};
        int tmp, min;

        for(int i=0; i<list.length-1; i++){
            min = i;
            for(int j=i+1;j<list.length; j++){
                if(list[min] > list[j]) min = j;
            }
            tmp = list[i];
            list[i] = list[min];
            list[min] = tmp;
        }

        for(int k =0; k<list.length; k++){
            System.out.print(list[k] + " ");
        }
    }
}
