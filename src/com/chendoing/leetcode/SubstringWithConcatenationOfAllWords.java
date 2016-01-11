package com.chendoing.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * You are given a string, s, and a list of words, words,that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {

    private void addWord(String w, HashMap<String, Integer> words) {
        if (words.containsKey(w)) {
            words.put(w, words.get(w) + 1);
        } else {
            words.put(w, 1);
        }
    }

    private void removeWord(String w, HashMap<String, Integer> words) {
        if (!words.containsKey(w)) return;
        if (words.get(w) > 1) {
            words.put(w, words.get(w) - 1);
        } else {
            words.remove(w);
        }
    }

    /**
     * the explain see my blog:
     * http://chendoing.com/algorithm,java/2016/01/09/substring-with-concatenation-of-all-words/
     *
     * @param s     giving string
     * @param words lists of words
     * @return all starting indices of substring
     */
    public ArrayList<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> indices = new ArrayList<>();
        int total, wordLen;
        if ((total = words.length) == 0 || (wordLen = words[0].length()) == 0 || s.length() < wordLen) return indices;

        // store the words and frequencies in a hash table
        HashMap<String, Integer> expectWords = new HashMap<>();
        for (String w : words) {
            addWord(w, expectWords);
        }

        HashMap<String, Integer> check = new HashMap<>();

        // find concatenations
        for (int i = 0; i < wordLen; i++) {
            // check if there are any concatenations
            check.clear();
            int begin = i, cursor = i;
            while (begin <= s.length() - total * wordLen) {
                String sub = s.substring(cursor, cursor + wordLen);
                if (!expectWords.containsKey(sub)) {
                    begin = cursor + wordLen;
                    cursor = begin;
                    check.clear();
                } else if (Objects.equals(check.get(sub), expectWords.get(sub))) {
                    // if duplicate, forward begin
                    removeWord(s.substring(begin, begin + wordLen), check);
                    begin += wordLen;
                } else {
                    addWord(sub, check);
                    cursor += wordLen;
                    if (cursor - begin == total * wordLen) {
                        indices.add(begin);
                        begin += wordLen;
                        cursor = begin;
                        check.clear();
                    }
                }
            }
        }

        return indices;
    }

    @Test
    public void findSubstring() {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }
}
