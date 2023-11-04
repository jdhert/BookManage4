package library;



import java.util.List;
import java.util.function.Predicate;

public interface BookRepository {
    boolean addBook(Long id, Book book, boolean check);
    void PrintBook();
    Book getBook(Long id);
    List<Book> getBooks();
    List<Book> getBooks(Predicate<Book> predicate);
    void removeBook(long id);
}
