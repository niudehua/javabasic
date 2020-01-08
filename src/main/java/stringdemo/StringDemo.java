package stringdemo;

/**
 * @author:deng
 * @date: 2019/7/19
 * @time: 2:56 PM
 * @email 657563945@qq.com
 */
public class StringDemo {
    public static void main(String[] args) {
        String i = "我";
        i = "你";
        System.out.println(i);
        System.out.println(i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        System.out.println(stringBuilder);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(2);
        System.out.println(stringBuffer);
    }
}
