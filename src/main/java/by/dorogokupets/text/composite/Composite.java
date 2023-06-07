package by.dorogokupets.text.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private TextType type;
    private List<Component> components;

    public Composite(TextType type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public TextType getType() {
        return type;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            sb.append(component.getText());
        }
        return sb.toString();
    }

    @Override
    public int countLettersInWord() {
        int count = 0;
        for (Component child : components) {
            count += child.countLettersInWord();
        }
        return count;
    }
}
