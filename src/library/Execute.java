package library;

import library.BM.BM6;
import library.BM.BookManager;

import java.io.IOException;

public class Execute {
    static BookManager bm = new BM6();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        bm.init();
        bm.interactWithUser();

    }
}
