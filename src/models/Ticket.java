package models;

import models.payment.Payment;
import models.slots.Slot;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private final UUID id;
    private ParkingLot parkingLot;
    private Floor floor;
    private Slot slot;
    private final Date entryTimestamp;
    private Date exitTimestamp;
    private Payment payment;
    private Integer amountPaid;

    public Ticket(ParkingLot parkingLot, Floor floor, Slot slot) {
        this.id = UUID.randomUUID();
        this.parkingLot = parkingLot;
        this.floor = floor;
        this.slot = slot;
        this.entryTimestamp = new Date();
        this.payment = null;
        this.amountPaid = 0;
    }

    public UUID getId() {
        return id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Date getEntryTimestamp() {
        return entryTimestamp;
    }

    public Date getExitTimestamp() {
        return exitTimestamp;
    }

    public void setExitTimestamp(Date exitTimestamp) {
        this.exitTimestamp = exitTimestamp;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", parkingLot=" + parkingLot +
                ", floor=" + floor +
                ", slot=" + slot +
                ", entryTimestamp=" + entryTimestamp +
                ", exitTimestamp=" + exitTimestamp +
                ", payment=" + payment +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
