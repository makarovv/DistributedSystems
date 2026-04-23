public class Car implements Display {
    private String colour;
    private int horsepower;
    private double weight;

    // Constructor of Car
    public Car(String colour, int horsepower, double weight) {
        this.colour = colour;
        this.horsepower = horsepower;
        this.weight = weight;
    }

    public String print() {
        //System.out.println("Returning colour, horsepower and weight of car...");
        return String.format("Colour: %s, Horsepower: %d, Weight: %.2f", colour, horsepower, weight);
    }

}
