package basicdoubt;

/**
 * @author: deng
 * @date: 2020/1/7
 * @time: 16:58
 * @desc：  整型包装类值的比较
 */
public class TypeOfPackage {
    //当使用自动装箱方式创建一个Integer对象时，当数值在-128 ~127时，会将创建的 Integer 对象缓存起来，当下次再出现该数值时，直接从缓存中取出对应的Integer对象。所以上述代码中，x和y引用的是相同的Integer对象。

    /**
     * **注意：**如果你的IDE(IDEA/Eclipse)上安装了阿里巴巴的p3c插件，这个插件如果检测到你用 ==的话会报错提示，推荐安装一个这个插件，很不错。
     * @param args
     */
    public static void main(String[] args) {
        Integer x = 3;
        Integer y = 3;
        System.out.println(x == y);// true
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true

        Integer m = 128;
        Integer n = 128;
        //当数值在-128 ~127时，会将创建的 Integer 对象缓存起来，当下次再出现该数值时，直接从缓存中取出对应的Integer对象，而超过了这个大小指就会是比较两个不同的地址值
        System.out.println(m==n); //false
        System.out.println(m.equals(n));//true
    }
}
