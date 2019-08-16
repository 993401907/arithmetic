public class InsertSort {
    /*
     * 插入排序 整体思路还是很简单，用了比较优化的发放，减少了数组的交换 复杂度N^2
     */
    public static void sort(Comparable[] array,int start,int end) {
        Comparable key;
        for (int i = start+1; i < end; i++) {
            key = array[i];
            int j = i;
            for (;j > start && ArrayUtil.less(key, array[j - 1]); j--) {
                array[j] = array[j-1];
            }
            array[j] = key;
        }
    }
}
