public class Application {
    public static void main(String[] args) {
        Display display[] = new Display[4];
        display[0] = new Publication("The Great Gatsby", "English", 10.99);
        display[1] = new Book("To Kill a Mockingbird", "English", 12.99, "Harper Lee", "978-0061120084");
        display[2] = new Car("Red", 200, 1500.0);

        
    }
}
