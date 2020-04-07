package cc.phil.planes;

public class FreightPlane extends Plane {
    // Membervariables
    //
    private String cargoDescription;    // TASK
    private double cargoWeight;

    // Constructor
    //
    public FreightPlane(String IDENTIFICATION, double MAXIMUMLADING, double EMPTYWEIGHT, double FUELCAPACITY,
                        double currentFuelAmount, String cargoDescription) {
        super(IDENTIFICATION, MAXIMUMLADING, EMPTYWEIGHT, FUELCAPACITY, currentFuelAmount);
        this.cargoDescription = cargoDescription;
        setCurrentWeight(0);
    }

    // Methodes
    //
    @Override
    public void printPlaneData() {
        super.printPlaneData();
        printCargoWeightMessage(0);
    }

    public void printCargoWeightMessage(double cargoWeight) {
        if (this.cargoWeight == 0) {
            System.out.println("Frachtgut ist komplett entladen");
        }
        if (cargoWeight > 0) {
            System.out.println("Frachtgewicht wurde verändert:");
            System.out.println("Neues Frachtgewicht in kg: " + cargoWeight);
        }
        System.out.println("Frachtgut: " + cargoDescription);
        System.out.println("Frachtgewicht momentan in kg: " + this.cargoWeight);
        System.out.println("Gesamt Gewicht Frachtflugzeug in kg: " + getCurrentWeight() + "\n");
    }

    public double load(double cargoWeight) {
        if (cargoWeight + getCurrentWeight() <= getMaximumWeight() && cargoWeight <= getMaximumlading()) {
            this.cargoWeight = cargoWeight;
            setCurrentWeight(this.cargoWeight);
            printHeaderMessage(cargoWeight + "KG WURDEN GELADEN");
        } else {
            printHeaderMessage("FRACHTGEWICHT KANN NICHT GELADEN WERDEN: " + cargoWeight + "KG");
            System.out.println();
        }
        if (getCurrentWeight() >= (getMaximumWeight() - 500)) {
            printHeaderMessage(getMESSAGEMAXIMUMWEIGHTACCOMPLISHED());
        }
        return this.cargoWeight;
    }

    public double unload() {
        double unloadCargoWeight = cargoWeight;
        cargoWeight = 0;
        setCurrentWeight(cargoWeight);
        printHeaderMessage("FRACHT ENTLADEN KG: " + unloadCargoWeight);
        printCargoWeightMessage(cargoWeight);
        return unloadCargoWeight;
    }
}
