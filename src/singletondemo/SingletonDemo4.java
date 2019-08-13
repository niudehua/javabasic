package singletondemo;

/**
 * @author:deng
 * @date: 2019/8/6
 * @time: 11:43 AM
 * @email 657563945@qq.com
 */

public class SingletonDemo4 {
    public static void main(String[] args) {
        Sex.MAN.getInstance();
    }
}

enum Sex {
    MAN;

    public void getInstance() {
        System.out.println(Sex.MAN.name());
    }
}