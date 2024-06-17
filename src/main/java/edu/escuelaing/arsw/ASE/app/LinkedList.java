package edu.escuelaing.arsw.ASE.app;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of a generic linked list.
 *
 * @param <E> Type of elements stored in the list.
 */
public class LinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param element Element to be added.
     */
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Retrieves the element at the specified index in the linked list.
     *
     * @param index Index of the element to retrieve.
     * @return Element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the number of elements in the linked list.
     *
     * @return Size of the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the linked list.
     *
     * @return Iterator over the elements in the linked list.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Private static class representing a node in the linked list.
     *
     * @param <E> Type of data stored in the node.
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;

        /**
         * Constructs a node with the given data.
         *
         * @param data Data to be stored in the node.
         */
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
