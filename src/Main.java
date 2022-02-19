import bookingstrategy.Default;
import constants.Color;
import constants.LotType;
import parking.Floor;
import parking.Lot;
import parking.Parking;
import vehicle.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();

        Scanner myStream = new Scanner(System.in);

        String parkingId = myStream.nextLine();

        parking.setParkingId(parkingId);

        int numberOfFloors = myStream.nextInt();
        int numberOfSlotsPerFloor = myStream.nextInt();

        int i, j;

        /**
         * creating the parking with floors and lots
         */
        for (i = 1; i <= numberOfFloors; i++) {
            Floor floor = new Floor();
            floor.setFloorNumber(i);

            for (j = 1; j <= numberOfSlotsPerFloor; j++) {
                Lot lot = new Lot();
                lot.setNumber(j);

                if (j == 1) {
                    lot.setLotType(LotType.TYPE_TRUCK);
                } else if (j < 4) {
                    lot.setLotType(LotType.TYPE_BIKE);
                } else {
                    lot.setLotType(LotType.TYPE_CAR);
                }
                floor.addLot(lot);
            }
            parking.addFloor(floor);
        }

        /**
         * vehicle create and park
         */
        Vehicle vehicle1 = new Vehicle("RJ-123-456", LotType.TYPE_CAR, Color.BLUE);
        Vehicle vehicle2 = new Vehicle("HR-07-9929", LotType.TYPE_BIKE, Color.GREEN);
        Vehicle vehicle3 = new Vehicle("GJ-07-9929", LotType.TYPE_TRUCK, Color.INDIGO);

        Vehicle vehicle4 = new Vehicle("GJ-07-9999", LotType.TYPE_TRUCK, Color.ORANGE);

        String ticketNumber1 = vehicle1.park(parking, new Default());
        String ticketNumber2 = vehicle2.park(parking, new Default());
        String ticketNumber3 = vehicle3.park(parking, new Default());
        String ticketNumber4 = vehicle4.park(parking, new Default());

        if (ticketNumber1 != null) {
            System.out.println(vehicle1.getNumber() + " ticket is:" + ticketNumber1);
        }

        if (ticketNumber2 != null) {
            System.out.println(vehicle2.getNumber() + " ticket is:" + ticketNumber2);
        }

        if (ticketNumber3 != null) {
            System.out.println(vehicle3.getNumber() + " ticket is:" + ticketNumber3);
        }

        if (ticketNumber4 != null) {
            System.out.println(vehicle4.getNumber() + " ticket is:" + ticketNumber4);
        }

        vehicle1.unPark(parking, ticketNumber1);

        Lot lotStatus = (Lot) ((Floor)parking.getFloors().get(1)).getLots().get(1);
        System.out.println("STATUS OF LOT AVAILABLE: "+ lotStatus.isStatus());

        Vehicle vehicle5 = new Vehicle("BG-123-456", LotType.TYPE_CAR, Color.BLUE);

        String ticketNumber5 = vehicle5.park(parking, new Default());

        if (ticketNumber4 != null) {
            System.out.println(vehicle5.getNumber() + " ticket is:" + ticketNumber5);
        }
    }
}
