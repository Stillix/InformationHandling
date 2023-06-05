package by.dorogokupets.text.composite;

public class LeafTextComponent implements TextComponent {
    private TextType type;
    private String text;

    public LeafTextComponent(TextType type, String text) {
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
    public int countLettersInWord() {
        return getText().length();
    }
}