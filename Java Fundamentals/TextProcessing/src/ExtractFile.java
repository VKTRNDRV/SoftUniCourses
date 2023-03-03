import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String filePath = scan.nextLine();
        int extensionIndex = filePath.lastIndexOf('.') + 1;
        int fileNameIndex = filePath.lastIndexOf('\\') + 1;
        String fileName = filePath.substring(fileNameIndex, extensionIndex - 1);
        String extension = filePath.substring(extensionIndex);
        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s", extension);
    }
}
