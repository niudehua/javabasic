package basicdoubt;

import java.util.Objects;

/**
 * @author: deng
 * @date: 2020/1/7
 * @time: 16:43
 * @desc： 正确使用equals方法
 */
public class EqualsTest {
    public static void main(String[] args) {
        String str = null;
        // 不能使用一个值为null的引用类型变量来调用非静态方法，否则会抛出异常
//        if (str.equals("SnailClimb")) {
//            System.out.println("不能使用一个值为null的引用类型变量来调用非静态方法，否则会抛出异常");
//        } else {
//            System.out.println("...");
//        }

        // 可以将判断语句改为下面这样的话，就不会抛出空指针异常
        if (!"SnailClimb".equals(str)) {
            System.out.println("不能使用一个值为null的引用类型变量来调用非静态方法，否则会抛出异常");
        } else {
            System.out.println("...");
        }

        // 推荐使用 java.util.Objects equals
        if (!Objects.equals(str, "SnailClimb")) {
            System.out.println("推荐使用 java.util.Objects equals");
        }else {
            System.out.println("推荐使用 java.util.Objects equals...");
        }
    }
}
