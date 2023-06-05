package by.dorogokupets.text.parser;

import by.dorogokupets.text.composite.LeafTextComponent;
import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.composite.TextType;

public class LetterParser extends TextParser {
    @Override
    protected TextComponent handleRequest(String text) {
        if (text.length() == 1) {
            return new LeafTextComponent(TextType.LETTER, text);
        } else {
            return null;
        }
    }
}