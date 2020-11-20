package zr.com.thread.utils;

import java.util.Random;

/**
 * 生成随机数据
 */
public class MakeArray {
    private int length;

    public MakeArray(int length) {
        this.length = length;
    }

    public int[] makeArray() {
        Random r = new Random();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(length * 3);
        }

        return array;
    }
}
