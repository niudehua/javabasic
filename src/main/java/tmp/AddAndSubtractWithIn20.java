/**
 * @author: deng
 * @datetime: 2020/6/26 10:44 上午
 * @desc:
 */
public class AddAndSubtractWithIn20 {
    public static void add() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(i + "+" + j + "=" + (i + j) + "\t");
            }
            System.out.println();
        }
    }

    public static void subtrac() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print((i + j) + "-" + i + "=" + j + "\t");
            }
            System.out.println();
        }
    }

    public static void multiplicationTables() {
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("20以内加减法表");
        System.out.println("20以内加法：");
        add();
        System.out.println("20以内减法：");
        subtrac();
        System.out.println("九九乘法表:");
        multiplicationTables();
    }

}
