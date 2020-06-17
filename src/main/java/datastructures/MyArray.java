package datastructures;

/**
 * @author: deng
 * @date: 2020/4/23
 * @time: 1:53 下午
 * @desc： 数据结构-数组
 */
public class MyArray {
    private int size;
    private int[] array;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     *
     * @param element 插入的元素
     * @param index   插入的下标
     */
    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际范围");
        }
        //如果实际元素达到数组容量上限，则对数组进行扩容
        if (size >= array.length) {
            resize();
        }
        // 从右向左循环，将元素逐个向右移一位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //腾出的位置放入新元素
        array[index] = element;
        //增加数组大小
        size++;
    }

    /**
     * 数组删除元素
     *
     * @param index 删除的位置
     */
    public int delete(int index) {
        if (index < 0 || index >= size) {
            // 判断下标是否超出范围
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        //要删除的元素
        int deleteElement = array[index];
        //从要删除的下标位置开始从左往右循环，将元素逐个从右往左移一位
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteElement;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] newArray = new int[array.length * 2];
        //从旧数组复制到新数组
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 数组内容输出
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        MyArray myArray = new MyArray(4);
        myArray.insert(2, 0);
        myArray.insert(3, 1);
        myArray.insert(4, 2);
        myArray.insert(7, 3);
        myArray.insert(11, 4);
        myArray.insert(22, 5);
        myArray.output();
        int delete = myArray.delete(3);
        System.out.println(delete + "------");
        myArray.output();
        myArray.insert(33, 3);
        myArray.output();
    }
}
