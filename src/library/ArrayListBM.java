package library;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListBM implements BookRepository{
    static final ArrayList<Book> bookList = new ArrayList<>();
    @Override
    public void addBook(Long id, Book book) {
        bookList.add(book);
    }

    @Override
    public void PrintBook(Long id) {

    }

    @Override
    public Book getBook(Long id) {
        return null;
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public List<Book> getBooks(Predicate<Book> predicate) {
        return null;
    }

    @Override
    public boolean setBook(Book book) {
        return false;
    }

    @Override
    public boolean removeBook(Book book) {
        return false;
    }
}
