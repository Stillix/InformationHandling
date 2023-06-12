package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextComposite;
import by.dorogokupets.text.composite.TextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextParser extends AbstractDataParser {
    static final Logger logger = LogManager.getLogger(TextParser.class);
    private static final String PARAGRAPH_SPLIT = "(\\t|\\s{4})";

    @Override
    public TextComponent handleRequest(String text) {
        TextComposite textComponent = new TextComposite(TextType.TEXT);
        AbstractDataParser paragraphParser = new ParagraphParser();
        String[] paragraphs = text.split(PARAGRAPH_SPLIT);
        for (String paragraph : paragraphs) {
            paragraph = paragraph.trim();
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            if (!paragraph.isEmpty()) {
                textComponent.addComponent(paragraphComponent);
            } else {
                logger.log(Level.WARN, "The paragraph is empty");
            }
        }
        return textComponent;
    }
}

