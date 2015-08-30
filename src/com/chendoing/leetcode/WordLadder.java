package com.chendoing.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenDoInG on 15/8/30.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (!wordDict.contains(endWord))
            return 0;
        Queue<String> paths2End = new LinkedList<>();
        Queue<String> paths2Begin = new LinkedList<>();
        paths2End.add(beginWord);
        paths2Begin.add(endWord);
        return bfs(paths2End, paths2Begin, wordDict, 1);
    }


    private int bfs(Queue<String> paths2End, Queue<String> paths2Begin, Set<String> wordDict, int level) {
        if (paths2End.isEmpty())
            return 0;
        if (paths2End.size() > paths2Begin.size())
            return bfs(paths2Begin, paths2End, wordDict, level);
        Queue<String> paths4NextLevel = new LinkedList<>();
        while (!paths2End.isEmpty()) {
            String path = paths2End.poll();
            wordDict.remove(path);
            if (paths2Begin.contains(path))
                return level;
            for (int i = 0; i < path.length(); i++) {
                char[] ch = path.toCharArray();
                for (char exchange = 'a'; exchange <= 'z'; exchange++) {
                    if (ch[i] != exchange) {
                        ch[i] = exchange;
                        String word = String.valueOf(ch);
                        if (wordDict.contains(word)) {
                            paths4NextLevel.add(word);
                        }
                    }
                }
            }
        }
        level++;
        return bfs(paths4NextLevel, paths2Begin, wordDict, level);
    }

    @Test
    public void ladderLength() {
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("cog");
        set.add("dog");
        set.add("tot");
        set.add("hog");
        set.add("hop");
        set.add("pot");
        set.add("dot");
        System.out.println(ladderLength("hot", "dog", set));
    }

}