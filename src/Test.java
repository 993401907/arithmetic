public class Test {
    public static void main(String[] args) throws Exception {
        int count = 3;
        int length = 10000;
        ArrayUtil.timeRandomInput(SortMethod.INSERTION, count, length);
        ArrayUtil.timeRandomInput(SortMethod.SELECTION, count, length);
        ArrayUtil.timeRandomInput(SortMethod.MERGE_BU, count, length);
        ArrayUtil.timeRandomInput(SortMethod.MERGE, count, length);
        ArrayUtil.timeRandomInput(SortMethod.BUBBLE, count, length);
        ArrayUtil.timeRandomInput(SortMethod.COMMON_QUICK, count, length);
        ArrayUtil.timeRandomInput(SortMethod.QUICK_3WAY, count, length);
        ArrayUtil.timeRandomInput(SortMethod.HEAP, count, length);

    }
}
