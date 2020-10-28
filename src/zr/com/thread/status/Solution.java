package zr.com.thread.status;

/**
 * 区别isInterrupted() 和interrupted() 方法
 */
public class Solution extends Thread {

    private int num = 0;

    @Override
    public void run() {

        while (!interrupted()) {//将线程状态的判断设置陈isInterrupted() 和 interrupted()
            num++;
            String name = Thread.currentThread().getName();
            System.out.println(name + ":" + num);
            if (num >= 1000) {
                this.interrupt();
            }
        }


        System.out.println(isInterrupted());
        //打印出线程当前的状态，当while循环的判断条件为isInterrupted()时，打印结果为true，当interrupted() 时，打印结果为false
        System.out.println("线程结束");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.start();
    }
}
