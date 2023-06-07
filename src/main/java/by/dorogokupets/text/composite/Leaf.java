package by.dorogokupets.text.composite;

import java.util.List;

public class Leaf implements Component {
    private TextType type;
    private String text;

    public Leaf(TextType type, String text) {
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
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public int countLettersInWord() {
        return getText().length();
    }
}
