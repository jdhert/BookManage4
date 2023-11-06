package library;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface BookRepository {
    void addBook(Long id, Book book, boolean check);
    void PrintBook();
    Book getBook(Long id);
    List<Book> getBooks();
    List<Book> getDistinct();
    List<Book> getDup();
    void removeBook(long id);

    void fileSave() throws IOException;

    void loadBooks() throws IOException, ClassNotFoundException;
}
