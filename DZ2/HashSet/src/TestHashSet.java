public class TestHashSet {
    public static void main(String[] args) {
        // Можно использовать println() для простоты вывода
        System.out.println("Hello and welcome!");

        MyHashSet<Integer> set = new MyHashSet<>();

        // Вставляем элементы
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // Попытка добавить 20 повторно не изменит множество

        System.out.println("После вставки: " + set); // Например: {10, 20, 30}

        // Удаляем элемент
        set.remove(20);
        System.out.println("После удаления 20: " + set); // Например: {10, 30}

    }
}
