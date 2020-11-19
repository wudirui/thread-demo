package zr.com.thread.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

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
        ForkJoinSort right = new ForkJoinSort(Arrays.copyOfRange(src, mid + 1, src.length));
        invokeAll(left, right);
        int[] leftResult = left.join();
        int[] rightResult = right.join();
        return MergeSort.merge(leftResult,rightResult);
    }
}
