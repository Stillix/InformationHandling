package by.dorogokupets.text.service;

import java.util.List;
import java.util.Map;

public interface TextService {

    List<String> findSentencesWithLongestWord();

    void removeSentencesWithLessWords(int minWords);


    int countVowelsInSentence(String sentence);


    int countConsonantsInSentence(String sentence);

    int countSymbol(char character);
}
