package singletondemo;

/**
 * @author:deng
 * @date: 2019/8/6
 * @time: 11:16 AM
 * @email 657563945@qq.com
 */
public class SingletonDemo3 {
    public static void main(String[] args) {
        Customer customer1 = Customer.getInstance();
        Customer customer2 = Customer.getInstance();
        System.out.println(customer1);
        System.out.println(customer2);

    }

}


class Customer {
    /**
     * 构造私有化
     */
    private Customer() {
    }


    /**
     * 静态内部类不会在一开始被装载，所以没有内存消耗问题
     * JVM在装载静态内部类是线程安全的 只有在使用内部类才会去装载 所以线程是安全的
     */
    private static class CustomerIntance {
        private static final Customer customer = new Customer();
    }

    /**
     * 提供静态公有获取方法
     *
     * @return customer
     */
    public static synchronized Customer getInstance() {
        return CustomerIntance.customer;
    }


}

