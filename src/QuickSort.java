public class QuickSort {
    /**
     * 算法思想：基于分治的思想，是冒泡排序的改进型。
     * 首先在数组中选择一个锚点（该锚点的选取可能影响快速排序的效率），
     * 然后分别从数组的两端扫描数组，设两个标志点（left指向左端位置，right指向末尾)，
     * 首先从后半部分开始，如果发现有元素比该锚点的值小，就交换left和right位置的值，
     * 交换一次后，再从前半部分开始扫描，发现有元素大于锚点的值，就交换left和right位置的值，
     * 如此往复循环，直到left>=right,然后把锚点的值放到right这个位置。
     * 一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，当
     * 前半部分和后半部分均有序时该数组就自然有序了。
     * <p>
     * 此算法是有问题的，倒序数组会造成StackOverflow异常
     *
     * @param array 待排序数组
     * @param left  数组的左界
     * @param right 数组的右界
     */

    public static void commonSort(Comparable[] array, int left, int right) {
//        System.out.println("快速排序前:" + printArray(array));

        commonAdjust(array, left, right);

    }

    public static void optimizeSort(Comparable[] array, int left, int right) {
        optimizeAdjust(array, left, right);
    }

    /**
     * @param array 待排序数组
     * @param left  数组的左界
     * @param right 数组的右界
     */
    private static void commonAdjust(Comparable[] array, int left, int right) {
        if (left < right) {
            int i, j;
            Comparable key;

            i = left;
            j = right;
            key = array[i];
            while (ArrayUtil.less(i, j)) {
                while (ArrayUtil.less(i, j) && !ArrayUtil.less(array[j], key)) {
                    // 从右向左找第一个小于x的数
                    j--;
                }
                array[i] = array[j];
                while (i < j && !ArrayUtil.less(key, array[i])) {
                    // 从左向右找第一个大于x的数
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = key;
            commonAdjust(array, left, i - 1); /* 递归调用 */
            commonAdjust(array, i + 1, right); /* 递归调用 */
        }
    }

    //三数取中切分
    private static void optimizeAdjust(Comparable[] array, int left, int right) {
        if (left < right) {
            if (right - left <= 15) {
                InsertSort.sort(array, left, right);
                return;
            }
            int i, j;
            Comparable key;
            i = left;
            j = right;
            int mid = i + (j - i) / 2;
            if (ArrayUtil.less(array[j], array[mid])) {
                ArrayUtil.swap(array, mid, j);
            }
            if (ArrayUtil.less(array[j], array[i])) {
                ArrayUtil.swap(array, i, j);
            }
            if (ArrayUtil.less(array[i], array[mid])) {
                ArrayUtil.swap(array, mid, i);
            }
            key = array[i];

            while (ArrayUtil.less(i, j)) {
                while (ArrayUtil.less(i, j) && !ArrayUtil.less(array[j], key)) {
                    // 从右向左找第一个小于x的数
                    j--;
                }
                array[i] = array[j];
                while (i < j && !ArrayUtil.less(key, array[i])) {
                    // 从左向右找第一个大于x的数
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = key;
            commonAdjust(array, left, i - 1);
            commonAdjust(array, i + 1, right);
        }
    }
    public static void quick3way(Comparable[] a,int left,int right){
        if (right<=left) return;
        int lt =left,  i = left+1,gt = right;
        Comparable key = a[left];
        while (i<=gt){
            int temp = a[i].compareTo(key);
            if (temp<0){
                ArrayUtil.swap(a,lt++,i++);
            }else if (temp>0){
                ArrayUtil.swap(a,gt--,i);
            }else {
                i++;
            }
        }
        quick3way(a,left,lt-1);
        quick3way(a,gt+1,right);
    }
}
