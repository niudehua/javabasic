package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author:deng
 * @date: 2019/9/28
 * @time: 9:31 下午
 * @email 657563945@qq.com
 */
public class ThreadDemo3impl implements Callable {
    @Override
    public Object call() throws Exception {
        while (true) {
            System.out.println("线程名" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new ThreadDemo3impl());
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        Thread thread2 = new Thread(new FutureTask<>(new ThreadDemo3impl()));
        thread2.start();


    }
}
