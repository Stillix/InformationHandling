package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.Composite;
import by.dorogokupets.text.composite.Leaf;
import by.dorogokupets.text.composite.Component;
import by.dorogokupets.text.composite.TextType;

public class LetterParser extends AbstractDataParser {
    @Override
    protected Component handleRequest(String text) {
        if (text.length() == 1) {
            return new Leaf(TextType.LETTER, text);
        } else {
            return new Composite(TextType.LETTER);
        }
    }
}
