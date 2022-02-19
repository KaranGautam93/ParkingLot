package bookingstrategy;

import parking.Floor;
import parking.Lot;
import parking.Parking;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Default implements Strategy {
    @Override
    public List findFloorAndLot(Vehicle vehicle, Parking parking) {
        Iterator<Floor> floorIterator = parking.getFloors().values().iterator();

        while (floorIterator.hasNext()) {
            Floor floor = floorIterator.next();
            List floorLotsAvailable = floor.getEmptyLots(vehicle.getType());

            if (floorLotsAvailable.size() == 0) {
                continue;
            }

            List parkingList = new ArrayList<Integer>();

            Lot lot = (Lot) floorLotsAvailable.get(0);
            lot.setStatus(false);

            parkingList.add(floor.getFloorNumber());
            parkingList.add(lot.getNumber());

            return parkingList;
        }

        System.out.println(vehicle.getNumber()+ " :No Parking space available");
        return null;
    }
}
