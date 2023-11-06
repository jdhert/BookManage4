package library.Book;

import java.time.LocalDate;
import java.util.Objects;

public class EBook extends Book {
    private String fileSize;

    public EBook(Long id, String name, String author, Long isbn, LocalDate publishedDate, String fileSize) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setPublishedDate(publishedDate);
        this.fileSize = fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EBook eBook = (EBook) o;
        return Objects.equals(this.getName(), eBook.getName()) && Objects.equals(this.getAuthor(),
                eBook.getAuthor()) && Objects.equals(this.getIsbn(), eBook.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 25);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", '" + fileSize +
                '\'';
    }
}
