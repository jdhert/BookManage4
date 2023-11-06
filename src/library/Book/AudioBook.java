package library.Book;

import java.time.LocalDate;
import java.util.Objects;

public class AudioBook extends Book {
    private String fileSize;
    private String language;
    private int playTime;
    public AudioBook(Long id, String name, String author, Long isbn, LocalDate publishedDate, String fileSize,
                     String language, int playTime) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setPublishedDate(publishedDate);
        this.fileSize = fileSize;
        this.language = language;
        this.playTime = playTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getLanguage() {
        return language;
    }

    public int getPlayTime() {
        return playTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AudioBook audioBook = (AudioBook) o;
        return Objects.equals(this.getName(), audioBook.getName()) && Objects.equals(this.getAuthor(),
                audioBook.getAuthor()) && Objects.equals(this.getIsbn(), audioBook.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 49);
    }

    @Override
    public String toString() {
        return super.toString()+
                ", '" + fileSize + '\'' +
                ", '" + language + '\'' +
                ", '" + playTime +
                '\'';
    }
}
