# Java基础疑难点

## 1 基础

### 1.1 正确使用equals方法

```Java
public class EqualsTest {
    public static void main(String[] args) {
        String str = null;
        // 不能使用一个值为null的引用类型变量来调用非静态方法，否则会抛出异常
//        if (str.equals("SnailClimb")) {
//            System.out.println("不能使用一个值为null的引用类型变量来调用非静态方法，否则会抛出异常");
//        } else {
//            System.out.println("...");
//        }

        // 可以将判断语句改为下面这样的话，就不会抛出空指针异常
        if (!"SnailClimb".equals(str)) {
            System.out.println("不能使用一个值为null的引用类型变量来调用非静态方法，否则会抛出异常");
        } else {
            System.out.println("...");
        }

        // 推荐使用 java.util.Objects equals
        if (!Objects.equals(str, "SnailClimb")) {
            System.out.println("推荐使用 java.util.Objects equals");
        }else {
            System.out.println("推荐使用 java.util.Objects equals...");
        }
    }
}
```

[Java中equals方法造成空指针异常的原因及解决方案](https://blog.csdn.net/tick_tock97/article/details/72824894)

### 1.2 整型包装类值的比较

所有整型包装类对象值的比较必须使用equals方法。

先看下面这个例子：

```Java
public class TypeOfPackage {
    //当使用自动装箱方式创建一个Integer对象时，当数值在-128 ~127时，会将创建的 Integer 对象缓存起来，当下次再出现该数值时，直接从缓存中取出对应的Integer对象。所以上述代码中，x和y引用的是相同的Integer对象。

    //**注意：**如果你的IDE(IDEA/Eclipse)上安装了阿里巴巴的p3c插件，这个插件如果检测到你用 ==的话会报错提示，推荐安装一个这个插件，很不错。
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
```

### 1.3 BigDecimal

#### 1.3.1 BigDecimal 的用处

《阿里巴巴Java开发手册》中提到：**浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals 来判断。** 具体原理和浮点数的编码方式有关，这里就不多提了，我们下面直接上实例：

```Java
public class BigDecimalTest {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        // 精度丢失
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999964
        System.out.println(a == b);// false

        BigDecimal l = new BigDecimal("1.0");
        BigDecimal m = new BigDecimal("0.9");
        BigDecimal n = new BigDecimal("0.8");
        BigDecimal x = l.subtract(m);// 0.1
        System.out.println(x);
        BigDecimal y = m.subtract(n);// 0.1
        System.out.println(y);
        System.out.println(x.equals(y));// true

        //大小比较 -1 表示小于，0 表示 等于， 1表示 大于。
        System.out.println(l.compareTo(m));// 1
        System.out.println(l.subtract(m).compareTo(m.subtract(n)));// 0
        System.out.println(m.compareTo(l));// -1

        //BigDecimal 保留几位小数 通过 setScale方法设置保留几位小数以及保留规则。
        BigDecimal p = new BigDecimal("1.255433");
        BigDecimal q = p.setScale(3,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(q);// 1.255

    }
}
```

#### 1.3.2 BigDecimal 的使用注意事项

我们在使用BigDecimal时，为了防止精度丢失，推荐使用它的 **BigDecimal(String)** 构造方法或者valueOf方法来创建对象来创建对象。《阿里巴巴Java开发手册》对这部分内容也有提到。

[ BigDecimal 的使用注意事项](https://camo.githubusercontent.com/b1c115758fbdca06d975ccb2ea9d948184d8478f/68747470733a2f2f6d792d626c6f672d746f2d7573652e6f73732d636e2d6265696a696e672e616c6979756e63732e636f6d2f323031392f372f426967446563696d616c2e706e67)

#### 1.3.3 总结

BigDecimal 主要用来操作（大）浮点数，BigInteger 主要用来操作大整数（超过 long 类型）。

BigDecimal 的实现利用到了 BigInteger, 所不同的是 BigDecimal 加入了小数位的概念

### 1.4 基本数据类型与包装数据类型的使用标准

Reference:《阿里巴巴Java开发手册》

- 【强制】所有的 POJO 类属性必须使用包装数据类型。
- 【强制】RPC 方法的返回值和参数必须使用包装数据类型。
- 【推荐】所有的局部变量使用基本数据类型。

比如我们如果自定义了一个Student类,其中有一个属性是成绩score,如果用Integer而不用int定义,一次考试,学生可能没考,值是null,也可能考了,但考了0分,值是0,这两个表达的状态明显不一样.

**说明** :POJO 类属性没有初值是提醒使用者在需要使用时，必须自己显式地进行赋值，任何 NPE 问题，或者入库检查，都由使用者来保证。

**正例** : 数据库的查询结果可能是 null，因为自动拆箱，用基本数据类型接收有 NPE 风险。

**反例** : 比如显示成交总额涨跌情况，即正负 x%，x 为基本数据类型，调用的 RPC 服务，调用不成功时，返回的是默认值，页面显示为 0%，这是不合理的，应该显示成中划线。所以包装数据类型的 null 值，能够表示额外的信息，如:远程调用失败，异常退出。

## 2 集合

### 2.1. Arrays.asList()使用指南

关于`Arrays.asList()`经常遇到的一些坑，参考这篇文章：[Java Array to List Examples](http://javadevnotes.com/java-array-to-list-examples) 

```Java
public class ArraysTest {
    public static void main(String[] args) {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        System.out.println(myList); // [Apple, Banana, Orange]
        //上面两个语句等价于下面一条语句
        List<String> myList1 = Arrays.asList("Apple", "Banana", "Orange");
        System.out.println(myList1); // [Apple, Banana, Orange]

        List list = new ArrayList<>();


        //Arrays.asList()将数组转换为集合后,底层其实还是数组，底层是数组使用集合的修改方法:add()、remove()、clear()会抛出异常。：
        //        myList.add("hehe");// UnsupportedOperationException
        //        myList1.add("heihei");// UnsupportedOperationException
        myArray[0] = "haha";
        //修改数组 中的元素 集合中的元素也会改变
        System.out.println(myList); // [haha, Banana, Orange]
        //Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
        System.out.println(myList.getClass()); // class java.util.Arrays$ArrayList
        System.out.println(list.getClass()); //class java.util.ArrayList

        // Arrays.asList()是泛型方法，传入的对象必须是对象数组。
//        int[] myArray1 = { 1, 2, 3 };
//        List myList3 = Arrays.asList(myArray1);
//        System.out.println(myList3.size());//1
//        System.out.println(myList3.get(0));//数组地址值
//        System.out.println(myList3.get(1));//报错：ArrayIndexOutOfBoundsException
//        int [] array=(int[]) myList3.get(0);
//        System.out.println(array[0]);//1


        // 使用包装类型数组就可以解决这个问题
        Integer[] myArray1 = { 1, 2, 3 };
        List myList3 = Arrays.asList(myArray1);
        System.out.println(myList3.size()); // 3
        System.out.println(myList3.get(0)); // 1
        System.out.println(myList3.get(1)); // 2
    }
}
```

### 2.2 如何正确的将数组转换为ArrayList

关于`如何正确的将数组转换为ArrayList`，参考这篇文章：[https://dwz.cn/vcBkTiTW](https://dwz.cn/vcBkTiTW)

```Java
public class ArraysTest2 {
    public static void main(String[] args) {
//        Integer [] myArray = { 1, 2, 3 };
//        //自己动手实现（教育目的）
//        System.out.println(arrayToList(myArray).getClass()+":"+arrayToList(myArray));// class java.util.ArrayList:[1, 2, 3]


//        //最简便的方法(推荐)
//        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
//        System.out.println(list.getClass()+":"+list); //class java.util.ArrayList:[a, b, c]

        //使用 Java8 的Stream(推荐)
//        Integer [] myArray = { 1, 2, 3 };
//        List myList = Arrays.stream(myArray).collect(Collectors.toList());
//        System.out.println(myList.getClass()+":"+myList); // class java.util.ArrayList:[1, 2, 3]
        //基本类型也可以实现转换（依赖boxed的装箱操作）
//        int [] myArray2 = { 1, 2, 3 };
//        List myList = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
//        System.out.println(myList.getClass()+":"+myList); // class java.util.ArrayList:[1, 2, 3]

        //使用 Guava(推荐)
        List<String> i1 = ImmutableList.of("string", "elements");  // from varargs
        System.out.println(i1.getClass()+":"+i1);// class com.google.common.collect.RegularImmutableList:[string, elements]
        String[] aStringArray = {"hehe","haha","hoho"};
        List<String> i2 = ImmutableList.copyOf(aStringArray);      // from array
        System.out.println(i2.getClass()+":"+i2);//class com.google.common.collect.RegularImmutableList:[hehe, haha, hoho]

        List<String> l1 = Lists.newArrayList(i1);    // from collection
        System.out.println(l1.getClass()+":"+l1);// class java.util.ArrayList:[string, elements]

        List<String> l2 = Lists.newArrayList(aStringArray); // from array
        System.out.println(l2.getClass()+":"+l2);// class java.util.ArrayList:[hehe, haha, hoho]

        List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from varargs
        System.out.println(l3.getClass()+":"+l3);// class java.util.ArrayList:[or, string, elements]


        // 使用 Apache Commons Collections
        List<String> list = new ArrayList<String>();
        CollectionUtils.addAll(list, "hahaha");
        CollectionUtils.addAll(list, "hehehe");
        System.out.println(list.getClass()+"："+list); // class java.util.ArrayList：[hahaha, hehehe]

    }

    /**
     * 自己动手实现（教育目的） 将数组遍历add进实例化的集合
     * @param array
     * @param <T>
     * @return
     */
    static <T> List<T> arrayToList(final T[] array) {
        final List<T> list = new ArrayList<T>(array.length);

        for (final T s : array) {
            list.add(s);
        }
        return list;
    }
}

```

### 2.3  Collection.toArray()方法使用的坑&如何反转数组

```Java
public class ArraysTest3 {
    public static void main(String[] args) {
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        System.out.println(list);
        Collections.reverse(list);
//        s = (String[]) list.toArray();
        s= list.toArray(new String[0]);//没有指定类型的话会报错
        for (String s1 : s) {
            System.out.print(s1+"\t");
        }

    }
}
```

由于JVM优化，`new String[0]`作为`Collection.toArray()`方法的参数现在使用更好，`new String[0]`就是起一个模板的作用，指定了返回数组的类型，0是为了节省空间，因为它只是为了说明返回的类型。

### 2.4 foreach 循环里进行元素的 remove/add 操作注意点

如果要进行`remove`操作，可以调用迭代器的 `remove `方法而不是集合类的 remove 方法。因为如果列表在任何时间从结构上修改创建迭代器之后，以任何方式除非通过迭代器自身`remove/add`方法，迭代器都将抛出一个`ConcurrentModificationException`,这就是单线程状态下产生的 **fail-fast 机制**。

**fail-fast 机制** ：多个线程对 fail-fast 集合进行修改的时，可能会抛出ConcurrentModificationException，单线程下也会出现这种情况。

`java.util`包下面的所有的集合类都是fail-fast的，而`java.util.concurrent`包下面的所有的类都是fail-safe的。

```Java
        List<String> userNames = new ArrayList<String>();
         userNames.add("Hollis");
         userNames.add("hollis");
         userNames.add("HollisChuang");
         userNames.add("H");

        //        for (String userName : userNames) {  // java.util.ConcurrentModificationException
//            if (userName.equals("Hollis")) {
//                userNames.remove(userName);
//            }
//        }

            //直接使用普通for循环进行操作
//        for (int i = 0; i < userNames.size(); i++) {
//            if (userNames.get(i).equals("Hollis")) {
//                userNames.remove(i);
//            }
//        }



        //直接使用Iterator进行操作
//        Iterator iterator = userNames.iterator();
//        while (iterator.hasNext()){
//            if (iterator.next().equals("Hollis")){
//                iterator.remove();
//            }
//        }

        //使用Java 8中提供的filter过滤
        userNames = userNames.stream().filter(userName ->!userName.equals("Hollis")).collect(Collectors.toList());

        System.out.println("userNames:"+userNames);

        //直接使用fail-safe的集合类
        ConcurrentLinkedDeque<String> userNames1 = new ConcurrentLinkedDeque<>();
        userNames1.add("Hollis");
        userNames1.add("hollis");
        userNames1.add("HollisChuang");
        userNames1.add("H");
        for (String username : userNames1) {
            if (username.equals("Hollis")) {
                userNames1.remove();
            }

        }
        System.out.println("userNames1:"+userNames1);
```



[foreach 循环里进行元素的 remove/add 操作注意点](https://blog.csdn.net/qq_36827957/article/details/88415168)