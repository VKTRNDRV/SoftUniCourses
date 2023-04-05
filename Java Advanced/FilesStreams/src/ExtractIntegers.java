import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";
        try(Scanner scanner = new Scanner(new FileInputStream(inputPath))){
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath));
            while (scanner.hasNext()){
                if(scanner.hasNextInt()){
                    printWriter.println(scanner.nextInt());
                }
                scanner.next();
            }
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
