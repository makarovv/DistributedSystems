
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Application {
    public static void main(String[] args) {
        Display display[] = new Display[4];
        display[0] = new Publication("The Great Gatsby", "English", 10.99);
        display[1] = new Book("To Kill a Mockingbird", "English", 12.99, "Harper Lee", "978-0061120084");
        display[2] = new Car("Red", 200, 1500.0);

        try{
            FileOutputStream fileOut = new FileOutputStream("test.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            for (Display d : display) {
                os.writeObject(d);
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
