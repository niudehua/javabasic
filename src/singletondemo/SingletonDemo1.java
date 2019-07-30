package singletondemo;

/**
 * 单例模式：饿汉模式
 *
 * @author:deng
 * @date: 2019/5/26
 * @time: 4:08 PM
 * @email 657563945@qq.com
 */

public class SingletonDemo1 {
    public static void main(String... args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1);
        System.out.println(bank2);
        System.out.println(bank1 == bank2);
    }
}


class Bank {

    private Bank() {
    }

    private static Bank instance = new Bank();

    public static Bank getInstance() {
        return instance;
    }
}