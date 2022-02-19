package parking;

import constants.LotType;

public class Lot {
    private int number;

    private LotType lotType;

    private boolean status = true;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LotType getLotType() {
        return lotType;
    }

    public void setLotType(LotType lotType) {
        this.lotType = lotType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
