package library;



import java.util.List;
import java.util.function.Predicate;

public interface BookRepository {
    void addBook(Long id, Book book);

    void PrintBook(Long id);
    Book getBook(Long id);
    List<Book> getBooks();
    List<Book> getBooks(Predicate<Book> predicate);
    boolean setBook(Book book);
    boolean removeBook(Book book);
}
