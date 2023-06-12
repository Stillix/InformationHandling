package by.dorogokupets.text.parser;


import by.dorogokupets.text.composite.TextComponent;

public abstract class AbstractDataParser {

    private AbstractDataParser nextParser;

    public void setNextParser(AbstractDataParser nextParser) {
        this.nextParser = nextParser;
    }

    public TextComponent parse(String text) {
        TextComponent textComponent = handleRequest(text);
        if (textComponent == null && nextParser != null) {
            return nextParser.parse(text);
        }
        return textComponent;
    }

    public abstract TextComponent handleRequest(String text);
}
