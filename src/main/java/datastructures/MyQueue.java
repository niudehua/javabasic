package datastructures;


/**
 * @author:deng
 * @date: 2020/4/23
 * @time: 4:20 下午
 * @desc： 数据结构-队列
 */
public class MyQueue {
    /**
     * 数组
     */
    int[] array;
    /**
     * 队头
     */
    int front;
    /**
     * 队尾
     */
    int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 入队的元素
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;

    }

    /**
     * 出队
     *
     * @return 出队的元素
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        MyQueue myQueue = new MyQueue(4);
        myQueue.enQueue(3);
        myQueue.output();
        myQueue.enQueue(4);
        myQueue.output();
        myQueue.enQueue(5);
        myQueue.output();
        myQueue.deQueue();
        myQueue.output();
        myQueue.deQueue();
        myQueue.output();
        myQueue.deQueue();
        myQueue.output();
    }
}
