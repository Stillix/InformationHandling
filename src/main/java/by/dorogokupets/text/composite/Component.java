package by.dorogokupets.text.composite;


import java.util.List;

public interface Component {
    TextType getType();

    String getText();
    List<Component> getComponents();

    int countLettersInWord();

}