package utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author:deng
 * @date: 2020/1/1
 * @time: 3:17 上午
 * @desc： 密码字典生成
 */
public class DictionarySeek {

//    private static char[] fullCharSource = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
//            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
//            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
//            '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '{', '}', '|', ':', '"', '<', '>', '?', ';', '\'', ',', '.', '/', '-', '=', '`'};

//    /**
//     * 密码可能会包含的字符集合
//     */
//    private static char[] fullCharSource = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
//            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
//            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@', '#', '$', '%', '&', '*', '_', '+', ',', '.', '-', '=',};

    /**
     * 密码可能会包含的字符集合
     * 小写字母加数字
     */
    private static char[] fullCharSource = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    /**
     * 将可能的密码集合长度
     */
    private static int fullCharLength = fullCharSource.length;

    /**
     * 穷举打印输出，可以将打印输出的文件形成字典
     *
     * @param maxLength：生成的字符串的最大长度
     */
    public static void generate(int maxLength) {
        //计数器，多线程时可以对其加锁，当然得先转换成Integer类型。
        int counter = 0;
        StringBuilder buider = new StringBuilder();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("/Users/deng/Desktop/小写字母加数字.txt");

            while (buider.toString().length() <= maxLength) {
                buider = new StringBuilder(maxLength * 2);
                int _counter = counter;
                //10进制转换成26进制
                while (_counter >= fullCharLength) {
                    //获得低位
                    buider.insert(0, fullCharSource[_counter % fullCharLength]);
                    _counter = _counter / fullCharLength;
                    //精髓所在，处理进制体系中只有10没有01的问题，在穷举里面是可以存在01的
                    _counter--;
                }
                //最高位
                buider.insert(0, fullCharSource[_counter]);
                counter++;
                System.out.println(buider.toString());
                fileWriter.write(buider.toString());
                fileWriter.write("\n");
            }
            System.out.println("密码字典生成完毕！！！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭对象
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        long beginMillis = System.currentTimeMillis();
        //开始时间
        System.out.println(beginMillis);
        //以最大长度为8测试
        generate(10);
        long endMillis = System.currentTimeMillis();
        //结束时间
        System.out.println(endMillis);
        //总耗时，毫秒
        System.out.println(endMillis - beginMillis);
    }
}


