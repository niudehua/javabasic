package basicdoubt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: deng
 * @date: 2020/1/8
 * @time: 10:59
 * @desc： 集合使用指南
 */
public class ArraysTest {
    public static void main(String[] args) {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        System.out.println(myList); // [Apple, Banana, Orange]
        //上面两个语句等价于下面一条语句
        List<String> myList1 = Arrays.asList("Apple", "Banana", "Orange");
        System.out.println(myList1); // [Apple, Banana, Orange]

        List list = new ArrayList();


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
        Integer[] myArray1 = {1, 2, 3};
        List myList3 = Arrays.asList(myArray1);
        System.out.println(myList3.size()); // 3
        System.out.println(myList3.get(0)); // 1
        System.out.println(myList3.get(1)); // 2
    }
}
