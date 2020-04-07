package cc.phil.planes;

public class PassangerPlane extends Plane {
    // Memberconstants
    //
    private final int MAXIMUMPASSENGERS;            // TASK
    private final int AVERAGEWEIGHTPERPASSANGER;

    // Membervariables
    //
    private int amountOfPassengers;                 // TASK

    // Constructor
    //
    public PassangerPlane(String IDENTIFICATION, double maximumlading, double EMPTYWEIGHT,
                          double FUELCAPACITY, double currentFuelAmount, int MAXIMUMPASSENGERS,
                          int AVERAGEWEIGHTPERPASSANGER) {
        super(IDENTIFICATION, maximumlading, EMPTYWEIGHT, FUELCAPACITY, currentFuelAmount);
        this.MAXIMUMPASSENGERS = MAXIMUMPASSENGERS;
        this.AVERAGEWEIGHTPERPASSANGER = AVERAGEWEIGHTPERPASSANGER;
        setMaximumlading(maximumlading);
    }

    // Methodes
    //
    @Override
    public void printPlaneData() {
        super.printPlaneData();
        printPassengerPlaneData();
    }

    private void printPassengerPlaneData() {
        System.out.println("Maximale Personenanzahl: " + MAXIMUMPASSENGERS);
        System.out.println("Momentane Personenanzahl an Bord: " + getAmountOfPassengers());
        System.out.println("Durchschnittsgewicht/Person kg: " + AVERAGEWEIGHTPERPASSANGER);
        System.out.println("Maximales Ladegewicht: " + getMaximumlading());
        System.out.println("Maximales Gesamtgewicht: " + getMaximumWeight());
        System.out.println("Flugzeug Gesamtgewicht in kg: " + getCurrentWeight());
    }

    public int unBoarding() {
        int unboardPassangersAmount = amountOfPassengers;
        amountOfPassengers = 0;
        setCurrentWeight(0);
        printHeaderMessage("PASSAGIERE VON BORD");
        System.out.println("Personenanzahl von Bord: " + unboardPassangersAmount);
        printPassengerPlaneData();
        return unboardPassangersAmount;
    }

    public void boarding(int amountOfPassengers) {
        double weightOfPassangers = amountOfPassengers * AVERAGEWEIGHTPERPASSANGER;

        if (amountOfPassengers <= MAXIMUMPASSENGERS) {
            if (weightOfPassangers <= getMaximumlading()) {
                this.amountOfPassengers = amountOfPassengers;
                setCurrentWeight(weightOfPassangers);
                printHeaderMessage("PASSAGIERE AN BORD: " + getAmountOfPassengers());
                printPassengerPlaneData();
            } else {
                printHeaderMessage("Personengewicht kann nicht gefasst werden, ".toUpperCase() +
                        "maximal ".toUpperCase() + getMaximumlading() + " KG möglich".toUpperCase());
            }
        } else {
            printHeaderMessage("Personenzahl kann nicht gefasst werden".toUpperCase());
            System.out.println("maximal ".toUpperCase() + MAXIMUMPASSENGERS + " Passagiere möglich".toUpperCase());
        }
    }

    // Getter/Setter
    //
    public int getAmountOfPassengers() {
        return amountOfPassengers;
    }

    @Override
    public double getMaximumWeight() {
        return getEmptyWeightAndCurrentFuelAmount() + getMaximumlading();
    }
}
