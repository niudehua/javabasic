package basicdoubt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * @author: deng
 * @date: 2020/1/8
 * @time: 13:35
 * @desc： Collection.toArray()方法使用的坑&如何反转数组
 */
public class ArraysTest3 {
    public static void main(String[] args) {
        String[] s = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        System.out.println(list);
        Collections.reverse(list);
//        s = (String[]) list.toArray();
        s = list.toArray(new String[0]);//没有指定类型的话会报错
        for (String s1 : s) {
            System.out.print(s1 + "\t");
        }
        System.out.println("");


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
        userNames = userNames.stream().filter(userName -> !userName.equals("Hollis")).collect(Collectors.toList());

        System.out.println("userNames:" + userNames);

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
        System.out.println("userNames1:" + userNames1);

    }
}
