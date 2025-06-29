import java.util.ArrayList;
import java.util.List;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

        // Добавляем одиночные элементы
        myList.add(10);
        myList.add(20);
        myList.add(30);
        System.out.println("После добавления: " + myList); // Выведет, например: [10, 20, 30]

        // Получаем элемент по индексу
        System.out.println("Элемент с индексом 1: " + myList.get(1)); // Выведет 20

        // Удаляем элемент по индексу
        myList.remove(1);
        System.out.println("После удаления элемента с индексом 1: " + myList); // Выведет [10, 30]

        // Используем addAll для добавления элементов из стандартной коллекции
        List<Integer> additional = new ArrayList<>();
        additional.add(40);
        additional.add(50);
        myList.addAll(additional);
        System.out.println("После addAll: " + myList); // Выведет [10, 30, 40, 50]
    }
}
