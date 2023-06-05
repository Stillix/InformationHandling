package by.dorogokupets.text.main;


import by.dorogokupets.text.composite.CompositeTextComponent;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;
import by.dorogokupets.text.parser.*;
import by.dorogokupets.text.reader.TextReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "data_text/text.txt";
        TextReader textReader = new TextReader();
        try {
            String text = textReader.readFile(filePath);
            System.out.println("Original text:");
            System.out.println(text);

            TextParser paragraphParser = new ParagraphParser();
            TextParser sentenceParser = new SentenceParser();
            TextParser wordParser = new WordParser();
            TextParser letterParser = new LetterParser();

            paragraphParser.setNextParser(sentenceParser);
            sentenceParser.setNextParser(wordParser);
            wordParser.setNextParser(letterParser);

            TextComponent textComponent = paragraphParser.parse(text);
            System.out.println("\nParsed text:");
            System.out.println(textComponent.getText());

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}