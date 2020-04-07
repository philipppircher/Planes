package cc.phil.planes;

public class Plane {
    // Memberconstants
    //
    private final String IDENTIFICATION;    // TASK
    private final double EMPTYWEIGHT;       // TASK
    private final double FUELCAPACITY;      // TASK
    private final String MESSAGEMAXIMUMWEIGHTACCOMPLISHED;

    // Membervariables
    //
    private double currentWeight;           // getter/setter
    private double maximumWeight;           // getter
    private double currentFuelAmount;
    private double maximumlading;

    // Constructor
    //
    public Plane(String IDENTIFICATION, double maximumlading, double EMPTYWEIGHT,
                 double FUELCAPACITY, double currentFuelAmount) {
        this.IDENTIFICATION = IDENTIFICATION;
        setMaximumlading(maximumlading);
        this.EMPTYWEIGHT = EMPTYWEIGHT;
        this.FUELCAPACITY = FUELCAPACITY;
        this.currentFuelAmount = currentFuelAmount;
        this.currentWeight = getCurrentWeight();
        this.maximumWeight = getMaximumWeight();
        setCurrentWeight(0);    // Intialize currentWeight only with EMTYWEIGHT + FUELCAPACITY, 0 for weight of lading
        this.MESSAGEMAXIMUMWEIGHTACCOMPLISHED = "ACHTUNG, MAXIMALGEWICHT: " + maximumWeight;
    }

    public void printPlaneData() {
        printHeaderMessage("TECHNISCHES MERKBLATT VON " + IDENTIFICATION);
        System.out.println("Identifakationsnummer: " + IDENTIFICATION);
        System.out.println("Kraftstofftkapazität in l: " + FUELCAPACITY);
        System.out.println("Momentaner Kraftstoff in l: " + currentFuelAmount);
        System.out.println("Maximalgewicht in kg: " + getMaximumWeight());
        System.out.println("Leergewicht (inkl Kraftstoff) in kg: " + getEmptyWeightAndCurrentFuelAmount());
        System.out.println("Momentangewicht in kg: " + getCurrentWeight());
        if (getCurrentWeight() >= (getMaximumWeight() - 500)) {
            printHeaderMessage(MESSAGEMAXIMUMWEIGHTACCOMPLISHED);
        }
    }

    public void printHeaderMessage(String messageText) {
        System.out.println("-----------------------------------------");
        System.out.println(messageText);
        System.out.println("-----------------------------------------");
    }

    // Getter/Setter (in UML Task defined)
    //
    public double getEmptyWeightAndCurrentFuelAmount() {
        return EMPTYWEIGHT + currentFuelAmount;
    }

    public double getCurrentWeight() {      // TASK of FreightPlane and PassangerPlane
        return currentWeight;
    }

    // setCurrentWeight -> TASK !!!
    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = getEmptyWeightAndCurrentFuelAmount() + currentWeight;
    }

    public double getMaximumWeight() {
        maximumWeight = maximumlading + getEmptyWeightAndCurrentFuelAmount();
        return maximumWeight;
    }

    // Initialise maximumlading in Constructor
    public double getMaximumlading() {
        return maximumlading;
    }

    public void setMaximumlading(double maximumlading) {
        this.maximumlading = maximumlading;
    }

    public String getMESSAGEMAXIMUMWEIGHTACCOMPLISHED() {
        return "ACHTUNG!! MAXIMALGEWICHT: " + getMaximumWeight();
    }
}
