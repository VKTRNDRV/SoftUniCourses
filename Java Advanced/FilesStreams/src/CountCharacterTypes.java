import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        int vowelsCount = 0;
        int punctuationCount = 0;
        int otherCount = 0;
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            String line = reader.readLine();
            while (line != null){
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if(ch == ',' || ch == '.' || ch == '!' || ch == '?'){
                        punctuationCount++;

                    }else if(ch == 'a' || ch == 'e' || ch == 'o' || ch == 'u' || ch == 'i'){
                        vowelsCount++;

                    }else if(!Character.isWhitespace(ch)){
                        otherCount++;
                    }
                }

                line = reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Vowels: " + vowelsCount);
            writer.newLine();
            writer.write("Other symbols: " + otherCount);
            writer.newLine();
            writer.write("Punctuation: " + punctuationCount);
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
