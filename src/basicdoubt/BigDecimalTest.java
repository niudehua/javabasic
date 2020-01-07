package basicdoubt;

import java.math.BigDecimal;

/**
 * @author: deng
 * @date: 2020/1/7
 * @time: 17:28
 * @desc： BigDecimal的用处
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999964
        System.out.println(a == b);// false

        BigDecimal l = new BigDecimal("1.0");
        BigDecimal m = new BigDecimal("0.9");
        BigDecimal n = new BigDecimal("0.8");
        BigDecimal x = l.subtract(m);// 0.1
        System.out.println(x);
        BigDecimal y = m.subtract(n);// 0.1
        System.out.println(y);
        System.out.println(x.equals(y));// true
    }
}
