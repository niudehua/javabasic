package jvm;

/**
 * @author:deng
 * @date: 2019/8/7
 * @time: 2:24 PM
 * @email 657563945@qq.com
 */
public class Math {
    public static final Integer CONSTANT = 666;

    public int computer() {
        int a = 1;
        int b = 2;
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.computer();
    }

}


