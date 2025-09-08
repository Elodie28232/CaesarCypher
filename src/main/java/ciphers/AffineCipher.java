package ciphers;

public class AffineCipher {
    // y = (a*x + b) mod 26
    public static String encrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int x = c - base;
                int enc = (a * x + b) % 26;
                result.append((char) (enc + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        int aInv = modInverse(a, 26); // multiplicative inverse
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int y = c - base;
                int dec = (aInv * (y - b + 26)) % 26;
                result.append((char) (dec + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static int modInverse(int a, int m) {
        for (int i = 1; i < m; i++) {
            if ((a * i) % m == 1) return i;
        }
        throw new IllegalArgumentException("No modular inverse");
    }
}
