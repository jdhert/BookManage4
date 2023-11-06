package library;

import java.io.IOException;

public abstract class BookManager {
//    abstract void addBook(Book book);

    abstract void addBook() throws IOException;

    abstract void init() throws IOException, ClassNotFoundException;

    abstract void interactWithUser() throws IOException;

    abstract void printAllBook();
//    abstract void updateBook(Book book);

    abstract void updateBook() throws IOException;

    abstract void removeBook() throws IOException;
}
