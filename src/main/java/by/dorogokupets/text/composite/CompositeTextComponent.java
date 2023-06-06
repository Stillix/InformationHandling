package by.dorogokupets.text.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextComponent  implements TextComponent {
    private TextType type;
    private List<TextComponent> components;

    public CompositeTextComponent(TextType type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    public void addChild(TextComponent component) {
        components.add(component);
    }

    public void removeChild(TextComponent component) {
        components.remove(component);
    }

    @Override
    public TextType getType() {
        return type;
    }

    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent child : components) {
            sb.append(child.getText());
        }
        return sb.toString();
    }

    @Override
    public int countLettersInWord() {
        int count = 0;
        for (TextComponent child : components) {
            count += child.countLettersInWord();
        }
        return count;
    }
}