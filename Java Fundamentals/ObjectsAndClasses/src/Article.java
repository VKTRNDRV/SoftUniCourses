import java.util.List;
import java.util.Scanner;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String content){
        this.content = content;
    }

    public void changeAuthor(String author){
        this.author = author;
    }

    public void rename(String title){
        this.title = title;
    }

    public String toString(){
        String title = this.title;
        String content = this.content;
        String author = this.author;
        return title + " - " + content + ": " + author;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] articleElements = scan.nextLine().split(", ");
        Article article = new Article(articleElements[0], articleElements[1], articleElements[2]);
        int commandsCount = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= commandsCount; i++) {
            String[] currentCommand = scan.nextLine().split(": ");

            switch (currentCommand[0]){
                case "Edit":
                    String contentNew = currentCommand[1];
                    article.edit(contentNew);
                    break;

                case "ChangeAuthor":
                    String authorNew = currentCommand[1];
                    article.changeAuthor(authorNew);
                    break;

                case "Rename":
                    String titleNew = currentCommand[1];
                    article.rename(titleNew);
                    break;
            }
        }

        System.out.println(article.toString());
    }
}
