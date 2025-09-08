# 🔐 Cipher Toolkit (Java)

A Java-based toolkit that implements classical cryptographic ciphers with encryption, decryption, brute-force cracking, and frequency analysis.  
Includes both **command-line tools** and a **GUI application**.

---

## Features
- **Caesar Cipher** (encrypt, decrypt, brute force, frequency analysis)
- **Vigenère Cipher** (poly-alphabetic)
- **Playfair Cipher** (5x5 digraph substitution)
- **Affine Cipher**
- **Hybrid Cipher** (Caesar + Base64)
- **Brute-force decryption** for Caesar (cryptanalysis basics)
- **Frequency analysis** to help guess keys automatically
- **JUnit tests** for reliability
- **Swing GUI** for interactive use

# 🔐 Cipher Toolkit (Java)

A Java-based toolkit that implements classical cryptographic ciphers with encryption, decryption, brute-force cracking, and frequency analysis.  
Includes both **command-line tools** and a **GUI application**.

---

## Features
- **Caesar Cipher** (encrypt, decrypt, brute force, frequency analysis)
- **Vigenère Cipher** (poly-alphabetic)
- **Playfair Cipher** (5x5 digraph substitution)
- **Affine Cipher**
- **Hybrid Cipher** (Caesar + Base64)
- **Brute-force decryption** for Caesar (cryptanalysis basics)
- **Frequency analysis** to help guess keys automatically
- **JUnit tests** for reliability
- **Swing GUI** for interactive use

---

## TODO

### GUI Improvements
- [ ] Add dynamic cipher selection: show/hide relevant key fields depending on the cipher.
- [ ] Add tooltips explaining each cipher and key format.
- [ ] Add letter frequency histogram or chart visualization for frequency analysis.
- [ ] Allow drag-and-drop file encryption/decryption.
- [ ] Add dark/light theme toggle.

### More Classical Ciphers
- [ ] Columnar transposition cipher.
- [ ] Hill cipher (matrix-based).
- [ ] Substitution cipher with customizable alphabet.

### Auto-Decryption Enhancements
- [ ] Extend frequency analysis to Vigenère (Kasiski test, Friedman test).
- [ ] Automatic key length detection for polyalphabetic ciphers.
- [ ] Combine brute force + scoring to suggest the most probable plaintext.

### Hybrid & Chaining Enhancements
- [ ] Allow multiple ciphers to be chained dynamically (e.g., Caesar → Vigenère → Playfair).
- [ ] Include Base64/Hex encoding options for output.
- [ ] Implement customizable pipelines via GUI.

### Testing & CI/CD
- [ ] Add more JUnit tests covering edge cases (empty strings, punctuation, long texts).
- [ ] Integrate GitHub Actions to run tests on every push.
- [ ] Add code coverage report.

### Documentation & Examples
- [ ] Add step-by-step examples in the README.
- [ ] Include screenshots for GUI and CLI outputs.
- [ ] Create a video demo or GIF of the GUI usage.

### File Handling
- [ ] Support batch encryption/decryption of multiple files.
- [ ] Save history of encrypt/decrypt operations.

### Security & Usability
- [ ] Warn users when key input is invalid (e.g., `a` not coprime with 26 for Affine).
- [ ] Prevent GUI crashes for incorrect input (non-numeric shift, empty key, etc.).
- [ ] Optionally, implement undo/redo functionality in GUI.

