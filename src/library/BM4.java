package library;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BM4 extends BookManager{
    private static HashMap<Long, Book> bookList = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    @Override
    void init() {
        bookList.put(1L,new Book(1L, "돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331796"),
                LocalDate.parse("2020-06-15")));
        bookList.put(2L, new EBook(2L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20"),
                "300MB"));
        bookList.put(3L, new AudioBook(3L, "위기의 역사", "오건영", Long.parseLong("9791169850360"), LocalDate.parse("2023-07-19"),
                "562MB", "한국어", 120));
    }
    @Override
    void interactWithUser() {
        while (true) {
            System.out.println("■■■■■■ 도서 관리 프로그램 ■■■■■■");
            System.out.println("(1) 도서 조회");
            System.out.println("(2) 도서 등록");
            System.out.println("(3) 도서 수정");
            System.out.println("(4) 도서 삭제");
            System.out.println("(5) 도서 이름으로 검색");
            System.out.println("(6) 도서 출판일로 검색");
            System.out.println("(7) 도서 제목 사전순 정렬");
            System.out.println("(8) 도서 출판일 순으로 정렬");
            System.out.println("(q) 프로그램 종료");
            System.out.print("선택 >> ");
            String userInput = sc.nextLine();
            switch (userInput.toLowerCase()) {
                case "1":
                    // 조회
                    printAllBook();
                    break;
                case "2":
                    // 등록
                    addBook();
                    break;
                case "3":
                    // 수정
                    updateBook();
                    break;
                case "4":
                    // 삭제
                    removeBook();
                    break;
                case "q":
                    // 메소드를 종료
                    System.out.println("프로그램 종료!");
                    return;
                case"5":
                    printBookInName();
                    break;
                case "6":
                    printBookInTime();
                    break;
                case "7":
                    dictionaryPrint();
                    break;
                case"8":
                    dateByPrint();
                    break;
                default:
                    System.out.println("보기에 나와있는 것을 입력하세요!!! :( ");
                    break;
            }
        }
    }
    @Override
    public void printAllBook() {
        System.out.println("■■■■■■■■ 도서 목록 조회 ■■■■■■■■");
        String s = toString();
        bookList.toString();
//        for (Book book : bookList) {
//            System.out.print("[");
//            System.out.print(book.getId());
//            System.out.print(", ");
//            System.out.print(book.getName());
//            System.out.print(", ");
//            System.out.print(book.getAuthor());
//            System.out.print(", ");
//            System.out.print(book.getIsbn());
//            System.out.print(", ");
//            System.out.print(book.getPublishedDate());
//            if(book instanceof EBook) {
//                System.out.print(", ");
//                System.out.print(((EBook) book).getFileSize());
//                System.out.print("]");
//            } else if (book instanceof AudioBook) {
//                System.out.print(", ");
//                System.out.print(((AudioBook) book).getFileSize());
//                System.out.print(", ");
//                System.out.print(((AudioBook) book).getLanguage());
//                System.out.print(", ");
//                System.out.print(((AudioBook) book).getPlayTime());
//                System.out.print("]");
//            } else System.out.print("]");
//            System.out.println();
//        }
    }
    public void addBook() {
        System.out.println("■■■■■■■■■■■ 도서 등록 ■■■■■■■■■■■");
        int form = getInt("어떤 책을 등록하시겠습니까?(숫자입력) 1. Book 2. EBook 3. AudioBook >> ");
        if(form >= 4 || form <= 0) {
            System.out.println("잘못된 숫자 입력하였습니다!!! :( ");
            return;
        }
        long id = getLong("(1) 도서번호를 입력해주세요.(유일한 번호) >> ");
        if(Check(id) == null) {
            String file = "";
            String language = "";
            int time=0;
            System.out.print("(2) 도서명을 입력해주세요. >> ");
            String name = sc.nextLine();
            System.out.print("(3) 저자명을 입력해주세요. >> ");
            String author = sc.nextLine();
            long isbn = getLong("(4) isbn을 입력해주세요. >> ");
            LocalDate Date = getDate("(5) 출간일을 입력해주세요.(YYYY-MM-DD형식) >> ");
            if(form >= 2) {
                System.out.print("(6) 파일 사이즈를 입력해주세요. >> ");
                file = sc.nextLine();
                if(form >= 3) {
                    System.out.print("(7) 언어를 입력해주세요. >> ");
                    language = sc.nextLine();
                    time = getInt("(8) 오디오북 길이를 입력해주세요.(숫자) >> ");
                }
            }
            switch (form) {
                case 1:
                    Book book1 = new Book(id,
                            name,
                            author,
                            isbn,
                            Date);
//                    bookList.put(book1);
                    System.out.println("--- 도서 [" + book1.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                case 2:
                    Book book2 = new EBook(id,
                            name,
                            author,
                            isbn,
                            Date, file);
                    bookList.put(id,book2);
                    System.out.println("--- 도서 [" + book2.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                case 3:
                    Book book3 = new AudioBook(id,
                            name,
                            author,
                            isbn,
                            Date, file, language, time);
                    bookList.put(id, book3);
                    System.out.println("--- 도서 [" + book3.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                default:
                    break;
            }
        } else System.out.println("ID값이 이미 존재합니다. ");
    }
    @Override
    public void updateBook() {
        System.out.println("수정 메서드 실행");
        long id = getLong("수정하고자 하는 도서번호를 입력하세요 >> ");
        Book form = Check(id);
        int i=0;
        if (form != null) {
            String fileSize = "";
            String language = "";
            int time=0;
            System.out.println("[수정 정보를 입력해주세요]");
            System.out.print("제목 >> ");
            String name = sc.nextLine();
            System.out.print("저자 >> ");
            String author = sc.nextLine();
            long isbn = getLong("isbn >> ");
            LocalDate Date = getDate("출판일(YYYY-MM-DD) >> ");
            i++;
            if (form instanceof EBook) {
                System.out.print("파일사이즈 >> ");
                fileSize = sc.nextLine();
                i=2;
            }else if (form instanceof AudioBook) {
                System.out.print("파일사이즈 >> ");
                fileSize = sc.nextLine();
                System.out.print("언어 >> ");
                language = sc.nextLine();
                time = getInt("재생시간(숫자) >> ");
                i=3;
            }
            switch (i) {
                case 1:
                    form.setName(name);
                    form.setAuthor(author);
                    form.setIsbn(isbn);
                    form.setPublishedDate(Date);
                    break;
                case 2:
                    form.setName(name);
                    form.setAuthor(author);
                    form.setIsbn(isbn);
                    form.setPublishedDate(Date);
                    ((EBook) form).setFileSize(fileSize);
                    break;
                case 3:
                    form.setName(name);
                    form.setAuthor(author);
                    form.setIsbn(isbn);
                    form.setPublishedDate(Date);
                    ((AudioBook) form).setFileSize(fileSize);
                    ((AudioBook) form).setLanguage(language);
                    ((AudioBook) form).setPlayTime(time);
                    break;
                default:
                    break;

            }
            System.out.println("수정이 완료되었습니다.");
        }else System.out.println("해당 도서가 존재하지 않습니다!!! ");
    }
    public void removeBook() {
        System.out.println("■■■■■■■■■■■ 도서 삭제 ■■■■■■■■■■■");
        long id = getLong("삭제하고자 하는 도서의 도서번호를 입력하세요 >> ");
        Book check = Check(id);
        if(check != null) {
            bookList.remove(check);
            System.out.println("삭제가 완료되었습니다.");
        } else System.out.println("해당 도서가 존재하지 않습니다.");
    }
    public Book Check(long id) {
        for (Map.Entry<Long, Book> entry : bookList.entrySet()) {
            if (entry.getKey() == id) {
                return entry.getValue();
            }
        }
        return null;
//        bookList.forEach((key, book) -> {
//            if(key == id)
//                return book;
//        }); return null;
    }
    public static int getInt(String prompt) {
        try {
            System.out.print(prompt);
            String input = sc.nextLine();
            int value = Integer.parseInt(input);
            return value;
        } catch (Exception e) {
            System.out.println("잘못된 값을 입력하셨습니다. 정수형으로 다시 입력하세요 ㅠㅠ");
            return getInt(prompt);
        }
    }
    public static LocalDate getDate(String prompt){
        try{
            System.out.print(prompt);
            String publishDate = sc.nextLine();
            LocalDate Date = LocalDate.parse(publishDate);
            return Date;
        } catch (Exception e){
            System.out.println("잘못된 값을 입력하셨습니다. 날짜로 다시 입력하세요 ㅠㅠ");
            return  getDate(prompt);
        }
    }
    public static Long getLong(String prompt) {
        try {
            System.out.print(prompt);
            String input = sc.nextLine();
            long value = Long.parseLong(input);
            return value;
        } catch (Exception e) {
            System.out.println("잘못된 값을 입력하셨습니다. Long타입 정수로 다시 입력하세요 ㅠㅠ");
            return getLong(prompt);
        }
    }
    private boolean check1 = true;
    public void printBookInName(){
        System.out.print("도서 제목 입력 >> ");
        String bookName = (sc.nextLine()).toLowerCase();
        System.out.println("■■■■■■■■ 도서 제목으로 조회 ■■■■■■■■");
//        bookList.forEach((key, book) -> {
//                    if (book.getName().toLowerCase().contains(bookName)) {
//                        String s = toString();
//                        check1 = false;
//                    }
//                });
        bookList.forEach((key, b) -> {
            if(b.getName().toLowerCase().contains(bookName)){
                System.out.print("[");
                System.out.print(b.getId());
                System.out.print(", ");
                System.out.print(b.getName());
                System.out.print(", ");
                System.out.print(b.getAuthor());
                System.out.print(", ");
                System.out.print(b.getIsbn());
                System.out.print(", ");
                System.out.print(b.getPublishedDate());
                if(b instanceof EBook) {
                    System.out.print(", ");
                    System.out.print(((EBook) b).getFileSize());
                    System.out.println("]");
                    check1 = false;
                } else if (b instanceof AudioBook) {
                    System.out.print(", ");
                    System.out.print(((AudioBook) b).getFileSize());
                    System.out.print(", ");
                    System.out.print(((AudioBook) b).getLanguage());
                    System.out.print(", ");
                    System.out.print(((AudioBook) b).getPlayTime());
                    System.out.println("]");
                    check1 = false;
                } else {
                    System.out.println("]");
                    check1 = false;
                }
            }
        });
        if(check1)
            System.out.println("해당 도서는 존재하지 않습니다. ");

    }
    public void printBookInTime(){
        LocalDate bookTime1 = getDate("출간일 시작범위 입력 >> ");
        LocalDate bookTime2 = getDate("출간일 종료범위 입력 >> ");
        System.out.println("■■■■■■■■ 도서 출간일로 조회 ■■■■■■■■");
//        bookList.forEach((key, book) -> {
//            if (book.getPublishedDate().compareTo(bookTime1) >= 0 && book.getPublishedDate().compareTo(bookTime2) <= 0) {
//                String s = toString();
//                check1 = false;
//            }
//        });
        bookList.forEach((key, b) -> {
            if(b.getPublishedDate().compareTo(bookTime1) >= 0 && b.getPublishedDate().compareTo(bookTime2) <= 0){
                System.out.print("[");
                System.out.print(b.getId());
                System.out.print(", ");
                System.out.print(b.getName());
                System.out.print(", ");
                System.out.print(b.getAuthor());
                System.out.print(", ");
                System.out.print(b.getIsbn());
                System.out.print(", ");
                System.out.print(b.getPublishedDate());
                if(b instanceof EBook) {
                    System.out.print(", ");
                    System.out.print(((EBook) b).getFileSize());
                    System.out.println("]");
                    check1 = false;
                } else if (b instanceof AudioBook) {
                    System.out.print(", ");
                    System.out.print(((AudioBook) b).getFileSize());
                    System.out.print(", ");
                    System.out.print(((AudioBook) b).getLanguage());
                    System.out.print(", ");
                    System.out.print(((AudioBook) b).getPlayTime());
                    System.out.println("]");
                    check1 = false;

                } else {
                    System.out.println("]");
                    check1 = false;
                }
            }
        });
        if(check1)
            System.out.println("해당 도서는 존재하지 않습니다. ");
    }
    public void dictionaryPrint(){
        System.out.println("■■■■■■■■ 도서 사전순으로 정렬 ■■■■■■■■");
//        Collections.sort(bookList,new bookNameComparator());
        printAllBook();
    }
    public void dateByPrint(){
        System.out.println("■■■■■■■■ 도서 출판일 순으로 정렬 ■■■■■■■■");
//        Collections.sort(bookList, new bookDateComparator());
        printAllBook();
    }

    class bookNameComparator implements Comparator<Book>{
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
    class bookDateComparator implements  Comparator<Book>{
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPublishedDate().compareTo(o2.getPublishedDate());
        }
    }

    @Override
    public String toString() {
        bookList.forEach((key, book) -> {
            System.out.print("[");
            System.out.print(book.getId());
            System.out.print(", ");
            System.out.print(book.getName());
            System.out.print(", ");
            System.out.print(book.getAuthor());
            System.out.print(", ");
            System.out.print(book.getIsbn());
            System.out.print(", ");
            System.out.print(book.getPublishedDate());
            if(book instanceof EBook) {
                System.out.print(", ");
                System.out.print(((EBook) book).getFileSize());
                System.out.print("]");
            } else if (book instanceof AudioBook) {
                System.out.print(", ");
                System.out.print(((AudioBook) book).getFileSize());
                System.out.print(", ");
                System.out.print(((AudioBook) book).getLanguage());
                System.out.print(", ");
                System.out.print(((AudioBook) book).getPlayTime());
                System.out.print("]");
            } else System.out.print("]");
            System.out.println();
        });
        return super.toString();
    }

}
