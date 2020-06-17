package interfacedemo;

/**
 * @author:deng
 * @date: 2020/2/11
 * @time: 11:23 上午
 * @desc：
 */
class DemoImpl implements Demo3 {
    @Override
    public void hello3() {

    }

    @Override
    public void hello2() {

    }

    public static void main(String[] args) {
        DemoImpl demo = new DemoImpl();
        demo.hi2();
        demo.hello();
    }
}
