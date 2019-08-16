public class ShellSort {
    /*
     * 希尔排序 插入排序的优化算法
     * h相等于步长，计算h的方法3*h+1,（1,4,13,40.....）
     * 数组从0开始，步长为h，将0，0+h,0+2h...算作一个新的数组，对它们进行插入排序
     * 从最大的h开始，每次插入排序后，h/=3,直到h=1，排序完成
     * 运用了和插入排序同样的优化方法，减少了数组的交换
     */
    public static void sort(Comparable[] array){
        int len = array.length;
        int h =1;
        while (h<len/3){
            h=3*h+1;
        }
        Comparable key;
        while (h>=1){
            for (int i = h;i<len;i++){
                int j =i;
                key = array[i];
                for (;j>=h && ArrayUtil.less(key,array[j-h]);j-=h){
                    array[j] = array[j-h];
                }
                array[j] = key;
            }
            h/=3;
        }
    }
}
