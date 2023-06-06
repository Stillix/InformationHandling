package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.CompositeTextComponent;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;

public class SentenceParser extends TextParser{
    @Override
    protected TextComponent handleRequest(String text) {
        CompositeTextComponent sentenceComponent = new CompositeTextComponent(TextType.SENTENCE);
        TextParser wordParser = new WordParser();

        String[] words = text.trim().split("\\s+");
        for (String word : words) {
            TextComponent wordComponent = wordParser.parse(word);
            if (wordComponent != null) {
                sentenceComponent.addChild(wordComponent);
            }
        }

        if (!sentenceComponent.getComponents().isEmpty()) {
            return sentenceComponent;
        } else {
            return null;
        }
    }
}
