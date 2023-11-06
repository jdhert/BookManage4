package library;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrayListBM implements BookRepository{
    static private final ArrayList<Book> bookList = new ArrayList<>();

    static private final List<Book> duplicationList = new ArrayList<>();
    @Override
    public void addBook(Long id, Book book, boolean check) {
            if(check) {
                if(bookList.contains(book))
                    duplicationList.add(book);
                bookList.add(book);
            }
            else {
                Check(id);
                bookList.set(index, book);
            }
    }
    @Override
    public void PrintBook() {
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }
    @Override
    public Book getBook(Long id) {
        return Check(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public List<Book> getDistinct() {
        return bookList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Book> getDup() {
        return duplicationList;
    }

    @Override
    public void removeBook(long id) {
        Book check = Check(id);
        if(check != null) {
            bookList.remove(check);
            duplicationList.remove(check);
            System.out.println("삭제가 완료되었습니다.");
        } else System.out.println("해당 도서가 존재하지 않습니다.");
    }

    private static int index;
    public Book Check(long id) {
        for(int i=0; i<bookList.size(); i++){
            if(bookList.get(i).getId().equals(id)){
                index = i;
                return bookList.get(i);
            }
        } return null;
    }
}
