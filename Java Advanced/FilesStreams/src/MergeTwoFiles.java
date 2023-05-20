import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String firstInputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondInputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        List<String> firstFileLines = Files.readAllLines(Path.of(firstInputPath));
        List<String> secondFileLines = Files.readAllLines(Path.of(secondInputPath));
        PrintWriter writer = new PrintWriter("output.txt");
        for(String line : firstFileLines){
            writer.println(line);
        }

        for(String line : secondFileLines){
            writer.println(line);
        }

        writer.close();
    }
}
