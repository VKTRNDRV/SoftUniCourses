import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Song {
    private String typeList;
    private String name;
    private String time;

    public String getTypeList(){
        return typeList;
    }
    public void setTypeList(String typeList){
        this.typeList = typeList;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int songsCount = Integer.parseInt(scan.nextLine());
        List<Song> songsList = new ArrayList<>();

        for (int i = 1; i <= songsCount; i++) {
            String[] currentSong = scan.nextLine().split("_");

            String type = currentSong[0];
            String name = currentSong[1];
            String time = currentSong[2];

            Song song = new Song();
            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songsList.add(song);
        }

        String typeToBePrinted = scan.nextLine();
        if(typeToBePrinted.equals("all")){
            for(Song currentSong : songsList){
                System.out.println(currentSong.getName());
            }

        }else{
           for(Song currentSong : songsList){
               String currentSongType = currentSong.getTypeList();
               if(currentSongType.equals(typeToBePrinted)){
                   System.out.println(currentSong.getName());
               }
           }
        }
    }
}
