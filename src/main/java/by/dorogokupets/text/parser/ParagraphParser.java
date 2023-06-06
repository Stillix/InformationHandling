package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.CompositeTextComponent;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;

public class ParagraphParser extends TextParser{
    @Override
    protected TextComponent handleRequest(String text) {
        CompositeTextComponent paragraphComponent = new CompositeTextComponent(TextType.PARAGRAPH);
        TextParser sentenceParser = new SentenceParser();

        String[] sentences = text.split("[.!?]");
        for (String sentence : sentences) {
            TextComponent sentenceComponent = sentenceParser.parse(sentence);
            if (sentenceComponent != null) {
                paragraphComponent.addChild(sentenceComponent);
            }
        }

        if (!paragraphComponent.getComponents().isEmpty()) {
            return paragraphComponent;
        } else {
            return null;
        }
    }
}
