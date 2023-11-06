package library.BM;

import java.io.IOException;

public abstract class BookManager {
    abstract void addBook() throws IOException;

    public abstract void init() throws IOException, ClassNotFoundException;

    public abstract void interactWithUser() throws IOException, ClassNotFoundException;

    abstract void printAllBook();

    abstract void updateBook() throws IOException;

    abstract void removeBook() throws IOException;
}
