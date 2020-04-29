package studytemp;


import java.util.Arrays;
import java.util.Scanner;


/**
 * @author:deng
 * @date: 2019/9/26
 * @time: 6:04 下午
 * @email 657563945@qq.com
 */
public class BuyApp  {
    public static void main(String[] args) {
        int totalMoney;
        int[] wantBuyPrices;
        Scanner totalMoneyScanner = new Scanner(System.in);
        System.out.println("请输入总金额:");
        totalMoney = totalMoneyScanner.nextInt();
        Scanner wantBuyPricesScanner = new Scanner(System.in);
        System.out.println("请输入每种物品的价格以空格分开:");
        String wantBuyString = wantBuyPricesScanner.nextLine();
        wantBuyPrices = stringConvertInt(wantBuyString);
        getResult(wantBuyPrices, totalMoney);

    }

    private static int[] stringConvertInt(String value) {
        int[] intArr;
        String[] valueArr = value.split("\\s+");
        intArr = new int[valueArr.length];
        for (int i = 0; i < valueArr.length; i++) {
            intArr[i] = Integer.parseInt(valueArr[i]);
        }
        return intArr;
    }


    private static int getResult(int[] wantBuyPrices, int totalMoney) {
        Arrays.sort(wantBuyPrices);
        int length = wantBuyPrices.length;
        for (int i = length - 1; i >= 0; i--) {
            System.out.println(wantBuyPrices[i]);

        }
        return 0;

    }


}
