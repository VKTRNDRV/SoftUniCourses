import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String textPath =
                "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String[] words = scanner.nextLine().split("\\s+");
        List<String> lines = Files.readAllLines(Path.of(textPath));
        PrintWriter writer = new PrintWriter("results.txt");

        for(String word : words){
            int count = 0;
            for(String line : lines) {
                String lineToLowerCase = line.toLowerCase();
                Pattern pattern = Pattern.compile(word.toLowerCase());
                Matcher matcher = pattern.matcher(lineToLowerCase);
                while (matcher.find()){
                    count++;
                }
            }

            writer.println(String.format("%s - %d", word, count));
        }

        writer.close();

    }
}
