package variable;

/**
 * @author:deng
 * @date: 2019/7/30
 * @time: 10:07 PM
 * @email 657563945@qq.com
 * Java 变量类型
 */
public class Variable {

    /**
     * 类变量
     */
    static int allClicks = 0;

    /**
     * 实例变量
     */
    String string = "hello world";

    public void method() {
        /**
         * 局部变量
         */
        int i = 0;
        System.out.println(i);

    }

    public static void main(String[] args) {
        Variable variable = new Variable();
        System.out.println(variable.string);
        System.out.println(allClicks);
        variable.method();

    }
}
