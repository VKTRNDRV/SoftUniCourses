import java.util.*;

public class AdvertisementMessage {
    private String phrase;
    private String event;
    private String author;
    private String city;
    private static Random randomIndex = new Random();

    private static List<String> phrasesList = new ArrayList<>
            (Arrays.asList("Excellent product.","Such a great product.","I always use that product."
                    ,"Best product of its category.","Exceptional product.","I can’t live without this product."));

    private static List<String> eventsList = new ArrayList<>
            (Arrays.asList("Now I feel good.","I have succeeded with this product.","Makes miracles. I am happy of the results!"
                    ,"I cannot believe but now I feel awesome.","Try it yourself, I am very satisfied.","I feel great!"));

    private static List<String> authorsList = new ArrayList<>
            (Arrays.asList("Diana","Petya","Stella","Elena","Katya","Iva","Annie","Eva"));

    private static List<String> citiesList = new ArrayList<>(Arrays.asList("Burgas","Sofia","Plovdiv","Varna","Ruse"));

    public AdvertisementMessage(){
        this.phrase = phrasesList.get(randomIndex.nextInt(phrasesList.size()));
        this.event = eventsList.get(randomIndex.nextInt(eventsList.size()));
        this.author = authorsList.get(randomIndex.nextInt(authorsList.size()));
        this.city = citiesList.get(randomIndex.nextInt(citiesList.size()));
    }

    public String getPhrase(){return phrase;}
    public void setPhrase(String phrase){this.phrase = phrase;}
    public void setRandomPhrase(){this.phrase = phrasesList.get(randomIndex.nextInt(phrasesList.size()));}

    public String getEvent(){return event;}
    public void setEvent(String event){this.event = event;}
    public void setRandomEvent(){this.event = eventsList.get(randomIndex.nextInt(eventsList.size()));}

    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}
    public void setRandomAuthor(){this.author = authorsList.get(randomIndex.nextInt(authorsList.size()));}

    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}
    public void setRandomCity(){this.city = citiesList.get(randomIndex.nextInt(citiesList.size()));}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfMessages = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= numOfMessages; i++) {
            AdvertisementMessage advert = new AdvertisementMessage();
            String advertPhrase = advert.getPhrase();
            String advertEvent = advert.getEvent();
            String advertAuthor = advert.getAuthor();
            String advertCity = advert.getCity();

            System.out.printf("%s %s %s - %s%n", advertPhrase, advertEvent, advertAuthor, advertCity);
        }
    }
}
