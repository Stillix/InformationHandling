package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.CompositeTextComponent;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;

public class WordParser extends TextParser{
    @Override
    protected TextComponent handleRequest(String text) {
        CompositeTextComponent wordComponent = new CompositeTextComponent(TextType.WORD);
        TextParser letterParser = new LetterParser();

        for (char c : text.toCharArray()) {
            TextComponent letterComponent = letterParser.parse(Character.toString(c));
            if (letterComponent != null) {
                wordComponent.addChild(letterComponent);
            }
        }

        if (!wordComponent.getComponents().isEmpty()) {
            return wordComponent;
        } else {
            return null;
        }
    }
}
