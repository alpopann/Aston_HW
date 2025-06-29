package student;
import java.util.Objects;

public class Book {

    private final String title;
    private final String author;
    private final int pages;
    private final int year;

    public Book(String title, String author, int pages, int year) {
        this.title  = Objects.requireNonNull(title,  "title не может быть null");
        this.author = Objects.requireNonNull(author, "author не может быть null");
        if (pages <= 0) {
            throw new IllegalArgumentException("pages должно быть > 0");
        }
        this.pages = pages;
        this.year  = year;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public int    getPages()  { return pages; }
    public int    getYear()   { return year;   }

    @Override
    public String toString() {
        return "Book{" +
                "title='"  + title  + '\'' +
                ", author='" + author + '\'' +
                ", pages="   + pages  +
                ", year="    + year   +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return pages == b.pages &&
                year  == b.year  &&
                title.equals(b.title) &&
                author.equals(b.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages, year);
    }
}

