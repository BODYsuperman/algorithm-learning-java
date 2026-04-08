package com.alexjava.algorithms.hastable;

public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] record = new int[26];

        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
            if (record[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
