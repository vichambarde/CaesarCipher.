import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt the message
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // Traverse the text
        for (char character : text.toCharArray()) {
            // Encrypt uppercase letters
            if (Character.isUpperCase(character)) {
                char encryptedChar = (char) ((character + shift - 'A') % 26 + 'A');
                result.append(encryptedChar);
            }
            // Encrypt lowercase letters
            else if (Character.isLowerCase(character)) {
                char encryptedChar = (char) ((character + shift - 'a') % 26 + 'a');
                result.append(encryptedChar);
            } else {
                // Non-alphabetic characters are added as is
                result.append(character);
            }
        }
        return result.toString();
    }

    // Method to decrypt the message
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));  // Decrypting by shifting in the opposite direction
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input message and shift value
        System.out.print("Enter a message: ");
        String inputText = scanner.nextLine();
        System.out.print("Enter shift value (1-25): ");
        int shift = scanner.nextInt() % 26; // Normalize shift value

        // Encrypt the message
        String encryptedText = encrypt(inputText, shift);
        System.out.println("Encrypted message: " + encryptedText);

        // Decrypt the message
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted message: " + decryptedText);

        scanner.close();
    }
} 