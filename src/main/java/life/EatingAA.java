package life;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * 要吃饭的嘛。-->会员卡充值规则：冲100送10元
 *
 * @author: deng
 * @datetime: 2020/6/20 12:39 下午
 * @desc:
 */
public class EatingAA {
    /**
     * 会员卡优惠比率
     */
    private static final BigDecimal RATIO = BigDecimal.valueOf(new BigDecimal(100).divide(new BigDecimal(110), 3, RoundingMode.CEILING).doubleValue());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入消费金额：");
        String totalAmount = scanner.next();
        System.out.println("请输入消费人数：");
        String numberOfPeople = scanner.next();
        computationalCosts(totalAmount, numberOfPeople, 3);
    }

    /**
     * 计算吃饭费用
     *
     * @param totalAmount    总金额
     * @param numberOfPeople 人数
     * @param scale          数值范围
     */
    public static void computationalCosts(String totalAmount, String numberOfPeople, int scale) {
        System.out.println("会员卡优惠比率：" + RATIO);
        BigDecimal perCost = BigDecimal.valueOf(new BigDecimal(totalAmount).multiply(RATIO).doubleValue());
        System.out.println("实际总消费：" + perCost);
        System.out.println("人均实际消费：" + perCost.divide(new BigDecimal(numberOfPeople), scale, RoundingMode.CEILING).doubleValue());
    }
}
