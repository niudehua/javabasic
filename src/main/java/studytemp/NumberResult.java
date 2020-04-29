package studytemp;

import java.util.Scanner;

/**
 * @author:deng
 * @date: 2019/10/2
 * @time: 5:29 下午
 * @email 657563945@qq.com
 */
public class NumberResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum;
        int lastNum;
        int validationNum;

        System.out.print("一些相续正整数的立方和正好等于另一个整数的立方。");
        System.out.println("请输入启始整数：");
        firstNum = scanner.nextInt();
        System.out.println("请输入最终整数：");
        lastNum = scanner.nextInt();
        System.out.println("请输入需要验证的整数：");
        validationNum = scanner.nextInt();

        Number number = new Number();

        for (int i = firstNum; i <= lastNum; i++) {
            number.setNumber(i);
            number.setSum();
        }

        if (number.getSum() == validationNum * validationNum * validationNum) {
            System.out.println("从" + firstNum + "到" + lastNum + "的整数等于" + validationNum);
        } else {
            System.out.println("从" + firstNum + "到" + lastNum + "的整数不等于" + validationNum);

        }


    }

    static class Number {
        private Integer number = 0;
        private Integer sum = 0;

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getSum() {
            return sum;
        }

        public void setSum() {
            sum = sum + number * number * number;
        }
    }
}
