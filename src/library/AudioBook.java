package library;

import java.time.LocalDate;
import java.util.Objects;

public class AudioBook extends Book{
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
        if(o instanceof AudioBook){
            if(this.getName().equals(((AudioBook)o).getName()) && this.getAuthor().equals(((AudioBook) o).getAuthor())
                    && Objects.equals(this.getIsbn(), ((AudioBook) o).getIsbn()))
                return true;
            else return false;
        } else return false;
    }
    @Override
    public int hashCode() {
        //name과 score가 같으면 동일한 해쉬코드 리턴 받게해줌
        //return Objects.hash(name, score);
        return this.getName().hashCode() + this.getAuthor().hashCode() + this.getIsbn().hashCode() + 2;
        //상위에서 name과 score 같은 값이면 같은 해쉭밧을 그냥 리턴해버림
    }
}
