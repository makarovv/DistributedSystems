public class Book extends Publication {
    private String author;
    private String ISBN;


    //Constructor of Book
    public Book(String title, String language, double price, String author, String ISBN) {
        super(title, language, price);
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    public String print() {
        //System.out.println("Returning title, language, price, author and ISBN of book...");
        return String.format("%s, Author: %s, ISBN: %s", super.print(), author, ISBN);
    }

}
