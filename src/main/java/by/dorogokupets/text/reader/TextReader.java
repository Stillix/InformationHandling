package by.dorogokupets.text.reader;

import by.dorogokupets.text.exception.TextException;

import java.io.IOException;

public interface TextReader {
    String readFile(String filePath) throws TextException;
}
