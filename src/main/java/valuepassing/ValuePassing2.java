package valuepassing;

/**
 * @author: deng
 * @date: 2020/1/8
 * @time: 16:48
 * @desc： 值传递与引用传递
 */
public class ValuePassing2 {
    //基础数据类型
//    public static void main(String[] args) {
//        ValuePassing2 pt = new ValuePassing2();
//        int j = 10;
//        pt.pass(10);
//        System.out.println("print in main , j is " + j);
//    }
//
//    public void pass(int j) {
//        j = 20;
//        System.out.println("print in pass , j is " + j);
//    }
    //String 类型 这里其实是重新创建了一个String对象去替换 传递过来的参数
//    public static void main(String[] args) {
//        ValuePassing2 pt = new ValuePassing2();
//        String name = "Hollis";
//        pt.pass(name);
//        System.out.println("print in main , name is " + name);
//    }
//
//    public void pass(String name) {
//        name = "hollischuang";//这里其实是 name =new String("hollischuang");
//        name = null;
//        System.out.println("print in pass , name is " + name);
//    }


        //错误示例：这里形参将接收的实参的内容去做了改变，并好像，朋友把钥匙复制了一把给你，你用钥匙打开门把别人家砸了
//    public static void main(String[] args) {
//        ValuePassing2 pt = new ValuePassing2();
//        User hollis = new User();
//        hollis.setName("Hollis");
//        hollis.setGender("Male");
//        pt.pass(hollis);
//        System.out.println("print in main , user is " + hollis);
//    }
//
//    public void pass(User user) {
//        user.setName("hollischuang");
//        System.out.println("print in pass , user is " + user);
//    }

    // 正确示例：直接将user变成null,user是不是没变？
    public static void main(String[] args) {
        ValuePassing2 pt = new ValuePassing2();
        User hollis = new User();
        hollis.setName("Hollis");
        hollis.setGender("Male");
        pt.pass(hollis);
        System.out.println("print in main , user is " + hollis);
    }

    public void pass(User user) {
        user = null;
        System.out.println("print in pass , user is " + user);
    }

    /**
     * 对象
     */
    static class User {
        String name;
        String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
