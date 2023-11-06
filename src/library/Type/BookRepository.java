package library.Type;



import library.Book.Book;

import java.io.IOException;
import java.util.List;

public interface BookRepository {
    void addBook(Long id, Book book, boolean check);
    void PrintBook();
    public Book getBook(Long id);
    public List<Book> getBooks();
    List<Book> getDistinct();
    List<Book> getDup();
    void removeBook(long id);

}
