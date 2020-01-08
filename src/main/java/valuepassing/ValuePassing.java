package valuepassing;

/**
 * @author: deng
 * @date: 2020/1/8
 * @time: 16:00
 * @desc： Java值传递问题  实际参数与形式参数
 */
public class ValuePassing {
    public static void main(String[] args) {
        ValuePassing pt = new ValuePassing();
        String name = "Hollis";
        pt.sout(name);//实际参数为 Hollis
    }

    /**
     * 形式参数为 name
     *
     * @param name
     */
    public void sout(String name) {
        System.out.println(name);
    }
}


