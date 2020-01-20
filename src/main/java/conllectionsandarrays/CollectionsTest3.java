package conllectionsandarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: deng
 * @date: 2020/1/20
 * @time: 16:27
 * @desc：Collections 工具类常用方法 同步控制
 */
public class CollectionsTest3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println(arrayList.getClass());
        List<Integer> integers = Collections.synchronizedList(arrayList);
        System.out.println(integers.getClass());

    }

}
