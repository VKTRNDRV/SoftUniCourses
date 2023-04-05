import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";
        try (Scanner scanner =
                     new Scanner(new FileInputStream(inputPath));
             PrintWriter printWriter =
                     new PrintWriter(outputPath)){
            int counter = 1;
            while (scanner.hasNext()){
                String lineStr = scanner.nextLine();
                if(counter % 3 == 0){
                    printWriter.println(lineStr);
                }
                counter++;
            }
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
