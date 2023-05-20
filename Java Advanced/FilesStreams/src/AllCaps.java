import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCaps {
    public static void main(String[] args) {
        String inputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            OutputStream outputStream = new FileOutputStream(outputPath);

            String line = reader.readLine();
            while (line != null){
                StringBuilder lineCaps = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if(Character.isLetter(ch) && Character.isLowerCase(ch)){
                        lineCaps.append(Character.toUpperCase(ch));
                    }else{
                        lineCaps.append(ch);
                    }
                }

                for (int i = 0; i < lineCaps.length(); i++) {
                    outputStream.write(lineCaps.charAt(i));
                }
//                outputStream.write('\n');
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
