package basicdoubt;

import java.util.Objects;

/**
 * @author: deng
 * @datetime: 2020/8/28 12:43 上午
 */
public class Demo {
    private String nama;
    private Demo demo;


    public static void main(String[] args) {
        Demo demo = new Demo();
        Demo demo1 = demo;
        Demo demo2 = new Demo();
        System.out.println(demo == demo1);
        System.out.println(demo.equals(demo));
        System.out.println(demo1 == (demo2));
        System.out.println(demo1.equals(demo2));
        System.out.println(demo == (demo2));
        System.out.println(demo.equals(demo2));
        System.out.println(0.3 / 4);
        System.out.println(17 % 4);
        System.out.println(3.0 / 4);


    }
}
