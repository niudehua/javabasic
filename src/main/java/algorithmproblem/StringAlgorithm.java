package algorithmproblem;

/**
 * @author: deng
 * @datetime: 2020/6/16 2:13 下午
 * @desc: 求给定字符串的最大匹配字符串，请编写函数实现功能，String function myfun(String str1,String str2);
 * 输入格式：输入数目不定的多对字符串，每行两个，以空格分开
 * 样例：myfun("munameistom","henameisjack") 返回值：max match chars is "nameis"
 */
public class StringAlgorithm {
    public static String myfun(String str1, String str2) {
        boolean b1;
        boolean b2 = false;
        int length = str1.length();
        for (int t = 0; t < str1.length(); t++) {
            int i = 0;
            int j = i + length;
            for (int k = 0; k < str1.length() - length + 1; k++) {
                b1 = str2.contains(str1.substring(i, j));
                if (b1) {
                    System.out.println("max match chars is" + '"' + str1.substring(i, j) + '"');
                    b2 = true;
                }
                i++;
                j = i + length;
            }
            if (b2) {
                return null;
            }
            length--;
        }
        return null;
    }


    public static void main(String[] args) {
        myfun("munameistom", "henameisjack");
    }
}
