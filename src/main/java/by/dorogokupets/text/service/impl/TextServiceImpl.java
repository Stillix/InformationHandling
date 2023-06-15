package by.dorogokupets.text.service.impl;

import by.dorogokupets.text.composite.TextComponent;
import by.dorogokupets.text.service.TextService;

import java.util.*;

public class TextServiceImpl implements TextService {
    private TextComponent textComponent;

    public TextServiceImpl(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public List<String> findSentencesWithLongestWord() {
        List<String> sentences = new ArrayList<>();
        int maxLength = 0;

        List<TextComponent> paragraphs = textComponent.getComponents();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentencesInParagraph = paragraph.getComponents();
            for (TextComponent sentence : sentencesInParagraph) {
                List<TextComponent> wordsInSentence = sentence.getComponents();
                for (TextComponent word : wordsInSentence) {
                    String wordText = word.getText();
                    int wordLength = wordText.length();
                    if (wordLength > maxLength) {
                        maxLength = wordLength;
                        sentences.clear();
                        sentences.add(sentence.getText());
                    } else if (wordLength == maxLength) {
                        sentences.add(sentence.getText());
                    }
                }
            }
        }

        return sentences;
    }

    @Override
    public void removeSentencesWithLessWords(int minWords) {
        List<TextComponent> paragraphs = textComponent.getComponents();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentencesInParagraph = paragraph.getComponents();
            List<TextComponent> sentencesToRemove = new ArrayList<>();
            for (TextComponent sentence : sentencesInParagraph) {
                if (sentence.getComponents().size() < minWords) {
                    sentencesToRemove.add(sentence);
                }
            }
            sentencesInParagraph.removeAll(sentencesToRemove);
        }
    }


    @Override
    public int countVowelsInSentence(String sentence) {
        int vowelCount = 0;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        for (int i = 0; i < sentence.length(); i++) {
            char letter = Character.toLowerCase(sentence.charAt(i));
            if (vowels.contains(letter)) {
                vowelCount++;
            }
        }

        return vowelCount;
    }


    @Override
    public int countConsonantsInSentence(String sentence) {
        int consonantCount = 0;
        List<Character> consonants = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');

        for (int i = 0; i < sentence.length(); i++) {
            char letter = Character.toLowerCase(sentence.charAt(i));
            if (consonants.contains(letter)) {
                consonantCount++;
            }
        }

        return consonantCount;
    }


    @Override
    public int countSymbol(char character) {
        int count = 0;
        String text = textComponent.getText();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "TextServiceImpl{" +
               textComponent +
                '}';
    }
}
