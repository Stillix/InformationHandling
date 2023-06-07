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
//        TextReader textReader = new TextReader();
//        try {
//            String text = textReader.readFile(filePath);
//            System.out.println("Original text:");
//            System.out.println(text);
//
//            DataParser paragraphParser = new ParagraphParser();
//            DataParser sentenceParser = new SentenceParser();
//            DataParser wordParser = new WordParser();
//            DataParser letterParser = new LetterParser();
//
//            paragraphParser.setNextParser(sentenceParser);
//            sentenceParser.setNextParser(wordParser);
//            wordParser.setNextParser(letterParser);
//
//            Component component = paragraphParser.parse(text);
//            System.out.println("\nParsed text:");
//            System.out.println(component.getText());
//
//        } catch (IOException e) {
//            System.out.println("Error reading the file: " + e.getMessage());
//        }

        // Создание экземпляра парсера для каждого типа данных
        DataParser textParser = new TextParser();
        DataParser paragraphParser = new ParagraphParser();
        DataParser sentenceParser = new SentenceParser();
        DataParser wordParser = new WordParser();
        DataParser letterParser = new LetterParser();

        // Установка цепочки парсеров с использованием setNextParser
        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(wordParser);
        wordParser.setNextParser(letterParser);

        // Чтение файла
        TextReader textReader = new TextReader();
        String fileContent;
        try {
            fileContent = textReader.readFile(filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Парсинг текста
        Component textComponent = textParser.parse(fileContent);

        // Вывод всего текста
        System.out.println("Full Text:");
        System.out.println(textComponent.getText());

        // Вывод абзацев
        System.out.println("Paragraphs:");
        List<Component> paragraphs = ((Composite) textComponent).getComponents();
        for (Component paragraph : paragraphs) {
            System.out.println(paragraph.getText());
        }

        // Вывод предложений
        System.out.println("Sentences:");
        for (Component paragraph : paragraphs) {
            List<Component> sentences = ((Composite) paragraph).getComponents();
            for (Component sentence : sentences) {
                System.out.println(sentence.getText());
            }
        }

        // Вывод слов
        System.out.println("Words:");
        for (Component paragraph : paragraphs) {
            List<Component> sentences = ((Composite) paragraph).getComponents();
            for (Component sentence : sentences) {
                List<Component> words = ((Composite) sentence).getComponents();
                for (Component word : words) {
                    System.out.println(word.getText());
                }
            }
        }

        // Вывод букв
        System.out.println("Letters:");
        for (Component paragraph : paragraphs) {
            List<Component> sentences = ((Composite) paragraph).getComponents();
            for (Component sentence : sentences) {
                List<Component> words = ((Composite) sentence).getComponents();
                for (Component word : words) {
                    List<Component> letters = ((Composite) word).getComponents();
                    for (Component letter : letters) {
                        System.out.println(letter.getText());
                    }
                }
            }
        }
    }
}