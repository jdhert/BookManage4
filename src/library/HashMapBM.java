package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HashMapBM implements BookRepository{
    static private final HashMap<Long, Book> bookList = new HashMap<>();

    static private final List<Book> duplicationList = new ArrayList<>();
    @Override
    public void addBook(Long id, Book book, boolean check) {
        if(bookList.containsValue(book)) {
            duplicationList.add(book);
        }
        bookList.put(id, book);
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
    public List<Book> getDistinct() {
        return bookList.values().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Book> getDup() {
        return duplicationList;
    }

    @Override
    public void removeBook(long id) {
        if(bookList.get(id) != null) {
            bookList.remove(id);
            duplicationList.remove(Check(id));
            System.out.println("삭제가 완료되었습니다.");
        } else System.out.println("해당 도서가 존재하지 않습니다.");
    }
    public Book Check(long id) {
       for (Book b : duplicationList){
           if(b.getId().equals(id))
               return b;
       } return null;
    }
}
