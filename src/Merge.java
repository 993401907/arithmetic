public class Merge {
    public static void main(String[] args) {
        Comparable[] a = {1, 34, 5, 6, 35, 6, 31, 3};
        mergeSort(a, new Comparable[a.length], 0, a.length - 1);
        System.out.println(ArrayUtil.isSort(a));
        ArrayUtil.show(a);
    }

    public static void mergeSort(Comparable[] dest, Comparable[] src, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(dest, src, l, mid);
            mergeSort(dest, src, mid + 1, r);
            merge(dest, src, l, mid, r);
        }
    }

    public static void mergeSortBu(Comparable[] array) {
        int N = array.length;
        Comparable[] aux = new Comparable[N];
        for (int n = 1; n < N; n = n + n) {
            for (int i = 0; i < N - n; i += n + n) {
                int lo = i;
                int m = i + n - 1;
                int hi = Math.min(i + n + n - 1, N - 1);
                merge(array, aux, lo, m, hi);
            }
        }
    }

    public static void merge(Comparable[] a, Comparable[] aux, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            aux[k] = a[k];
        }
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > right) {
                a[k] = aux[i++];
            } else if (ArrayUtil.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
