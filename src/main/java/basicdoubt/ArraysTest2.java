package basicdoubt;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deng
 * @date: 2020/1/8
 * @time: 11:16
 * @desc： 如何正确的将数组转换为ArrayList
 */
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
        System.out.println(i1.getClass() + ":" + i1);// class com.google.common.collect.RegularImmutableList:[string, elements]
        String[] aStringArray = {"hehe", "haha", "hoho"};
        List<String> i2 = ImmutableList.copyOf(aStringArray);      // from array
        System.out.println(i2.getClass() + ":" + i2);//class com.google.common.collect.RegularImmutableList:[hehe, haha, hoho]

        List<String> l1 = Lists.newArrayList(i1);    // from collection
        System.out.println(l1.getClass() + ":" + l1);// class java.util.ArrayList:[string, elements]

        List<String> l2 = Lists.newArrayList(aStringArray); // from array
        System.out.println(l2.getClass() + ":" + l2);// class java.util.ArrayList:[hehe, haha, hoho]

        List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from varargs
        System.out.println(l3.getClass() + ":" + l3);// class java.util.ArrayList:[or, string, elements]


        // 使用 Apache Commons Collections
        List<String> list = new ArrayList<String>();
        CollectionUtils.addAll(list, "hahaha");
        CollectionUtils.addAll(list, "hehehe");
        System.out.println(list.getClass() + "：" + list); // class java.util.ArrayList：[hahaha, hehehe]

    }

    /**
     * 自己动手实现（教育目的） 将数组遍历add进实例化的集合
     *
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
