package com.example.interview.util.data;

/**
 * 单链表
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/18 15:17
 */
public class SingleLinkedList {
    private int length;
    private int size;
    private Node head;

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 插入数据
     *
     * @param obj
     * @return
     */
    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (length == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        length++;
        return obj;
    }

    /**
     * 删除单向链表数据
     *
     * @param value
     * @return
     */
    public boolean delete(Object value) {
        if (length == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == head) {
            head = current.next;
            length--;
        } else {
            previous.next = current.next;
            length--;
        }
        return true;
    }

    /**
     * 单向链表数据查询
     *
     * @param obj
     * @return
     */
    public Node find(Object obj) {
        Node current = head;
        int tempSize = length;
        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    /**
     * 打印链表
     */
    public void print() {
        Node current = head;
        for (int i = 0; i < length; i++) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }
}
