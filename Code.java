import java.util.Scanner;

public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift % 26);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();

        System.out.print("Type 'E' to encrypt or 'D' to decrypt: ");
        char choice = scanner.next().toUpperCase().charAt(0);

        String result;
        if (choice == 'E') {
            result = encrypt(message, shift);
        } else if (choice == 'D') {
            result = decrypt(message, shift);
        } else {
            result = "Invalid choice.";
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
