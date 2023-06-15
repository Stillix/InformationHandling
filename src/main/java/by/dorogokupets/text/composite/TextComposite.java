package by.dorogokupets.text.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private TextType type;
    private List<TextComponent> components;

    public TextComposite(TextType type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    public void addComponent(TextComponent textComponent) {
        components.add(textComponent);
    }

    public void removeComponent(TextComponent textComponent) {
        components.remove(textComponent);
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
        for (TextComponent textComponent : components) {
            sb.append(textComponent.getText());
        }
        return sb.toString();
    }

    public int getSentenceCount() {
        int count = 0;

        return count;
    }

    public String getLongestWordSentence() {
        String longestWord = null;


        return longestWord;
    }

    private void formatComponent(TextComponent component, StringBuilder formattedText) {
        if (component.getClass() == TextComponent.class) {
            formattedText.append(component.getText());
        } else {
            for (TextComponent subComponent : component.getComponents()) {
                formatComponent(subComponent, formattedText);
                formattedText.append(" ");
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent component : components) {
            sb.append(component.toString()); // Рекурсивно вызываем toString() для каждого компонента
        }
        return sb.toString();
    }
}
