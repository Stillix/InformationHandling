package by.dorogokupets.text.composite;


import java.util.List;

public interface TextComponent {
    TextType getType();

    String getText();

    List<TextComponent> getComponents();

}
