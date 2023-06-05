package by.dorogokupets.text.parser;


import by.dorogokupets.text.composite.TextComponent;

public abstract class TextParser {

    private TextParser nextParser;

    public void setNextParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }

    public TextComponent parse(String text) {
        TextComponent component = handleRequest(text);
        if (component == null && nextParser != null) {
            return nextParser.parse(text);
        }
        return component;
    }

    protected abstract TextComponent handleRequest(String text);
}
