import ciphers.*;
import java.util.*;

public class CryptoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Cipher: (1) Caesar (2) Vigenere (3) Affine (4) Playfair (5) Hybrid");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Encrypt (E) / Decrypt (D) / Auto (A): ");
                String mode = sc.nextLine().toUpperCase();
                if (mode.equals("A")) {
                    System.out.println("Auto-decrypt guess: " + CaesarCipher.autoDecrypt(text));
                } else {
                    System.out.print("Shift: ");
                    int shift = sc.nextInt();
                    if (mode.equals("E"))
                        System.out.println(CaesarCipher.encrypt(text, shift));
                    else
                        System.out.println(CaesarCipher.decrypt(text, shift));
                }
                break;

            case 2:
                System.out.print("Key: ");
                String vKey = sc.nextLine();
                System.out.println("Encrypt (E) / Decrypt (D): ");
                String vMode = sc.nextLine().toUpperCase();
                if (vMode.equals("E"))
                    System.out.println(VigenereCipher.encrypt(text, vKey));
                else
                    System.out.println(VigenereCipher.decrypt(text, vKey));
                break;

            case 3:
                System.out.print("Enter a (coprime with 26): ");
                int a = sc.nextInt();
                System.out.print("Enter b: ");
                int b = sc.nextInt();
                System.out.println("Encrypt (E) / Decrypt (D): ");
                sc.nextLine();
                String affMode = sc.nextLine().toUpperCase();
                if (affMode.equals("E"))
                    System.out.println(AffineCipher.encrypt(text, a, b));
                else
                    System.out.println(AffineCipher.decrypt(text, a, b));
                break;

            case 4:
                System.out.print("Enter Playfair key: ");
                String pfKey = sc.nextLine();
                PlayfairCipher pf = new PlayfairCipher(pfKey);
                System.out.println("Encrypt (E) / Decrypt (D): ");
                String pfMode = sc.nextLine().toUpperCase();
                if (pfMode.equals("E"))
                    System.out.println(PlayfairCipher.encrypt(text, pfKey));
                else
                    System.out.println(PlayfairCipher.decrypt(text, pfKey));
                break;

            case 5:
                System.out.print("Enter Caesar shift: ");
                int cs = sc.nextInt(); sc.nextLine();
                System.out.print("Enter Vigenere key: ");
                String vk = sc.nextLine();
                System.out.println("Encrypt (E) / Decrypt (D): ");
                String hyMode = sc.nextLine().toUpperCase();
                if (hyMode.equals("E"))
                    System.out.println(CipherUtils.chainEncrypt(text, cs, vk));
                else
                    System.out.println(CipherUtils.chainDecrypt(text, cs, vk));
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
