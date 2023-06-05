package by.dorogokupets.text.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    public String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }
}
