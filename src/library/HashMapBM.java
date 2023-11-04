package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HashMapBM implements BookRepository{
    static final HashMap<Long, Book> bookList = new HashMap<>();
    @Override
    public boolean addBook(Long id, Book book, boolean check) {
        if (!bookList.containsValue(book)) {
            bookList.put(id, book);
            return true;
        } else return false;
    }

    @Override
    public void PrintBook() {
        bookList.forEach((key, b) -> System.out.println(b.toString()));
    }

    @Override
    public Book getBook(Long id) {
        return bookList.get(id);
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public List<Book> getBooks(Predicate<Book> predicate) {
        return null;
    }

    @Override
    public void removeBook(long id) {
        if(bookList.get(id) != null) {
            bookList.remove(id);
            System.out.println("삭제가 완료되었습니다.");
        } else System.out.println("해당 도서가 존재하지 않습니다.");
    }
}
