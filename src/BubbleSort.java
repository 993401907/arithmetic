public class BubbleSort {

    public static void sort(Comparable[] array) {

        int len = array.length;
        int key = len - 1;
        //用来标记，如果未标记，则表示没有发生交换，说明数组有序
        int flag = 0;
        //用来记录发生交换时的位置，这个位置之后，数组有序
        int pos = 0;
        //进行正向遍历后，再进行反向遍历
        int start = 0;
        for (int i = 0; i < len - 1; i++) {
            flag = 0;
            for (int j = start; j < key; j++) {
                if (ArrayUtil.less(array[j+1],array[j])) {
                    ArrayUtil.swap(array, j, j + 1);
                    flag = 1;
                    pos = j;
                }
            }
            if (flag == 0) {
                break;
            }
            flag = 0;
            key = pos;
            //反向遍历，把最小值遍历到数组的左端
            for (int k = key;k>start;k--){
                if (ArrayUtil.less(array[k],array[k-1])){
                    ArrayUtil.swap(array,k,k-1);
                    flag = 1;
                }
            }
            start++;
            if (flag == 0) {
                break;
            }
        }


    }
}
