public class App {
    public static void main(String[] args) {
        Publication publication[] = new Publication[4];
        publication[0] = new Publication("The Great Gatsby", "English", 10.99);


        publication[1] = new Book("To Kill a Mockingbird", "English", 12.99, "Harper Lee", "978-0061120084");


        /* for (Publication pub : publication) {
            if (pub != null) {
                System.out.println(pub.print());
            }
        }
        */


        Display display[] = new Display[4];
        display[0] = new Car("Red", 200, 1500.0);
        display[1] = new Book("To Kill a Mockingbird", "English", 12.99, "Harper Lee", "978-0061120084");
        display[2] = new Publication("The Great Gatsby", "English", 10.99);

        for (Display disp : display) {
            if (disp != null) {
                System.out.println(disp.print());
            }
        }
    }
}