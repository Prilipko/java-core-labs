package collections.impl.SimpleLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

import collections.impl.SimpleList;

public class SimpleLinkedList_q<E> implements SimpleList<E> {
    private Node<E> first = null; // head
    private Node<E> last = null; // tail
    private int size = 0;

    // *** *** *** ADD *** *** ***
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }

    public void add(int index, E element) {
        checkIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    // *** *** *** READ *** *** ***
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    class Itr implements Iterator<E> {

        private Node<E> itr = first; // head
        private Node<E> del = null; // head

        @Override
        public boolean hasNext() {
            return itr != null;
        }

        @Override
        public E next() {
            del = itr;
            itr = itr.next;
            return del.item;
        }

        @Override
        public void remove() {
            if (itr != null) {
                unlink(del);
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            Node<E> itr = first; // head
            while (itr != null) {
                consumer.accept((E) itr.item);
                itr = itr.next;
            }
        }
    }

    // *** *** *** CHECK *** *** ***
    public boolean contains(Object hasElement) {
        return indexOf(hasElement) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // *** *** *** MUTATE *** *** ***
    public E set(int index, E newElement) {
        checkIndex(index);
        Node<E> foundNode = node(index);
        E oldVal = foundNode.item;
        foundNode.item = newElement;
        return oldVal;
    }

    // *** *** *** REMOVE *** *** ***
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    // *** *** *** OBJECT METHODS *** *** ***
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleLinkedList_q that = (SimpleLinkedList_q) o;

        if (size != that.size) return false;

        if (first == that.first)
            return true;
        if (first == null || that.first == null)
            return false;

        Node<E> x = first;
        for (Object oThat : that) {
            if (!(oThat == null ? x.item == null : oThat.equals(x.item)))
                return false;
            x = x.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (first == null) {
            return 0;
        }
        int result = 1;
        for (Node<E> x = first; x != null; x = x.next) {
            E element = x.item;
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        if (first == null)
            return "null";

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (Node<E> x = first; x != null; x = x.next) {
            E element = x.item;
            b.append(String.valueOf(element));
            if (x.next != null) {
                b.append(", ");
            }
        }
        return b.append(']').toString();
    }

    // ---------- internals ----------
    private void checkIndex(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    private E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private void linkLast(E e) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, e, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
    }

    private void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    private static class Node<T> {
        private Node<T> prev;
        private T item;
        private Node<T> next;

        private Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
