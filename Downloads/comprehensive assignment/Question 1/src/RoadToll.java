public class RoadToll {
    private String typeOfVehicle;
    private int numberOfTires;

    public RoadToll(String typeOfVehicle, int numberOfTires) {
        this.typeOfVehicle = typeOfVehicle;
        this.numberOfTires = numberOfTires;
    }

    public double calculateToll() {
        if (numberOfTires == 2) {
            return 0.00;
        } else if (numberOfTires == 4) {
            return 50.00;
        } else if (numberOfTires > 4) {
            return 100.00;
        } else {
            System.out.println("Invalid number of tires.");
            return -1; // Negative value to indicate an error
        }
    }

    public static void main(String[] args) {
        RoadToll vehicle1 = new RoadToll("Car", 4);
        RoadToll vehicle2 = new RoadToll("Truck", 6);

        double toll1 = vehicle1.calculateToll();
        double toll2 = vehicle2.calculateToll();

        System.out.println("Toll for " + vehicle1.typeOfVehicle + " with " + vehicle1.numberOfTires + " tires: Rs. " + toll1);
        System.out.println("Toll for " + vehicle2.typeOfVehicle + " with " + vehicle2.numberOfTires + " tires: Rs. " + toll2);
    }
}
