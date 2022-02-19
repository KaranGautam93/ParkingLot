package vehicle;

import bookingstrategy.Strategy;
import constants.Color;
import constants.LotType;
import parking.Floor;
import parking.Lot;
import parking.Parking;

import java.util.Iterator;
import java.util.List;

public class Vehicle {
    private String number;
    private LotType type;
    private Color color;

    public Vehicle(String number, LotType type, Color color) {
        this.number = number;
        this.type = type;
        this.color = color;
    }

    public String park(Parking parking, Strategy strategy) {
        List floorData = strategy.findFloorAndLot(this, parking);

        if (floorData == null) {
            return null;
        }

        int floorNumber = (int) floorData.get(0);
        int lotNumber = (int) floorData.get(1);

        return parking.getParkingId() + "_" + floorNumber + "_" + lotNumber;
    }

    public void unPark(Parking parking, String ticketNumber) {
        String[] split = ticketNumber.split("_");

        Floor floor = (Floor) parking.getFloors().get(Integer.parseInt(split[1]));

        if (floor == null) {
            System.out.println("invalid ticket floor");
            return;
        }

        Lot lot = (Lot) floor.getLots().get(Integer.parseInt(split[2]));

        if (lot == null || lot.isStatus()) {
            System.out.println("invalid ticket lot");
            return;
        }

        lot.setStatus(true);
    }

    public LotType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }
}
