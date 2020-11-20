package zr.com.thread.forkjoin.sort;

public class InsertSort {
    private int[] arr;

    public InsertSort(int[] arr) {
        this.arr = arr;
    }

    public static int[] insertSort(int[] arr) {
        int len = arr.length;
        if (len == 0)
            return arr;
        for (int i = 0; i < len - 1; i++) {
            int index = i;
            int pre = arr[index];
            int curr = arr[index + 1];
            while (index >= 0 && pre > curr) {
                arr[index] = curr;
                arr[index + 1] = pre;
                if (index > 0) {
                    pre = arr[index - 1];
                    curr = arr[index];
                }
                index--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 1, 8, 3, 4, 7, 6, 2};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
