package conllectionsandarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author: deng
 * @date: 2020/1/20
 * @time: 16:27
 * @desc: Collections 工具类常用方法 同步控制
 */
public class CollectionsTest3 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student = new Student("wang", "111");
        Student student1 = new Student("li", "112");
        Student student2 = new Student("zhang", "113");
        Student student3 = new Student("wang", "114");
        Student student4 = new Student("wang", "115");
        Student student5 = new Student("wang", "116");
        Student student6 = new Student("wang", "117");
        Student student7 = new Student("wang", "118");
        Student student8 = new Student("wang", "119");
        Student student9 = new Student("wang", "120");
        Student student10 = new Student("wang", "121");
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        // hashSet 去重
//        HashSet<Student> set = new HashSet();
//        set.addAll(students);
//        List<Student> disStudents = new ArrayList<>();
//        disStudents.addAll(set);
//        for (Student disStudent : disStudents) {
//            System.out.println(disStudent);
//        }

        // 双重for去重
//        List<Student> disStudents = new ArrayList<>();
//        for (int i = 0; i < students.size(); i++) {
//            for (int j = i + 1; j < students.size(); j++) {
//                if (students.get(i).getName().equals(students.get(j).getName())) {
//                    j = ++i;
//                }
//            }
//            disStudents.add(students.get(i));
//        }
//        for (Student disStudent : disStudents) {
//            System.out.println(disStudent);
//        }

    }

    static class Student {
        private String name;
        private String phoneNumber;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Student(String name, String phoneNumber) {
            super();
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            Student student = (Student) o;

            return name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

}
