package library;

import java.io.IOException;

public class Execute {
    static BookManager bm = new BM5();
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        bm.init();
        bm.interactWithUser();

    }
}
