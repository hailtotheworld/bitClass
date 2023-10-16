package hello.upload.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileStoreTest {

    @Test
    void lastIndexTest() {

        String fileName = "aa.abc.png";
        //aa.abc.png
        //0123456789
        //.lastIndexOf("찾을문자") 뒤에서부터찾는다. 앞에서부터01234로 센다.
        int pos = fileName.lastIndexOf(".");
        System.out.println("pos = " + pos);

        //.substring(이숫자부터끝까지잘라내)
        String ext = fileName.substring(pos + 1);
        System.out.println("ext = " + ext);


    }

}