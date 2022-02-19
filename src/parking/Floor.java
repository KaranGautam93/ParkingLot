package parking;

import constants.LotType;

import java.util.*;

public class Floor {
    private Map lots;
    private int floorNumber;

    public Floor() {
        lots = new HashMap<Integer, Lot>();
    }

    public Map getLots() {
        return lots;
    }

    public void setLots(Map lots) {
        this.lots = lots;
    }

    public void addLot(Lot lot) {
        lots.put(lots.size() + 1, lot);
    }

    public List getEmptyLots(LotType type) {
        Iterator<Lot> floorIterator = lots.values().iterator();

        List<Lot> lotsAvailable = new ArrayList<Lot>();

        while (floorIterator.hasNext()) {
            Lot lot = floorIterator.next();

            if (lot.isStatus()) {
                lotsAvailable.add(lot);
            }
        }

        return lotsAvailable;
    }

    public List getFilledLots(LotType type) {
        Iterator<Lot> floorIterator = lots.values().iterator();

        List<Lot> lotsAvailable = new ArrayList<Lot>();

        while (floorIterator.hasNext()) {
            Lot lot = floorIterator.next();

            if (!lot.isStatus()) {
                lotsAvailable.add(lot);
            }
        }

        return lotsAvailable;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
