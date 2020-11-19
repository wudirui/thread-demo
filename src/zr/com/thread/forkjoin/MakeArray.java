package zr.com.thread.forkjoin;

import java.util.Random;

/**
 * 生成随机数据
 */
public class MakeArray {
    private static final int ARRAY_LENGTH = 1000;
    private static final int THRESHOLD = 1000;

    public static int[] makeArray() {
        Random r = new Random();
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(ARRAY_LENGTH * 3);
        }

        return array;
    }
}
