package GC;

import java.util.EmptyStackException;

/**
 * @author liweihua
 * @classname Stack
 * @description TODO
 * @date 2023/8/22 10:16
 */
public class Stack {
    private Object[] elements = new Object[10];
    private int size = 0;

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }


    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[2 * elements.length + 1];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }
}
