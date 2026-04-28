package exercise2;

import java.io.Serializable;

public class Publication implements Display,Serializable {
    private String title;
    private String language;
    private double price;


    // Constructor of Publication
    public Publication(String title, String language, double price) {
        this.title = title;
        this.language = language;
        this.price = price;
    }

    public String print() {
        //System.out.println("Returning title, language and price of publication...");
        return String.format("Title: %s, Language: %s, Price: %.2f", title, language, price);
    }
}
