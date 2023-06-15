package by.dorogokupets.text.main;


import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.exception.TextException;
import by.dorogokupets.text.parser.*;
import by.dorogokupets.text.reader.TextReader;
import by.dorogokupets.text.reader.impl.TextReaderImpl;
import by.dorogokupets.text.service.TextService;
import by.dorogokupets.text.service.impl.TextServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Main {
    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        TextReader reader = new TextReaderImpl();
        String text = null;
        try {
            text = reader.readFile("data_text/text.txt");
        } catch (TextException e) {
            e.printStackTrace();
        }


        ChainConfigurator chainConfigurator = new ChainConfigurator();
        AbstractDataParser parser = chainConfigurator.configureParserChain();
        TextComponent textComponent = parser.parse(text);
        TextService textService = new TextServiceImpl(textComponent);

        List<String> sentencesWithLongestWord = textService.findSentencesWithLongestWord();
        logger.log(Level.INFO, "Sentences with longest word");
        for (String sentence : sentencesWithLongestWord) {
            System.out.println(sentence);
        }

        List<TextComponent> paragraphs = textComponent.getComponents();
        int vowelCount = 0;
        int consonantCount = 0;
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentencesInParagraph = paragraph.getComponents();
            for (TextComponent sentence : sentencesInParagraph) {
                String sentenceText = sentence.getText();
                vowelCount += textService.countVowelsInSentence(sentenceText);
                consonantCount += textService.countConsonantsInSentence(sentenceText);
            }
        }
        logger.log(Level.INFO, "Vowel count in the text: " + vowelCount);
        logger.log(Level.INFO, "Consonant count in the text: " + consonantCount);
    }
}
