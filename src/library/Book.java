package library;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
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
            if (o instanceof Book) {
                if(this.name.equals(((Book)o).getName()) && this.author.equals(((Book) o).getAuthor())
                        && Objects.equals(this.getIsbn(), ((Book) o).getIsbn()))
                    return true;
                else return false;
            } else return false;
    }
//       if(o instanceof AudioBook){
//           if(this.name.equals(((AudioBook)o).getName()) && this.author.equals(((AudioBook) o).getAuthor())
//                   && Objects.equals(this.getIsbn(), ((AudioBook) o).getIsbn()))
//               return true;
//           else return false;
//       } else if (o instanceof EBook) {
//           if(this.name.equals(((EBook)o).getName()) && this.author.equals(((EBook) o).getAuthor())
//                   && Objects.equals(this.getIsbn(), ((EBook) o).getIsbn()))
//               return true;
//           else return false;
//       } else if (o instanceof Book) {
//           if(this.name.equals(((Book)o).getName()) && this.author.equals(((Book) o).getAuthor())
//                   && Objects.equals(this.getIsbn(), ((Book) o).getIsbn()))
//               return true;
//           else return false;
//       } else return false;

    @Override
    public int hashCode() {
        //name과 score가 같으면 동일한 해쉬코드 리턴 받게해줌
        //return Objects.hash(name, score);
        return this.name.hashCode() + this.author.hashCode() + this.isbn.hashCode();
        //상위에서 name과 score 같은 값이면 같은 해쉭밧을 그냥 리턴해버림
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, author, isbn);
//    }
}
