package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.Composite;
import by.dorogokupets.text.composite.Component;
import by.dorogokupets.text.composite.TextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractDataParser {
    static final Logger logger = LogManager.getLogger(ParagraphParser.class);
    private static final String SENTENCE_SPLIT = "(?<=[.!?\\.{3}])s";

    @Override
    protected Component handleRequest(String text) {
        Composite paragraphComponent = new Composite(TextType.PARAGRAPH);
        AbstractDataParser sentenceParser = new SentenceParser();
        String[] sentences = text.split(SENTENCE_SPLIT);
        for (String sentence : sentences) {
            sentence = sentence.trim();
            Component sentenceComponent = sentenceParser.parse(sentence);
            if (!sentence.isEmpty()) {
                paragraphComponent.addComponent(sentenceComponent);
            } else {
                logger.log(Level.WARN, "The sentence is empty");
            }
        }
        return paragraphComponent;
    }
}
