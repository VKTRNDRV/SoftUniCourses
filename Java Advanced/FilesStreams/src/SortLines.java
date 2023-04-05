import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get("F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path outputPath = Paths.get("F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");
        try{
            List<String> linesList = Files.readAllLines(inputPath);
            linesList = linesList.stream()
                    .filter(l -> !l.isBlank())
                    .sorted().
                    collect(Collectors.toList());
            Files.write(outputPath, linesList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}