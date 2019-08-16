public class HeapSort {

    /*
     *初始化堆,规则：非叶子结点的值必定大于它的叶子结点，堆的顶端为数组的最大值
     *建立堆过程自下而上
     */
    public static void sort(Comparable[] array) {

        initHeap(array);
        int count = array.length;
        while (count > 1) {
            //交换数组的第0位和最后一位，第一位总是为数组最大值，然后将待排序个数减一
            ArrayUtil.swap(array,count-1,0);
            count--;
            buildHeap(array, count, 0);
        }
    }

    private static void initHeap(Comparable[] array) {
        int arrayLen = array.length;
        for (int index = (arrayLen / 2 - 1); index >= 0; index--) {
//            buildHeap(array, arrayLen, index);
                sink(array,index,arrayLen);
        }
    }

    /**
     *
     * @param array 待排序数组
     * @param count 待排序元素的个数
     * @param index 元素的索引值
     */
    private static void buildHeap(Comparable[] array, int count, int index) {
        int maxChildIdx;
        while (index <= count / 2 - 1) {
            //判断结点时候为偶数，如果是则只有左叶子结点
            if (count % 2 == 0 && index == count / 2 - 1) {
                maxChildIdx = index * 2 + 1;
            } else {
                int leftChildIdx = index * 2 + 1;
                int rightChildIdx = index * 2 + 2;
                //判断左右叶子结点谁大，并赋值
                maxChildIdx = ArrayUtil.less(array[leftChildIdx],array[rightChildIdx]) ?
                            rightChildIdx: leftChildIdx;
            }
            /*
             *判断结点是否大于它的父节点，是就交换它们，赋值进入下一次判断
             * 建堆是自下而上的过程，while循环是自上而下再判断
             */
            if (ArrayUtil.less(array[index] , array[maxChildIdx])) {
                ArrayUtil.swap(array,index,maxChildIdx);
                index = maxChildIdx;
            } else {
                break;
            }
        }
    }

    private static void sink(Comparable[] array,int k,int N){
        while (2*k+1<=N){
            int j = 2*k+1;
            if (N%2==0 && k == N/2-1){
                j = 2*k+1;
            }
            else if (j<N && ArrayUtil.less(array[j],array[j+1])){
                j++;
            }

            if (ArrayUtil.less(array[k],array[j])){
                ArrayUtil.swap(array,j,k);
                k = j;
            }else {
                break;
            }


        }
    }

}
