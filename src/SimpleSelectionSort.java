//简单选择排序，选择数组中最小的数，与数组左端交换，交换过后将左端下标+1
public class SimpleSelectionSort {
    public static void sort(Comparable[] array){
        int min;
        int len = array.length;
        for(int i = 0;i<len-1;i++){
            min = i;
            for (int j=min+1;j<len;j++){
                if (ArrayUtil.less(array[j],array[min])){
                    min = j;
                }
            }
            if (i!=min){
                ArrayUtil.swap(array,i,min);
            }
        }
    }
}
