package by.dorogokupets.text.main;


import by.dorogokupets.text.composite.Component;
import by.dorogokupets.text.composite.Composite;
import by.dorogokupets.text.composite.TextType;
import by.dorogokupets.text.parser.*;
import by.dorogokupets.text.reader.TextReader;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String filePath = "data_text/text.txt";

        DataParser textParser = new TextParser();
        DataParser paragraphParser = new ParagraphParser();
        DataParser sentenceParser = new SentenceParser();
        DataParser wordParser = new WordParser();
        DataParser letterParser = new LetterParser();

        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(wordParser);
        wordParser.setNextParser(letterParser);

        TextReader textReader = new TextReader();
        String fileContent;
        try {
            fileContent = textReader.readFile(filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        Component textComponent = textParser.parse(fileContent);

        System.out.println("Full Text:");
        System.out.println(textComponent.getText());

        System.out.println("Paragraphs:");
        List<Component> paragraphs = textComponent.getComponents();
        for (Component paragraph : paragraphs) {
            System.out.println(paragraph.getText());
        }

        System.out.println("Sentences:");
        for (Component paragraph : paragraphs) {
            List<Component> sentences =  paragraph.getComponents();
            for (Component sentence : sentences) {
                System.out.println(sentence.getText());
            }
        }


        System.out.println("Words:");
        for (Component paragraph : paragraphs) {
            List<Component> sentences =  paragraph.getComponents();
            for (Component sentence : sentences) {
                List<Component> words = sentence.getComponents();
                for (Component word : words) {
                    System.out.println(word.getText());
                }
            }
        }

        // Вывод букв
        System.out.println("Letters:");
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                List<Component> words = sentence.getComponents();
                for (Component word : words) {
                    List<Component> letters = word.getComponents();
                    for (Component letter : letters) {
                        System.out.println(letter.getText());
                    }
                }
            }
        }
    }
}