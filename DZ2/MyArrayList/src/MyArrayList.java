import java.util.Collection;
import java.util.Arrays;

public class MyArrayList<E> {
    // Внутренний массив для хранения элементов
    private Object[] elements;
    // Количество фактически хранимых элементов
    private int size;
    // Начальный размер внутреннего массива
    private static final int DEFAULT_CAPACITY = 10;

    // Конструктор по умолчанию
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     * Если внутренний массив заполнен, происходит его расширение.
     */
    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по индексу
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Все элементы, находящиеся правее удалённого, сдвигаются влево.
     *
     * @param index индекс удаляемого элемента
     * @return удалённый элемент
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public E remove(int index) {
        rangeCheck(index);
        E removed = (E) elements[index];
        // Сдвигаем оставшиеся элементы влево
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // Обнуляем последний элемент, чтобы не было утечки памяти
        elements[--size] = null;
        return removed;
    }

    /**
     * Добавляет все элементы из переданной коллекции в конец списка.
     *
     * @param c коллекция элементов для добавления
     * @return true если коллекция не пуста и элементы были добавлены, иначе false
     * @throws NullPointerException если переданная коллекция равна null
     */
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Переданная коллекция равна null");
        }
        // Расширяем вместимость, если необходимо
        ensureCapacity(size + c.size());
        boolean modified = false;
        for (E element : c) {
            add(element);
            modified = true;
        }
        return modified;
    }

    /**
     * Возвращает количество элементов в списке.
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, что внутренний массив имеет нужную вместимость.
     * Если необходимое количество элементов больше текущей вместимости,
     * увеличивает массив в два раза или до нужного размера.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Проверяет, что индекс находится в пределах [0, size).
     *
     * @param index индекс для проверки
     * @throws IndexOutOfBoundsException если индекс недопустим
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }

    /**
     * Переопределённый метод toString для удобного вывода содержимого списка.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
