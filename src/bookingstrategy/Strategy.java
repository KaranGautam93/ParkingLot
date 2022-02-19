package bookingstrategy;

import parking.Parking;
import vehicle.Vehicle;

import java.util.List;

public interface Strategy {
    public List findFloorAndLot(Vehicle vehicle, Parking parking);
}
