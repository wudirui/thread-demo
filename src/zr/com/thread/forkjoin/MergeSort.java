package zr.com.thread.forkjoin;

/**
 * 将两个有序的数组合并
 */
public class MergeSort {
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length && j < right.length) {//1.左边的数据已经取完，剩下的直接取右侧的数据
                result[index] = right[j++];
            } else if (j >= right.length && i < left.length) {//2.右边的数据已经取完，剩下的直接取左侧的数据
                result[index] = left[i++];
            } else if (left[i] > right[j]) {//3.左边的值大于右侧的值
                result[index] = right[j++];
            } else {//4.右侧的值大于左侧的
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr = merge(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
