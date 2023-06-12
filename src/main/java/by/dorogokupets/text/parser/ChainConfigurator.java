package by.dorogokupets.text.parser;

public class ChainConfigurator {
    public  AbstractDataParser configureParserChain() {
        AbstractDataParser textParser = new TextParser();
        AbstractDataParser paragraphParser = new ParagraphParser();
        AbstractDataParser sentenceParser = new SentenceParser();
        AbstractDataParser wordParser = new WordParser();
        AbstractDataParser letterParser = new LetterParser();

        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(wordParser);
        wordParser.setNextParser(letterParser);

        return textParser;
    }
}
