package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.Composite;
import by.dorogokupets.text.composite.Component;
import by.dorogokupets.text.composite.TextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends DataParser {
    static final Logger logger = LogManager.getLogger(WordParser.class);

    @Override
    protected Component handleRequest(String text) {
        Composite wordComponent = new Composite(TextType.WORD);
        DataParser letterParser = new LetterParser();

        for (char c : text.toCharArray()) {
            Component letterComponent = letterParser.parse(Character.toString(c));
            if (letterComponent != null) {
                wordComponent.addComponent(letterComponent);
            } else {
                logger.log(Level.WARN, "The letter is null");
            }
        }
        return wordComponent;
    }
}

