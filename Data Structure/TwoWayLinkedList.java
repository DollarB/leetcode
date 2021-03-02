/**
 * 双向链表
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/18 16:13
 */
public class TwoWayLinkedList {
    private Node head;
    private Node tail;
    private int length;
    private int size;

    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data) {
            this.data = data;
        }
    }

    public TwoWayLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * 在链表头部增加节点
     *
     * @param value
     */
    public void addHead(Object value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * 在链表尾部增加节点
     *
     * @param value
     */
    public void addTail(Object value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    /**
     * 删除链表的头部节点
     *
     * @return
     */
    public Node deleteHead() {
        Node temp = head;
        if (length != 0) {
            head = head.next;
            head.prev = null;
            length--;
            return temp;
        } else {
            return null;
        }
    }

    /**
     * 删除链表的尾部节点
     * @return
     */
    public Node deleteTail() {
        Node temp = tail;
        if (length != 0) {
            tail = tail.prev;
            tail.next = null;
            length--;
            return temp;
        } else {
            return null;
        }
    }

    /**
     * 打印链表
     */
    public void print() {
        TwoWayLinkedList.Node current = head;
        for (int i = 0; i < length; i++) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }
}
