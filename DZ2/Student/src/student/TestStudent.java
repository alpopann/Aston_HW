package student;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.*;

public class TestStudent {
    public static void main(String[] args) {
        // 1) Имена 10 студентов
        List<String> studentNames = List.of(
                "Иван Иванов", "Мария Петрова", "Сергей Смирнов",
                "Ольга Козлова", "Дмитрий Попов", "Анна Соколова",
                "Павел Михайлов", "Елена Новикова", "Алексей Фёдоров",
                "Светлана Морозова"
        );

        // 2) 100 названий книг
        List<String> titles = List.of("Pride and Prejudice", "1984", "To Kill a Mockingbird",
                "The Great Gatsby", "Moby-Dick", "War and Peace",
                "Crime and Punishment", "The Catcher in the Rye",
                "The Hobbit", "Brave New World", "Jane Eyre",
                "Wuthering Heights", "Animal Farm",
                "The Lord of the Rings", "The Kite Runner",
                "The Da Vinci Code", "The Alchemist",
                "Les Misérables", "The Chronicles of Narnia",
                "A Tale of Two Cities", "Anna Karenina", "Ulysses",
                "Don Quixote", "The Odyssey", "Madame Bovary",
                "The Brothers Karamazov",
                "Harry Potter and the Sorcerer’s Stone",
                "One Hundred Years of Solitude",
                "The Picture of Dorian Gray", "Dracula",
                "The Grapes of Wrath", "Catch-22",
                "Slaughterhouse-Five", "The Sun Also Rises",
                "Lord of the Flies", "Fahrenheit 451",
                "The Count of Monte Cristo", "Great Expectations",
                "The Old Man and the Sea", "Frankenstein",
                "Lolita", "Invisible Man", "Don Juan",
                "A Clockwork Orange", "The Handmaid’s Tale",
                "Beloved", "Rebecca", "Emma",
                "Sense and Sensibility", "The Scarlet Letter",
                "Life of Pi", "The Road", "The Hunger Games",
                "The Girl with the Dragon Tattoo", "Gone with the Wind",
                "The Fault in Our Stars", "Me Before You", "The Help",
                "Divergent", "The Martian", "Ready Player One",
                "Angels & Demons", "Digital Fortress", "Deception Point",
                "The Girl on the Train", "Big Little Lies",
                "The Goldfinch", "The Shack", "Eleanor & Park",
                "It", "The Stand", "Misery", "Pet Sematary",
                "Carrie", "The Shining", "The Exorcist",
                "The Silence of the Lambs", "Interview with the Vampire",
                "Dr. Jekyll and Mr. Hyde", "The Call of the Wild",
                "White Fang", "Of Mice and Men", "East of Eden",
                "Tuesdays with Morrie", "A Wrinkle in Time",
                "The Wind in the Willows", "The Secret Garden",
                "Charlotte’s Web", "Matilda", "The Little Prince",
                "Harry Potter and the Chamber of Secrets",
                "Harry Potter and the Prisoner of Azkaban",
                "Harry Potter and the Goblet of Fire",
                "Harry Potter and the Order of the Phoenix",
                "Harry Potter and the Half-Blood Prince",
                "Harry Potter and the Deathly Hallows"
        );

        // 3) 20 авторов
        List<String> authors = List.of("Jane Austen", "George Orwell", "Harper Lee",
                "F. Scott Fitzgerald", "Herman Melville", "Leo Tolstoy",
                "Fyodor Dostoevsky", "J.D. Salinger", "J.R.R. Tolkien",
                "Aldous Huxley", "Charlotte Brontë", "Emily Brontë",
                "Mark Twain", "Charles Dickens", "Victor Hugo",
                "Gabriel García Márquez", "Dan Brown", "Paulo Coelho",
                "Margaret Atwood", "Suzanne Collins"
        );

        // 4) Собираем каталог из 100 книг
        List<Book> allBooks = IntStream.range(0, titles.size())
                .mapToObj(i -> new Book(
                        titles.get(i),
                        authors.get(i % authors.size()),
                        100 + ThreadLocalRandom.current().nextInt(400),
                        1950 + ThreadLocalRandom.current().nextInt(76)
                ))
                .toList();

        // 5) Раздаём каждому по N книг, где N ~ N(μ=5, σ=2), с обрезкой [0, allBooks.size()]
        List<Student> students = studentNames.stream()
                .map(name -> {
                    // нормальное отклонение
                    double gaussian = ThreadLocalRandom.current().nextGaussian();
                    int mean = 5, stdDev = 2;
                    int count = (int) Math.round(gaussian * stdDev + mean);

                    // обрезаем к границам
                    count = Math.max(0, Math.min(count, allBooks.size()));

                    // тасуем и берём первые count штук
                    List<Book> copy = new ArrayList<>(allBooks);
                    Collections.shuffle(copy);
                    List<Book> chosen = copy.subList(0, count);

                    return new Student(name, chosen);
                })
                .toList();

        // 6) Ваш стрим-конвейер
        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .findAny()
                .ifPresentOrElse(
                        b -> System.out.println("Год: " + b.getYear()),
                        () -> System.out.println("Книга не найдена")
                );
    }
}
