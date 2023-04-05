import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        List<Character> punctuationsCharsList = new ArrayList<>();
        Collections.addAll(punctuationsCharsList,  '.', ',', '!', '?');
        try(InputStream inputStream = new FileInputStream(inputPath);){
            OutputStream outputStream = new FileOutputStream(outputPath);
            while (true){
                int oneByte = inputStream.read();
                if(oneByte == -1){break;}
                if(!punctuationsCharsList.contains((char)oneByte)){
                    outputStream.write(oneByte);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
