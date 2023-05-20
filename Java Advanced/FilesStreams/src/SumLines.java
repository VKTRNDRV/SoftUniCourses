import java.io.BufferedReader;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String path = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))){
            String line = reader.readLine();
            while (line != null){
                int lineSum = 0;
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    lineSum += ch;
                }
                System.out.println(lineSum);
                line = reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
