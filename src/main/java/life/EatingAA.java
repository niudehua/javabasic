package life;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: deng
 * @datetime: 2020/6/20 12:39 下午
 * @desc: 要吃饭的嘛。-->会员卡充值规则：冲100送10元
 */
public class EatingAA {
    /**
     * 会员卡优惠比率
     */
    private static final double RATIO = new BigDecimal(100).divide(new BigDecimal(110), 3, RoundingMode.CEILING).doubleValue();

    public static void main(String[] args) {
        computationalCosts(85, 6, 3);
    }

    /**
     * 计算吃饭费用
     *
     * @param totalAmount    总金额
     * @param numberOfPeople 人数
     * @param scale          数值范围
     */
    public static void computationalCosts(double totalAmount, int numberOfPeople, int scale) {
        System.out.println(RATIO);
        double perCost = new BigDecimal(totalAmount).multiply(new BigDecimal(RATIO));
        System.out.println("实际总消费：" + perCost);
        System.out.println("人均实际消费：" + perCost.divide(new BigDecimal(numberOfPeople), scale, RoundingMode.CEILING).doubleValue());
    }


}
