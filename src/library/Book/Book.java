package library.Book;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Book implements Serializable {
    private Long id;
    private String name;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;

    public Book(Long id, String name, String author, Long isbn, LocalDate publishedDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(this.name, book.name) && Objects.equals(this.author, book.author) && Objects.equals(this.isbn, book.isbn);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.author, this.isbn);
    }

    @Override
    public String toString() {
        return  id +
                ", '" + name + '\'' +
                ", '" + author + '\'' +
                ", '" + isbn + '\'' +
                ", '" + publishedDate +
                '\'';
    }
    public int compareBookName(Book o1) {
        return this.getName().compareToIgnoreCase(o1.getName());
    }
    public int compareBookDate(Book o1){
        return this.getPublishedDate().compareTo(o1.getPublishedDate());
    }

}
