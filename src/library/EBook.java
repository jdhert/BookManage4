package library;

import java.time.LocalDate;
import java.util.Objects;

public class EBook extends Book{
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
        if (o instanceof EBook) {
            if(this.getName().equals(((EBook)o).getName()) && this.getAuthor().equals(((EBook) o).getAuthor())
                    && Objects.equals(this.getIsbn(), ((EBook) o).getIsbn()))
                return true;
            else return false;
        } else return false;
    }
    @Override
    public int hashCode() {
        //name과 score가 같으면 동일한 해쉬코드 리턴 받게해줌
        //return Objects.hash(name, score);
        return this.getName().hashCode() + this.getAuthor().hashCode() + this.getIsbn().hashCode() + 1;
        //상위에서 name과 score 같은 값이면 같은 해쉭밧을 그냥 리턴해버림
    }
}
