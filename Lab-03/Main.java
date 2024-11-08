import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            EncryptionService encryptionService = new EncryptionService();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose encryption method: 1) AES 2) DES 3) Caesar Cipher");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    encryptionService.setEncryptionStrategy(new AESEncryptionStrategy());
                    break;
                case 2:
                    encryptionService.setEncryptionStrategy(new DESEncryptionStrategy());
                    break;
                case 3:
                    System.out.println("Enter the shift value for Caesar Cipher:");
                    int shift = scanner.nextInt();
                    encryptionService.setEncryptionStrategy(new CaesarCipherStrategy(shift));
                    break;
                default:
                    System.out.println("Invalid option. Exiting.");
                    return;
            }

            String inputFilePath = "G:/My Drive/3-1/SWE 4502/Lab-03/text.txt";

            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line).append(System.lineSeparator());
                }
            }

            String content = contentBuilder.toString();

            String encryptedContent = encryptionService.encrypt(content);

            String encryptedFilePath = "G:/My Drive/3-1/SWE 4502/Lab-03/encrypted.txt";

            File encryptedFile = new File(encryptedFilePath);
            if (encryptedFile.exists() && encryptedFile.isFile()) {
                // Write encrypted content to the specified file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFile))) {
                    writer.write(encryptedContent);
                    System.out.println("Encrypted content successfully written to file: " + encryptedFilePath);
                }
            } else {
                System.out.println("The specified file does not exist or is not valid.");
                return;
            }

            // Ask the user if they want to decrypt the content
            System.out.println("Do you want to decrypt the content? (yes/no)");
            String decryptChoice = scanner.nextLine();

            if (decryptChoice.equalsIgnoreCase("yes")) {

                String decryptedContent = encryptionService.decrypt(encryptedContent);
                System.out.println("Decrypted content:");
                System.out.println(decryptedContent);
            } else {
                System.out.println("Decryption skipped.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
