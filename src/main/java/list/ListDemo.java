package list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author:deng
 * @date: 2019/7/19
 * @time: 4:50 PM
 * @email 657563945@qq.com
 */
public class ListDemo {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        System.out.println(arrayList);
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        System.out.println(linkedList);


        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        System.out.println(list);
        System.out.println(list.stream().count());

    }

}
