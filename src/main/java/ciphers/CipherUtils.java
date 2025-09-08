package ciphers;

import java.util.Base64;

public class CipherUtils {

    // Caesar + Base64 hybrid
    public static String caesarBase64Encrypt(String text, int shift) {
        String caesar = CaesarCipher.encrypt(text, shift);
        return Base64.getEncoder().encodeToString(caesar.getBytes());
    }

    public static String caesarBase64Decrypt(String text, int shift) {
        String decoded = new String(Base64.getDecoder().decode(text));
        return CaesarCipher.decrypt(decoded, shift);
    }

    // Chain example: Caesar -> Vigenere -> reverse
    public static String chainEncrypt(String text, int caesarShift, String vKey) {
        String step1 = CaesarCipher.encrypt(text, caesarShift);
        String step2 = VigenereCipher.encrypt(step1, vKey);
        return new StringBuilder(step2).reverse().toString();
    }

    public static String chainDecrypt(String text, int caesarShift, String vKey) {
        String step1 = new StringBuilder(text).reverse().toString();
        String step2 = VigenereCipher.decrypt(step1, vKey);
        return CaesarCipher.decrypt(step2, caesarShift);
    }
}
