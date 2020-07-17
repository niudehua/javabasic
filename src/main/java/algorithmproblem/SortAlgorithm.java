package algorithmproblem;

/**
 * @author: deng
 * @datetime: 2020/7/9 10:55 上午
 * @desc:
 */
public class SortAlgorithm {

    /**
     * 按年龄排序
     *
     * @param ages
     */
    public static void sort(int[] ages) {
        int oldestAge = 100;
        int[] timesOfAges = new int[oldestAge];

        int len = ages.length;
        for (int i = 0; i < len; i++) {
            timesOfAges[ages[i]]++;
        }
        //排序
        int index = 0;
        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timesOfAges[i]; j++) {
                ages[index] = i;
                index++;
            }
        }

        for (int age : ages) {
            System.out.println(age);
        }
    }


    /**
     * 斐波那契数列
     * 0，1，1，2，3，5，8，13。。。。求第N个数
     *
     * @param n
     */
    public static void fibonacciSequence(int n) {
        int num1 = 0;
        int num2 = 1;
        int numn = 1;

        for (int i = 3; i <= n; i++) {
            numn = num1 + num2;
            num1 = num2;
            num2 = numn;
        }
        System.out.println(n + "个数的结果为：" + numn);
    }


    public static void main(String[] args) {
//        sort({22, 23, 34, 45, 27, 21, 19, 20, 22, 23, 23, 22});

        fibonacciSequence(8);
    }
}



