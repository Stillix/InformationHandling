package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.TextComposite;
import by.dorogokupets.text.composite.TextLeaf;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;

public class LetterParser extends AbstractDataParser {

    @Override
    public TextComponent handleRequest(String text) {
        if (text.length() == 1) {
            char character = text.charAt(0);
            if (isSymbol(character)) {
                return new TextLeaf(TextType.SYMBOL, text);
            } else {
                return new TextLeaf(TextType.LETTER, text);
            }
        } else {
            return new TextComposite(TextType.LETTER);
        }
    }

    private boolean isSymbol(char character) {
        String punctuationRegex = "[.,\\-():\"!?]";
        return String.valueOf(character).matches(punctuationRegex);
    }
}
