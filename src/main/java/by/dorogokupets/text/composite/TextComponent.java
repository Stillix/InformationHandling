package by.dorogokupets.text.composite;


public interface TextComponent {
    TextType getType();

    String getText();

    int countLettersInWord();
}