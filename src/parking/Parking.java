package parking;

import java.util.HashMap;
import java.util.Map;

public class Parking {
    private Map floors;

    private String parkingId;

    public Parking() {
        floors = new HashMap<Integer, Floor>();
    }

    public Map getFloors() {
        return floors;
    }

    public void addFloor(Floor floor) {
        floors.put(floors.size() + 1, floor);
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }
}
