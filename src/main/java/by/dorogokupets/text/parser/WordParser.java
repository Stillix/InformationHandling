package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.TextComposite;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractDataParser {
    static final Logger logger = LogManager.getLogger(WordParser.class);

    @Override
    public TextComponent handleRequest(String text) {
        TextComposite wordComponent = new TextComposite(TextType.WORD);
        AbstractDataParser letterParser = new LetterParser();

        for (char c : text.toCharArray()) {
            TextComponent letterComponent = letterParser.parse(Character.toString(c));
            if (letterComponent != null) {
                wordComponent.addComponent(letterComponent);
            } else {
                logger.log(Level.WARN, "The letter is null");
            }
        }
        return wordComponent;
    }
}

