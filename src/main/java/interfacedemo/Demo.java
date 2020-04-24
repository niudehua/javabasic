package interfacedemo;

/**
 * @author:deng
 * @date: 2020/2/11
 * @time: 11:20 上午
 * @desc：
 */
public interface Demo {
    default void hi2() {
        System.out.println(hi());
    }

    default void hello() {
        System.out.println("hello");
    }


    static String hi() {

        System.out.println("hi");
        return "hi,Method";

    }
}
