package by.dorogokupets.text.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextLeaf implements TextComponent {
    private TextType type;
    private String text;

    public TextLeaf(TextType type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public TextType getType() {
        return type;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<TextComponent> getComponents() {
        return Collections.emptyList();
    }

    @Override
    public List<String> findSentencesWithLongestWord() {
        List<String> sentences = new ArrayList<>();
        String[] words = getText().split("\\s+");

        int maxLength = 0;
        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                sentences.clear();
                sentences.add(getText());
            } else if (length == maxLength) {
                sentences.add(getText());
            }
        }

        return sentences;
    }

    @Override
    public int countSymbols() {
        int count = 0;

        if (getType() == TextType.SYMBOL) {
            count = 1;
        }

        return count;
    }

    @Override
    public String toString() {
        return text;
    }
}
