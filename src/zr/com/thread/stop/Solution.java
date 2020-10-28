package zr.com.thread.stop;

/**
 * 线程的终止方式：1.使用标志位
 */
public class Solution extends Thread {

    private volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit){
            System.out.println(Thread.currentThread().getName()+":");
        }
        super.run();
    }
}
