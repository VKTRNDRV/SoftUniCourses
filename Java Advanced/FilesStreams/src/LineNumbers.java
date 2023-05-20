import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath =
                "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath =
                "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        int lineCounter = 0;
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            PrintWriter writer = new PrintWriter("output_line_numbers.txt");
            String line = reader.readLine();
            lineCounter++;
            while (line != null){
                writer.println(String.format("%d. %s", lineCounter, line));
                line = reader.readLine();
                lineCounter++;
            }

            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
