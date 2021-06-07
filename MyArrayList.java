public class MyArrayList<T> {

    private int size;
    private T[] elementData;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        size = 0;
        elementData = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        size = 0;
        elementData = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int capacity) {
        while (elementData.length < capacity) {
            T[] newElementData = (T[]) new Object[size * 3 / 2 + 1];
            System.arraycopy(elementData, 0, newElementData, 0, size);
            elementData = newElementData;
        }
    }

    public int length() {
        return size;
    }

    public T get(int index) {
        if (index < size) {
            return elementData[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: 0 - " + size);
        }
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        elementData[size++] = value;
    }

    public void add(int index, T value) {
        if (size - index >= 0) {
            ensureCapacity(size + 1);
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: 0 - " + size);
        }
    }

    public void addAll(T[] values) {
        ensureCapacity(size + values.length);
        System.arraycopy(values, 0, elementData, size, values.length);
        size += values.length;
    }

    public void addAll(int index, T[] values) {
        if (size - index >= 0) {
            ensureCapacity(size + values.length);
            System.arraycopy(elementData, index, elementData, index + values.length, size - index);
            System.arraycopy(values, 0, elementData, index, values.length);
            size += values.length;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: 0 - " + size);
        }
    }

    public void remove(int index) {
        if (size - index >= 0) {
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
            elementData[size--] = null;
        }
    }

    public void remove(T value) { // спросить у Севы
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                remove(i);
                return;
            }
        }
        throw new IndexOutOfBoundsException("Index out of bounds: 0 - " + size);
    }

}
