import java.util.LinkedList;

public class MyHashSet<E> {
    // Начальный размер массива ведер
    private static final int DEFAULT_CAPACITY = 16;
    // Массив ведер, в каждом ведре — связный список элементов
    private LinkedList<E>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        // Создаём массив и инициализируем каждое ведро
        buckets = (LinkedList<E>[]) new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Вычисляет индекс ведра для данного элемента на основе его hashCode.
     */
    private int getBucketIndex(E element) {
        // Чтобы избежать отрицательного индекса, используем Math.abs()
        return Math.abs(element.hashCode() % buckets.length);
    }

    /**
     * Метод для вставки элемента в коллекцию.
     * Если элемент уже присутствует, он не добавляется повторно.
     */
    public void add(E element) {
        int index = getBucketIndex(element);
        LinkedList<E> bucket = buckets[index];
        // Проверяем, что такого элемента ещё нет (уникальность)
        if (!bucket.contains(element)) {
            bucket.add(element);
        }
    }

    /**
     * Метод для удаления элемента из коллекции.
     */
    public void remove(E element) {
        int index = getBucketIndex(element);
        buckets[index].remove(element);
    }

    /**
     * Переопределённый метод toString для удобного вывода содержимого множества.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (LinkedList<E> bucket : buckets) {
            for (E element : bucket) {
                sb.append(element).append(", ");
            }
        }
        if (sb.length() > 1)
            sb.setLength(sb.length() - 2); // Убираем последнюю запятую и пробел
        sb.append("}");
        return sb.toString();
    }
}

