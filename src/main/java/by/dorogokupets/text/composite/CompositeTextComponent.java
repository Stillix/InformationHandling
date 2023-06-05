package by.dorogokupets.text.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextComponent  implements TextComponent {
    private TextType type;
    private List<TextComponent> children;

    public CompositeTextComponent(TextType type) {
        this.type = type;
        this.children = new ArrayList<>();
    }

    public void addChild(TextComponent component) {
        children.add(component);
    }

    public void removeChild(TextComponent component) {
        children.remove(component);
    }

    @Override
    public TextType getType() {
        return type;
    }

    public List<TextComponent> getChildren() {
        return children;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent child : children) {
            sb.append(child.getText());
        }
        return sb.toString();
    }

    @Override
    public int countLettersInWord() {
        int count = 0;
        for (TextComponent child : children) {
            count += child.countLettersInWord();
        }
        return count;
    }
}