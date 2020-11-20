package zr.com.thread.forkjoin.sum;

import zr.com.thread.utils.MakeArray;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Integer> {
    private int[] src;
    private final static int THRESHOLD = 2;

    public ForkJoinSum(int[] src) {
        this.src = src;
    }

    @Override
    protected Integer compute() {
        if (src.length <= THRESHOLD) {
            return Sum.sum(src);
        }
        int mid = src.length / 2;
        int[] src1 = Arrays.copyOfRange(src, 0, mid);
        int[] src2 = Arrays.copyOfRange(src, mid, src.length);
        ForkJoinSum left = new ForkJoinSum(src1);
        ForkJoinSum right = new ForkJoinSum(src2);
        invokeAll(left, right);
        Integer leftResult = left.join();
        Integer rightResult = right.join();

        return leftResult + rightResult;
    }

    public static void main(String[] args) {
        int[] arr = new MakeArray(4).makeArray();
        ForkJoinSum joinSum = new ForkJoinSum(arr);
        ForkJoinPool pool = new ForkJoinPool();
        Integer result = pool.invoke(joinSum);
        System.out.println(result);
    }
}
