package thread;

/**
 * @author:deng
 * @date: 2019/9/28
 * @time: 9:15 下午
 * @email 657563945@qq.com
 */
public class ThreadDemo1 extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();
        ThreadDemo1 threadDemo2 = new ThreadDemo1();
        threadDemo2.start();
    }
}
