import org.apache.commons.lang3.time.StopWatch;
import util.StdRandom;

public class ArrayUtil {

    //交换数组元素
    public static void swap(Comparable[] array, int left, int right) {
        Comparable tempValue = array[left];
        array[left] = array[right];
        array[right] = tempValue;
    }

    //比较元素
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //打印
    public static void show(Comparable[] array) {
        StringBuilder sb = new StringBuilder();
        for (Comparable a : array) {
            sb.append(a).append(" ");
        }
        System.out.println("排序后：" + sb.toString());
    }

    //判断是否有序
    public static boolean isSort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }

        }
        return true;
    }

    //选择排序方式，计算时间
    public static double runTime(String method, Comparable[] array) throws Exception {
        StopWatch watch = new StopWatch();
        watch.start();
        switch (method) {
            case "Insertion": {
                InsertSort.sort(array, 0, array.length);
                break;
            }
            case "Selection": {
                SimpleSelectionSort.sort(array);
                break;
            }
            case "Shell": {
                ShellSort.sort(array);
                break;
            }
            case "Quick": {
                QuickSort.optimizeSort(array, 0, array.length - 1);
                break;
            }
            case "Quick3Way":{
                QuickSort.quick3way(array,0,array.length-1);
                break;
            }
            case "Heap": {
                HeapSort.sort(array);
                break;
            }
            case "Bubble": {
                BubbleSort.sort(array);
                break;

            }
            case "Merge": {
                Comparable[] aux = new Comparable[array.length];
                Merge.mergeSort(array, aux, 0, array.length - 1);
                break;
            }
            case "MergeBU": {
                Merge.mergeSortBu(array);
                break;
            }
            default: {
                throw new Exception("error");
            }
        }

        watch.stop();
        if (isSort(array)) {
            return watch.getNanoTime();
        }
        throw new RuntimeException(method+"排序不成功");
    }

    /**
     * @param method 使用排序方法的名称
     * @param count  生成几组数据
     * @param length 每组数据的长度
     * @return total 平均使用时间 单位ms
     * @throws Exception e
     */
    public static void timeRandomInput(String method, int count, int length) throws Exception {
        double total = 0.0;
        Comparable[] array = new Comparable[length];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < length; j++) {
                array[j] = StdRandom.uniform() * 100;
            }

            total += runTime(method, array);
        }
        double ms = total/count/100000;
        String formatMs = String.format("%.2f", ms);
        System.out.println(method+" 平均运行时间:"+formatMs);
    }

}
