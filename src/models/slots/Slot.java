package models.slots;

import models.Floor;

public abstract class Slot {
    int serialNumber;
    boolean isOccupied;
    int costPerHour;

    public Slot(int serialNumber, int costPerHour) {
        this.serialNumber = serialNumber;
        this.isOccupied = false;
        this.costPerHour = costPerHour;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "serialNumber=" + serialNumber +
                ", isOccupied=" + isOccupied +
                ", costPerHour=" + costPerHour +
                '}';
    }
}
