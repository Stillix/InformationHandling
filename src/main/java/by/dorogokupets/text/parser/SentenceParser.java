package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.TextComposite;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractDataParser {
    static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private static final String WORD_SPLIT = "\\s+";

    @Override
    public TextComponent handleRequest(String text) {
        TextComposite sentenceComponent = new TextComposite(TextType.SENTENCE);
        AbstractDataParser wordParser = new WordParser();

        String[] words = text.trim().split(WORD_SPLIT);
        for (String word : words) {
            TextComponent wordComponent = wordParser.parse(word);
            if (!word.isEmpty()) {
                sentenceComponent.addComponent(wordComponent);
            } else {
                logger.log(Level.WARN, "The word is empty");
            }
        }
        return sentenceComponent;
    }
}


