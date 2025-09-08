package ciphers;

import java.util.*;

public class PlayfairCipher {
    private char[][] table;

    public PlayfairCipher(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : key.toCharArray()) set.add(c);
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J') set.add(c);
        }

        table = new char[5][5];
        Iterator<Character> it = set.iterator();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                table[i][j] = it.next();
    }

    // Public API
    public static String encrypt(String text, String key) {
        return new PlayfairCipher(key).process(text, true);
    }

    public static String decrypt(String text, String key) {
        return new PlayfairCipher(key).process(text, false);
    }


    private String process(String text, boolean encrypt) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        if (text.length() % 2 != 0) text += "X";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = find(a);
            int[] posB = find(b);

            if (posA[0] == posB[0]) { // same row
                result.append(table[posA[0]][(posA[1] + (encrypt ? 1 : 4)) % 5]);
                result.append(table[posB[0]][(posB[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (posA[1] == posB[1]) { // same col
                result.append(table[(posA[0] + (encrypt ? 1 : 4)) % 5][posA[1]]);
                result.append(table[(posB[0] + (encrypt ? 1 : 4)) % 5][posB[1]]);
            } else { // rectangle
                result.append(table[posA[0]][posB[1]]);
                result.append(table[posB[0]][posA[1]]);
            }
        }
        return result.toString();
    }

    private int[] find(char c) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (table[i][j] == c) return new int[]{i, j};
        return null;
    }
}
