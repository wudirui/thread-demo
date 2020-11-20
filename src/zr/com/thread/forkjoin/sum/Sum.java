package zr.com.thread.forkjoin.sum;

public class Sum {
    public static int sum(int[] src) {
        int result = 0;
        for (int i = 0; i < src.length; i++) {
            result += src[i];
        }
        return result;
    }
}
