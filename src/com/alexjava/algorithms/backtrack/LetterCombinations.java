package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();

        System.out.println(l.letterCombinations("23"));
    }

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    String[] map = {
            "",     "",     "abc", "def",
            "ghi",  "jkl",  "mno", "pqrs",
            "tuv",  "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        dfs(digits, 0);
        return res;
    }

    private void dfs(String digits, int index) {

        if(digits.length() == index){
            res.add(path.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c: letters.toCharArray()){

            path.append(c);

            dfs(digits, index + 1);

            path.deleteCharAt(path.length() -1);
        }



    }
}
