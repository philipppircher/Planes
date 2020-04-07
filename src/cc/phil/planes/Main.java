package cc.phil.planes;

import cc.phil.planes.FreightPlane;
import cc.phil.planes.PassangerPlane;

public class Main {
    public static void main(String[] args) {
        FreightPlane freightPlane = new FreightPlane("11A550T8", 10000, 2500,
                500, 500, "Elektrotechnische Waren");

        double cargoWeightToLoad = 10000;

        freightPlane.printPlaneData();
        freightPlane.printCargoWeightMessage(freightPlane.load(cargoWeightToLoad));
        freightPlane.unload();
        freightPlane.printCargoWeightMessage(freightPlane.load(10000));
        freightPlane.printPlaneData();

        PassangerPlane passangerPlane = new PassangerPlane(
                "LaudaAirLine123", 15000, 3000,
                600, 500, 300, 70);
        int amountOfPassangers = 100;

        passangerPlane.printPlaneData();
        passangerPlane.boarding(amountOfPassangers);
        passangerPlane.printPlaneData();
        passangerPlane.boarding(300);
        System.out.println("Personen von Bord: " + passangerPlane.unBoarding());
    }
}
