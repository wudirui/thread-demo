package zr.com.thread.forkjoin;

public class InsertSort {
    private int[] arr;

    public InsertSort(int[] arr) {
        this.arr = arr;
    }

    public static int[] insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int index = i;
            int pre = arr[index];
            int curr = arr[index + 1];
            while (pre>curr){

            }
        }
        return arr;
    }
}
