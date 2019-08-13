package helloword;

/**
 * @author:deng
 * @date: 2019/7/29
 * @time: 10:49 PM
 * @email 657563945@qq.com
 * Java HelloWorld
 */
public class HelloWorld {
    int a = 1;

    /**
     * 用于类的说明和方法的说明
     *
     * @param args
     */
    public static void main(String[] args) {
        short b = 5;
        b += 5;
        //控制台打印输出  注释代码中的一行
        System.out.println("Hello World！！" + b);
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.a);
    }


}
