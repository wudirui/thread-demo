package zr.com.thread.forkjoin.sort;

import zr.com.thread.utils.MakeArray;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin实现
 */
public class ForkJoinSort extends RecursiveTask<int[]> {

    private static final int THRESHOLD = 2;
    private int[] src;

    public ForkJoinSort(int[] src) {
        this.src = src;
    }

    @Override
    protected int[] compute() {
        if (this.src.length <= THRESHOLD) {
            return InsertSort.insertSort(src);
        }
        int mid = src.length / 2;
        ForkJoinSort left = new ForkJoinSort(Arrays.copyOfRange(src, 0, mid));
        ForkJoinSort right = new ForkJoinSort(Arrays.copyOfRange(src, mid, src.length));
        invokeAll(left, right);
        int[] leftResult = left.join();
        int[] rightResult = right.join();
        return MergeSort.merge(leftResult, rightResult);
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] src = new MakeArray(100).makeArray();
        ForkJoinSort forkJoinSort = new ForkJoinSort(src);
        int[] arr = pool.invoke(forkJoinSort);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
