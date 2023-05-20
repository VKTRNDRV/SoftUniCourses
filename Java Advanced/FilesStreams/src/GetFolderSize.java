import java.io.File;
import java.nio.file.Path;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File file = new File(path);
        int size = 0;
        File[] files = file.listFiles();
        for(File currFile : files){
            size += currFile.length();
        }

        System.out.printf("Folder size: %d", size);
    }
}
