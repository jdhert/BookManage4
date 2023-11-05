package library;

import java.time.LocalDate;
import java.util.*;

public class BM5 extends BookManager{
    private static BookRepository bookListTest = new ArrayListBM();
    private static Scanner sc = new Scanner(System.in);
    private static int form;
    @Override
    void init() {
        bookListTest.addBook(1L,new Book(1L, "돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331796"),
                LocalDate.parse("2020-06-15")), true);
        bookListTest.addBook(2L, new EBook(2L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20"),
                "300MB"), true);
        bookListTest.addBook(3L, new AudioBook(3L, "위기의 역사", "오건영", Long.parseLong("9791169850360"), LocalDate.parse("2023-07-19"),
                "562MB", "한국어", 120), true);
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
            System.out.println("(7) 도서 제목 사전순 조회");
            System.out.println("(8) 도서 출판일순 조회");
            System.out.println("(9) 중복 입력한 도서 조회");
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
                case "8":
                    dateByPrint();
                    break;
                case "9":
                    findDuplicationList();
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
        bookListTest.PrintBook();
    }
    public void addBook() {
        System.out.println("■■■■■■■■■■■ 도서 등록 ■■■■■■■■■■■");
        form = getInt("어떤 책을 등록하시겠습니까?(숫자입력) 1. Book 2. EBook 3. AudioBook >> ");
        if(form >= 4) {
            System.out.println("잘못된 숫자 입력하였습니다!!! :( ");
            return;
        }
        long id = getLong("(1) 도서번호를 입력해주세요.(유일한 번호) >> ");
        if (bookListTest.getBook(id) != null) {
            System.out.println("이미 동일한 도서 번호가 존재합니다.");
            return;
        }
        String fileSize = "";
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
            fileSize = sc.nextLine();
            if(form >= 3) {
                System.out.print("(7) 언어를 입력해주세요. >> ");
                language = sc.nextLine();
                time = getInt("(8) 오디오북 길이를 입력해주세요.(숫자) >> ");
            }
        }
        createBook(id,name, author, isbn,Date, fileSize, language, time, true);
        System.out.println("--- 도서 [" + name + "] 등록이 완료되었습니다. ---");
    }
    @Override
    public void updateBook() {
        System.out.println("수정 메서드 실행");
        long id = getLong("수정하고자 하는 도서번호를 입력하세요 >> ");
        if (bookListTest.getBook(id) != null) {
            String fileSize = "";
            String language = "";
            int time=0;
            form = 1;
            System.out.println("[수정 정보를 입력해주세요]");
            System.out.print("제목 >> ");
            String name = sc.nextLine();
            System.out.print("저자 >> ");
            String author = sc.nextLine();
            long isbn = getLong("isbn >> ");
            LocalDate Date = getDate("출판일(YYYY-MM-DD) >> ");
            if (bookListTest.getBook(id) instanceof EBook) {
                form = 2;
                System.out.print("파일사이즈 >> ");
                fileSize = sc.nextLine();
            }else if (bookListTest.getBook(id)instanceof AudioBook) {
                form = 3;
                System.out.print("파일사이즈 >> ");
                fileSize = sc.nextLine();
                System.out.print("언어 >> ");
                language = sc.nextLine();
                time = getInt("재생시간(숫자) >> ");
            }
            createBook(id,name, author, isbn,Date, fileSize, language, time, false);
            System.out.println("수정이 완료되었습니다.");
        }else System.out.println("해당 도서가 존재하지 않습니다!!! ");
    }
    public void removeBook() {
        System.out.println("■■■■■■■■■■■ 도서 삭제 ■■■■■■■■■■■");
        long id = getLong("삭제하고자 하는 도서의 도서번호를 입력하세요 >> ");
        bookListTest.removeBook(id);
    }
    public void createBook(Long id, String name, String author, Long isbn, LocalDate publishedDate, String fileSize,
                           String language, int playTime, boolean checko){
        Book b;
        switch (form){
            case 1:
                b = new Book(id, name, author, isbn, publishedDate);
                bookListTest.addBook(id, b, checko);
                break;
            case 2:
                b = new EBook(id, name, author, isbn, publishedDate, fileSize);
                bookListTest.addBook(id, b, checko);
                break;
            case 3:
                b = new AudioBook(id, name, author, isbn, publishedDate, fileSize, language, playTime);
                bookListTest.addBook(id, b, checko);
                break;
            default:
                break;
        }
    }
    public static int getInt(String prompt) {
        try {
            System.out.print(prompt);
            String input = sc.nextLine();
            int value = Integer.parseInt(input);
            if(value <= 0){
                System.out.println("양수값으로 입력 부탁드립니다!!!");
                return getInt(prompt);
            }
            return value;
        } catch (Exception e) {
            System.out.println("잘못된 값을 입력 하셨습니다. 정수로 다시 입력 하세요 ㅠㅠ");
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
            System.out.println("잘못된 값을 입력 하셨습니다. 날짜로 다시 입력 하세요 ㅠㅠ");
            return  getDate(prompt);
        }
    }
    public static Long getLong(String prompt) {
        try {
            System.out.print(prompt);
            String input = sc.nextLine();
            long value = Long.parseLong(input);
            if(value <= 0) {
                System.out.println("양수값으로 입력 부탁드립니다!!!");
                return getLong(prompt);
            }
            return value;
        } catch (Exception e) {
            System.out.println("잘못된 값을 입력 하셨습니다. 정수로 다시 입력 하세요 ㅠㅠ");
            return getLong(prompt);
        }
    }
    private static boolean checks = true;
    public void printBookInName(){
        System.out.print("도서 제목 입력 >> ");
        String bookName = (sc.nextLine()).toLowerCase();
        System.out.println("■■■■■■■■ 도서 제목으로 조회 ■■■■■■■■");
        List<Book> bookList1 = bookListTest.getBooks();
        for(Book b : bookList1){
            if(b.getName().toLowerCase().contains(bookName)){
                System.out.println(b);
                checks = false;
            }
        }
        if(checks)
            System.out.println("해당 도서는 존재 하지 않습니다. ");
    }
    public void printBookInTime(){
        LocalDate bookTime1 = getDate("출간일 시작범위 입력 >> ");
        LocalDate bookTime2 = getDate("출간일 종료범위 입력 >> ");
        System.out.println("■■■■■■■■ 도서 출간일로 조회 ■■■■■■■■");
        List<Book> bookList1 = bookListTest.getBooks();
        for(Book b : bookList1){
            if(!b.getPublishedDate().isBefore(bookTime1) && !b.getPublishedDate().isAfter(bookTime2)){
                System.out.println(b);
                checks = false;
            }
        }
        if(checks)
            System.out.println("해당 도서는 존재 하지 않습니다. ");
    }
    public void dictionaryPrint(){
        System.out.println("■■■■■■■■ 도서 사전 순으로 조회 ■■■■■■■■");
        List<Book> bookList1 = bookListTest.getBooks();
        bookList1.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        for (Book b: bookList1){
            System.out.println(b.toString());
        }
    }
    public void dateByPrint(){
        System.out.println("■■■■■■■■ 도서 출판일 순으로 조회 ■■■■■■■■");
        List<Book> bookList1 = bookListTest.getBooks();
        bookList1.sort(Comparator.comparing(Book::getPublishedDate));
        for (Book b: bookList1){
            System.out.println(b.toString());
        }
    }
    public void findDuplicationList(){
        System.out.println("■■■■■■■■ 중복 입력된 책들 조회 ■■■■■■■■");
        List<Book> origin = bookListTest.getDistinct();
        List<Book> findDup = bookListTest.getDup();
        for (Book b : origin){
            for(Book c : findDup){
                if(b.equals(c)) {
                    System.out.println(b);
                    System.out.println(c);
                    System.out.println();
                }
            }
        }
    }
}

