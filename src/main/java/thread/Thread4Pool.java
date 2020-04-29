package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:deng
 * @date: 2019/9/28
 * @time: 9:37 下午
 * @email 657563945@qq.com
 */
public class Thread4Pool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.printf("线程名：%s%n", Thread.currentThread().getName());
            }
        }, 0, 2, TimeUnit.SECONDS);

    }
}
