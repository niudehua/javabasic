# 为什么说Java中只有值传递

## 1 形式参数与实际参数

形式参数：是在定义函数名和函数体的时候使用的参数,目的是用来接收调用该函数时传入的参数。

实际参数：在调用有参函数时，主调函数和被调函数之间有数据传递关系。在主调函数中调用一个函数时，函数名后面括号中的参数称为“实际参数”

```Java
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
```

## 2 值传递与引用传递

值传递（pass by value）是指在调用函数时将实际参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。

引用传递（pass by reference）是指在调用函数时将实际参数的地址直接传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。

```Java
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
```

你有一把钥匙，当你的朋友想要去你家的时候，如果你直接把你的钥匙给他了，这就是引用传递。这种情况下，如果他对这把钥匙做了什么事情，比如他在钥匙上刻下了自己名字，那么这把钥匙还给你的时候，你自己的钥匙上也会多出他刻的名字。

你有一把钥匙，当你的朋友想要去你家的时候，你复刻了一把新钥匙给他，自己的还在自己手里，这就是值传递。这种情况下，他对这一把钥匙做什么都不会影响你手里的这把钥匙。

但是，不管上面哪种情况，你的朋友拿着你给他的钥匙，进到你的家里，把你家的电视砸了。那你说你会不会受到影响？而我们在pass方法中，改变user对象的name属性的值的时候，不就是在“砸电视”么。你改变的不是那把钥匙，而是钥匙打开的房子。