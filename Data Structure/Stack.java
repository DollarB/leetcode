package com.example.interview.util.data;

/**
 * @Author: yage
 * @Email: yage@fordeal.com
 * @Date: 2021/01/18 14:21
 */
public class Stack<E> {
    private Object[] data = null;
    private int maxSize = 0;
    private int top = -1;

    public Stack() {
        this(10);
    }

    Stack(int initalSize) {
        if (initalSize >= 0) {
            this.maxSize = initalSize;
            data = new Object[initalSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于0: " + initalSize);
        }
    }

    /**
     * 数据入栈
     *
     * @param e
     * @return
     */
    public boolean push(E e) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满, 无法将元素入栈!");
        } else {
            data[++top] = e;
            return true;
        }
    }

    /**
     * 数据出栈
     *
     * @return
     */
    public E pop() {
        if (top == -1) {
            throw new RuntimeException("栈为空!");
        } else {
            return (E) data[top--];
        }
    }

    /**
     * 数据查询
     *
     * @return
     */
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("栈为空!");
        } else {
            return (E) data[top];
        }
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return (top == -1);
    }
}
