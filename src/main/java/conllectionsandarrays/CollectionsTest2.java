package conllectionsandarrays;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: deng
 * @date: 2020/1/20
 * @time: 15:22
 * @desc： Collections 工具类常用方法 查找,替换操作
 */
public class CollectionsTest2 {
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
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(3);
        arrayList2.add(-5);
        arrayList2.add(7);
        System.out.println("原始数组:" + arrayList);

        // int binarySearch(List list, Object key):对List进行二分查找，返回索引，注意List必须是有序的
//        Collections.sort(arrayList);
//        System.out.println("升序排序:"+arrayList);
//        int i = Collections.binarySearch(arrayList,-5);
//        System.out.println("对List进行二分查找元素为-5的索引:"+i);

        // int max(Collection coll):根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
        Integer max = Collections.max(arrayList);
        System.out.println("查找最大元素:" + max);
        Integer min = Collections.min(arrayList);
        System.out.println("查找最小元素:" + min);

        // int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
        Integer max1 = Collections.max(arrayList, Integer::compareTo);
        System.out.println("按照定制排序规则查找:" + max1);
        Integer min1 = Collections.min(arrayList, Integer::compareTo);
        System.out.println("按照定制排序规则查找:" + min1);

        // void fill(List list, Object obj):用指定的元素代替指定list中的所有元素。
//        Collections.fill(arrayList, 10);
//        System.out.println("用指定的元素代替指定list中的所有元素:" + arrayList);

        // int frequency(Collection c, Object o):统计元素出现次数
        int frequency = Collections.frequency(arrayList, 3);
        System.out.println("统计元素出现次数:" + frequency);

        // int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
        int indexOfSubList = Collections.indexOfSubList(arrayList, arrayList2);
        System.out.println(indexOfSubList);
        int lastIndexOfSubList = Collections.lastIndexOfSubList(arrayList, arrayList2);
        System.out.println(lastIndexOfSubList);

        // boolean replaceAll(List list, Object oldVal, Object newVal):用新元素替换旧元素
        Collections.replaceAll(arrayList, 3, 100);
        System.out.println(arrayList);


        //对象集合
        List<Student> students = new ArrayList<>();
        Student a = new Student("A", 10, LocalDate.now());
        Student b = new Student("B", 12, LocalDate.now().minusMonths(1));
        Student c = new Student("C", 11, LocalDate.now().minusMonths(2));
        students.add(a);
        students.add(b);
        students.add(c);
        Student maxAgeStudent = Collections.max(students, Comparator.comparing(o -> o.age));

        System.out.println(maxAgeStudent);

        Student maxBirthdayStudent = Collections.max(students, Comparator.comparing(o -> o.birthday));
        System.out.println(maxBirthdayStudent);
    }

    static class Student {
        String name;
        Integer age;
        LocalDate birthday;

        public Student() {
        }

        public Student(String name, Integer age, LocalDate birthday) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
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

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", birthday=" + birthday +
                    '}';
        }
    }
}
