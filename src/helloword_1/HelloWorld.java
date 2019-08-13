package helloword_1;


/**
 * @author:deng
 * @date: 2019/7/29
 * @time: 10:49 PM
 * @email 657563945@qq.com
 * Java 基础语法
 */
public class HelloWorld {
    int a = 1;

    /**
     * 用于类的说明和方法的说明
     *
     * @param args
     */
    public static void main(String[] args) {
        byte b = 120;

        //控制台打印输出  注释代码中的一行
        System.out.println(b += 10);
        System.out.println(b);
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.a);

        System.out.println(true | false);
        System.out.println(false | false);
        System.out.println(false | true);
        System.out.println(true | true);
        System.out.println("---");
        System.out.println(true || false);
        System.out.println(false || false);
        System.out.println(false || true);
        System.out.println(true || true);
        System.out.println("---");
        System.out.println(true & false);
        System.out.println(false & false);
        System.out.println(false & true);
        System.out.println(true & true);
        System.out.println("---");
        System.out.println(true && false);
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println(true && true);


        int grade = 1;
        switch (grade) {
            case 1:
                System.out.println("*");
            case 2:
                System.out.println("**");
            case 3:
                System.out.println("***");
                break;
            default:
                System.out.println("---");
        }

    }


}
