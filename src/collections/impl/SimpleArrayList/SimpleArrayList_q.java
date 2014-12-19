package collections.impl.SimpleArrayList;

import collections.impl.SimpleList;

import java.util.*;
import java.util.function.Consumer;

import static java.lang.Math.max;

public class SimpleArrayList_q<E> implements SimpleList<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public SimpleArrayList_q() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SimpleArrayList_q(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    // *** *** *** ADD *** *** ***
    @Override
    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        data[size] = newElement;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    // *** *** *** READ *** *** ***
    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = data;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                SimpleArrayList_q.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = SimpleArrayList_q.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = SimpleArrayList_q.this.data;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size ) {
                consumer.accept((E) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
        }
    }


    // *** *** *** CHECK *** *** ***
    @Override
    public boolean contains(Object element) {
        if (element == null) { // look for null
            for (int k = 0; k < size; k++) {
                if (null == data[k]) {
                    return true;
                }
            }
        } else { // look for !null
            for (int k = 0; k < size; k++) {
                if (element.equals(data[k])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // *** *** *** MUTATE *** *** ***
    @Override
    public E set(int index, E newElement) {
        rangeCheck(index);
        E oldElement = data[index];
        data[index] = newElement;
        return oldElement;
    }

    // *** *** *** REMOVE *** *** ***
    @Override
    public boolean remove(Object element) {
        if (element == null) { // exception
            throw new NullPointerException("Can not remove null element");
        } else { // look for
            for (int k = 0; k < size; k++) {
                if (element.equals(data[k])) {
                    remove(k);
                    return true;
                }
            }
        }
        return false;
//        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return oldValue;
    }

    // *** *** *** OBJECT METHODS *** *** ***
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleArrayList_q that = (SimpleArrayList_q) o;

        if (size != that.size) return false;

        if (data == that.data)
            return true;
        if (data == null || that.data == null)
            return false;

        int length = data.length;

        for (int i = 0; i < length; i++) {
            Object o1 = data[i];
            Object o2 = that.data[i];
            if (!(o1 == null ? o2 == null : o1.equals(o2)))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        if (data == null) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < size; i++) {
            E element = data[i];
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        if (data == null)
            return "null";

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(data[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    // ---------- internals ----------
    private void rangeCheck(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }
}