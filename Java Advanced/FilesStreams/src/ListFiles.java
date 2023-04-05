import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        String folderPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File folder = new File(folderPath);
        if(folder.exists() && folder.isDirectory()){
            File[] filesArr = folder.listFiles();
            for(File file : filesArr){
                if(!file.isDirectory()){
                    System.out.printf("%s: [%s]%n", file.getName(), file.length());
                }
            }
        }
    }
}
