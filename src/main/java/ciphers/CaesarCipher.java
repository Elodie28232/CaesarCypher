package ciphers;

import java.util.*;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char shifted = (char) ((c - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    // Brute force
    public static void bruteForce(String text) {
        for (int i = 1; i < 26; i++) {
            System.out.printf("Shift %2d: %s%n", i, decrypt(text, i));
        }
    }

    // Auto-decrypt with frequency analysis
    public static String autoDecrypt(String text) {
        int bestShift = 0;
        double bestScore = Double.NEGATIVE_INFINITY;
        String bestCandidate = text;

        for (int shift = 1; shift < 26; shift++) {
            String candidate = decrypt(text, shift);
            double score = scoreEnglish(candidate);
            if (score > bestScore) {
                bestScore = score;
                bestShift = shift;
                bestCandidate = candidate;
            }
        }
        System.out.println("Best guess shift = " + bestShift);
        return bestCandidate;
    }

    // Very simple scoring based on letter frequencies
    private static double scoreEnglish(String text) {
        String letters = text.toUpperCase();
        int count = 0;
        for (char c : letters.toCharArray()) {
            if ("ETAOIN SHRDLU".indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }
}
