package thread;

/**
 * @author:deng
 * @date: 2019/9/28
 * @time: 9:24 下午
 * @email 657563945@qq.com
 */
public class ThreadDemo2impl implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadDemo2impl());
        Thread thread2 = new Thread(new ThreadDemo2impl());
        thread1.start();
        thread2.start();
    }
}
