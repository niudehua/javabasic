package datastructures;

/**
 * @author:deng
 * @date: 2020/4/23
 * @time: 2:42 下午
 * @desc： 数据结构-链表
 */
public class MyLinked {
    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 头节点指针
     */
    private Node head;
    /**
     * 尾节点指针
     */
    private Node last;
    /**
     * 链表实际长度
     */
    private int size;

    /**
     * 链表插入元素
     *
     * @param data  插入元素
     * @param index 插入位置
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            //空链表
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            //插入头部
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            //插入尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            //插入中间
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size++;
    }

    /**
     * 链表查找元素
     *
     * @param index 查找的位置
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            //从头节点开始循环，找到index前的元素从中获取next元素
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 链表删除元素
     *
     * @param index 删除的位置
     * @return
     */
    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node removeNode = null;
        if (index == 0) {
            //删除头节点
            head = head.next;
            removeNode = head;
        } else if (index == size) {
            //删除尾节点
            Node preNode = get(index - 1);
            last = preNode.next;
            removeNode = last;
        } else {
            //删除中间节点
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return removeNode;
    }

    /**
     * 链表内容输出
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinked myLinked = new MyLinked();
        myLinked.insert(3, 0);
        myLinked.insert(7, 1);
        myLinked.insert(9, 2);
        myLinked.insert(19, 3);
        myLinked.insert(29, 4);
        myLinked.remove(3);
        myLinked.output();
    }

}
