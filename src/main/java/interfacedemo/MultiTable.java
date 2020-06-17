package interfacedemo;

/**
 * @author:deng
 * @date: 2020/1/30
 * @time: 4:05 下午
 * @desc：
 */
public class MultiTable {
    public static void main(String[] args) {
        乘法口诀();
    }

    private static void 乘法口诀() {
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(j + "*" + i + "=" + (j * i) + "\t");
            }
            System.out.println();

        }
    }
}
