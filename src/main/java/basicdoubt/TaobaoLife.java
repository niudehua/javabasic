package basicdoubt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: deng
 * @date: 2020/1/9
 * @time: 11:16
 * @desc： 计算淘宝人生
 */
public class TaobaoLife {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");


    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("今年是：" + now.format(DATE_TIME_FORMATTER));
        System.out.println("淘宝初始使用时间：" + now.minusDays(3791).format(DATE_TIME_FORMATTER));
    }
}
