package conllectionsandarrays;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: deng
 * @date: 2020/1/20
 * @time: 13:55
 * @desc： Collections 工具类常用方法 排序操作
 */

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        System.out.println("原始数组：" + arrayList);

        // void reverse (List list):反转
        Collections.reverse(arrayList);
        System.out.println("反转后的数组：" + arrayList);

        // void shuffle (List list):随机排序
//        Collections.shuffle(arrayList);
//        System.out.println("随机排序后的数组：" + arrayList);

        // void sort (List list):按自然排序的升序排序
//        Collections.sort(arrayList);
//        System.out.println("自然排序升序:" + arrayList);

        // void sort (List list, Comparator c):定制排序，由Comparator控制排序逻辑
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("定制排序，由Comparator控制排序逻辑:" + arrayList);

        // void sort (List list, Comparator c):定制排序，由Comparator控制排序逻辑
        Collections.sort(arrayList, Integer::compareTo);
        System.out.println("定制排序，由Comparator控制排序逻辑升序:" + arrayList);

        // void sort (List list, Comparator c):定制排序，由Comparator控制排序逻辑
        Collections.sort(arrayList, Comparator.reverseOrder());
        System.out.println("定制排序，由Comparator控制排序逻辑降序:" + arrayList);

        // void swap (List list,int i, int j):交换两个索引位置的元素
        Collections.swap(arrayList, 5, 0);
        System.out.println("交换索引5和索引0的元素:" + arrayList);

        // void rotate (List list,int distance):旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。
        Collections.rotate(arrayList, -2);
        System.out.println("旋转前2个元素到最后:" + arrayList);

        //对象集合定制排序规则
        List<Student> students = new ArrayList<>();
        Student a = new Student("A", 10, LocalDate.now());
        Student b = new Student("B", 12, LocalDate.now().minusMonths(1));
        Student c = new Student("C", 11, LocalDate.now().minusMonths(2));
        students.add(a);
        students.add(b);
        students.add(c);
        System.out.println("原始对象数组:" + students);
        // 按生日排序 降序
        Collections.sort(students, (o1, o2) -> o2.birthday.compareTo(o1.birthday));
        System.out.println("按生日降序:" + students);
        // 按生日排序 升序
        Collections.sort(students, Comparator.comparing(o -> o.birthday));
        System.out.println("按生日升序:" + students);

        // 按年龄排序 升序
        Collections.sort(students, Comparator.comparing(o -> o.age));
        System.out.println("按年龄升序:" + students);

        // 按年龄排序 降序
        Collections.sort(students, (o1, o2) -> o2.age.compareTo(o1.age));
        System.out.println("按年龄降序:" + students);
    }


    static class Student {
        String name;
        Integer age;
        LocalDate birthday;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", birthday=" + birthday +
                    '}';
        }

        public Student() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }

        public Student(String name, Integer age, LocalDate birthday) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
        }
    }
}
