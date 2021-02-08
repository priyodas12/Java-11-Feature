package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        var path="C:\\Users\\Priyo\\OneDrive\\Desktop\\java11.txt";

        try {
            Files.writeString(Path.of(path),"\ntesting files data...writing", StandardOpenOption.APPEND);

            String data=Files.readString(Path.of(path));
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
