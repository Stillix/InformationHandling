package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.Composite;
import by.dorogokupets.text.composite.Component;
import by.dorogokupets.text.composite.TextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends DataParser {
    static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private static final String WORD_SPLIT = "\\s+";

    @Override
    protected Component handleRequest(String text) {
        Composite sentenceComponent = new Composite(TextType.SENTENCE);
        DataParser wordParser = new WordParser();

        String[] words = text.trim().split(WORD_SPLIT);
        for (String word : words) {
            Component wordComponent = wordParser.parse(word);
            if (!word.isEmpty()) {
                sentenceComponent.addComponent(wordComponent);
            } else {
                logger.log(Level.WARN, "The word is empty");
            }
        }
        return sentenceComponent;
    }
}


