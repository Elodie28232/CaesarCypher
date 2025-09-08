package ui;

import ciphers.*;
import javax.swing.*;
import java.awt.*;
import java.util.Base64;

public class CipherGUI extends JFrame {

    private JTextArea inputArea, outputArea;
    private JTextField keyField;
    private JComboBox<String> cipherBox, modeBox;
    private JButton runButton;

    public CipherGUI() {
        setTitle("Cipher Toolkit");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Input/output areas
        inputArea = new JTextArea(5, 50);
        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);

        // Cipher selection
        cipherBox = new JComboBox<>(new String[]{
                "Caesar", "Vigenere", "Affine", "Playfair", "Hybrid (Caesar+Base64)"
        });

        modeBox = new JComboBox<>(new String[]{"Encrypt", "Decrypt"});
        keyField = new JTextField(20);
        runButton = new JButton("Run");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Cipher:"));
        topPanel.add(cipherBox);
        topPanel.add(new JLabel("Mode:"));
        topPanel.add(modeBox);
        topPanel.add(new JLabel("Key:"));
        topPanel.add(keyField);
        topPanel.add(runButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(inputArea), BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Action
        runButton.addActionListener(e -> runCipher());
    }

    private void runCipher() {
        String cipher = (String) cipherBox.getSelectedItem();
        String mode = (String) modeBox.getSelectedItem();
        String key = keyField.getText().trim();
        String input = inputArea.getText().trim();
        String result = "";

        try {
            switch (cipher) {
                case "Caesar":
                    int shift = Integer.parseInt(key);
                    result = mode.equals("Encrypt")
                            ? CaesarCipher.encrypt(input, shift)
                            : CaesarCipher.decrypt(input, shift);
                    break;

                case "Vigenere":
                    result = mode.equals("Encrypt")
                            ? VigenereCipher.encrypt(input, key)
                            : VigenereCipher.decrypt(input, key);
                    break;

                case "Affine":
                    String[] parts = key.split(",");
                    int a = Integer.parseInt(parts[0].trim());
                    int b = Integer.parseInt(parts[1].trim());
                    result = mode.equals("Encrypt")
                            ? AffineCipher.encrypt(input, a, b)
                            : AffineCipher.decrypt(input, a, b);
                    break;

                case "Playfair":
                    result = mode.equals("Encrypt")
                            ? PlayfairCipher.encrypt(input, key)
                            : PlayfairCipher.decrypt(input, key);
                    break;

                case "Hybrid (Caesar+Base64)":
                    if (mode.equals("Encrypt")) {
                        result = CaesarCipher.encrypt(input, Integer.parseInt(key));
                        result = Base64.getEncoder().encodeToString(result.getBytes());
                    } else {
                        byte[] decoded = Base64.getDecoder().decode(input);
                        result = new String(decoded);
                        result = CaesarCipher.decrypt(result, Integer.parseInt(key));
                    }
                    break;
            }
        } catch (Exception ex) {
            result = "Error: " + ex.getMessage();
        }

        outputArea.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CipherGUI().setVisible(true));
    }
}
