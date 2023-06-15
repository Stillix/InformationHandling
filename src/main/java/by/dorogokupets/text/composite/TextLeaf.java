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
    public String toString() {
        return text;
    }
}
