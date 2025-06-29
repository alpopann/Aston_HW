package student;

import java.util.*;

public class Student {
    private final String name;
    private final List<Book> books = new ArrayList<>();

    public Student(String name) {
        this(name, Collections.emptyList());
    }

    public Student(String name, List<Book> books) {
        this.name  = Objects.requireNonNull(name,  "name не может быть null");
        List<Book> safeBooks = Objects.requireNonNull(books, "books не может быть null");
        this.books.addAll(safeBooks);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public boolean addBook(Book book) {
        Objects.requireNonNull(book, "book не может быть null");
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', books=" + books + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student that = (Student) o;
        return name.equals(that.name) &&
                books.equals(that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}
