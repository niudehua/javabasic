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
        // 精度丢失
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

        //大小比较 -1 表示小于，0 表示 等于， 1表示 大于。
        System.out.println(l.compareTo(m));// 1
        System.out.println(l.subtract(m).compareTo(m.subtract(n)));// 0
        System.out.println(m.compareTo(l));// -1

        //BigDecimal 保留几位小数 通过 setScale方法设置保留几位小数以及保留规则。
        BigDecimal p = new BigDecimal("1.255433");
        BigDecimal q = p.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(q);// 1.255

        // 为了防止精度丢失，推荐使用它的 BigDecimal(String)构造方法或者valueOf方法来创建对象
        BigDecimal i = new BigDecimal(1.3);
        System.out.println(i);
        BigDecimal j = BigDecimal.valueOf(1.3);
        System.out.println(j);
        BigDecimal k = new BigDecimal("1.3");
        System.out.println(k);

    }
}
