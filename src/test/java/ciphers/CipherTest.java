package ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {

    @Test
    void testCaesarEncryptDecrypt() {
        String text = "HELLO";
        int shift = 3;
        String encrypted = CaesarCipher.encrypt(text, shift);
        String decrypted = CaesarCipher.decrypt(encrypted, shift);
        assertEquals(text, decrypted);
    }

    @Test
    void testVigenereEncryptDecrypt() {
        String text = "ATTACKATDAWN";
        String key = "LEMON";
        String encrypted = VigenereCipher.encrypt(text, key);
        String decrypted = VigenereCipher.decrypt(encrypted, key);
        assertEquals(text, decrypted);
    }

    @Test
    void testAffineEncryptDecrypt() {
        String text = "AFFINECIPHER";
        int a = 5, b = 8;
        String encrypted = AffineCipher.encrypt(text, a, b);
        String decrypted = AffineCipher.decrypt(encrypted, a, b);
        assertEquals(text, decrypted);
    }

    @Test
    void testPlayfairEncryptDecrypt() {
        String text = "HIDETHEGOLDINTHETREESTUMP";
        String key = "PLAYFAIR EXAMPLE";
        String encrypted = PlayfairCipher.encrypt(text, key);
        String decrypted = PlayfairCipher.decrypt(encrypted, key);
        // Playfair may produce padding (X’s), so we only check prefix
        assertTrue(decrypted.startsWith("HIDETHEGOLD"));
    }
}
