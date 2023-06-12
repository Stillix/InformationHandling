package by.dorogokupets.text.main;


import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.exception.TextException;
import by.dorogokupets.text.parser.*;
import by.dorogokupets.text.reader.TextReader;
import by.dorogokupets.text.reader.impl.TextReaderImpl;

public class Main {
    public static void main(String[] args) {

        ChainConfigurator chainConfigurator = new ChainConfigurator();
        AbstractDataParser parser = chainConfigurator.configureParserChain();

        TextReader reader = new TextReaderImpl();
        String text = null;
        try {
            text = reader.readFile("data_text/text.txt");
        } catch (TextException e) {
            System.out.println("Failed to read the file: " + e.getMessage());
            return;
        }
        System.out.println(text);


        TextComponent textComponent = parser.parse(text);
        System.out.println(textComponent);

    }

}
