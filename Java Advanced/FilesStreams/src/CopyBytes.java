import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        String inputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "F:\\SoftUni\\SoftUniCourses\\Java Advanced\\FilesStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";
        try(InputStream inputStream = new FileInputStream(inputPath)){
            OutputStream outputStream = new FileOutputStream(outputPath);
            while (true){
                int oneByte = inputStream.read();
                if(oneByte == -1){break;}
                if(oneByte == 10 || oneByte == 32){
                    outputStream.write(oneByte);
                }else{
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
