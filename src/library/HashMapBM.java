package library;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
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

    @Override
    public void fileSave() throws IOException {
        OutputStream os = new FileOutputStream("C:/Test/books.txt");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        bookList.forEach((key, book) -> {
            try {
                oos.writeObject(book);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        oos.flush();
        oos.close();
        os.close();
    }

    @Override
    public void loadBooks() throws IOException, ClassNotFoundException {
        FileInputStream is = new FileInputStream("C:/Test/books.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        int data = 0;
        while (true) {
            data = ois.read();
            if(data == -1) break;
            Book book = (Book) ois.readObject();
            bookList.put(book.getId(),book);
        }
        ois.close();
        is.close();
    }

    public Book Check(long id) {
       for (Book b : duplicationList){
           if(b.getId().equals(id))
               return b;
       } return null;
    }
}
