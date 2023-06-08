package by.dorogokupets.text.parser;


import by.dorogokupets.text.composite.Component;

public abstract class AbstractDataParser {

    private AbstractDataParser nextParser;

    public void setNextParser(AbstractDataParser nextParser) {
        this.nextParser = nextParser;
    }

    public Component parse(String text) {
        Component component = handleRequest(text);
        if (component == null && nextParser != null) {
            return nextParser.parse(text);
        }
        return component;
    }

    protected abstract Component handleRequest(String text);
}
