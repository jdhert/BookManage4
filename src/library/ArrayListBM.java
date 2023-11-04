package library;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListBM implements BookRepository{
    static final ArrayList<Book> bookList = new ArrayList<>();
    @Override
    public boolean addBook(Long id, Book book, boolean check) {
        if (!bookList.contains(book)) {
            if(check)
                bookList.add(book);
            else {
                Check(id);
                bookList.set(index, book);
            }
            return true;
        } else return false;
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
    public List<Book> getBooks(Predicate<Book> predicate) {
        return null;
    }

    @Override
    public void removeBook(long id) {
        Book check = Check(id);
        if(check != null) {
            bookList.remove(check);
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
