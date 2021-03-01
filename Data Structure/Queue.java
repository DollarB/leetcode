/**
 * 队列
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/18 14:46
 */
public class Queue<E> {
    private Object[] data = null;
    private int maxSize;
    private int front;
    private int rear;

    public Queue() {
        this(10);
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public Queue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear - 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0: " + initialSize);
        }
    }

    /**
     * 在队列的尾部插入数据
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满, 无法插入新的元素!");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    /**
     * 在队列里读取数据
     *
     * @return
     */
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常!");
        } else {
            E value = (E) data[front];
            data[front++] = null;
            return value;
        }
    }

    /**
     * 队列数据查询
     *
     * @return
     */
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常!");
        } else {
            return (E) data[front];
        }
    }
}
