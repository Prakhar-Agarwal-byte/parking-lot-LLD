package models.payment;

import models.Ticket;

import java.util.Date;

public abstract class Payment {
    public void pay(Ticket ticket) {
        Date entryTimestamp = ticket.getEntryTimestamp();
        Date exitTimestamp = ticket.getExitTimestamp();
        Date delta = new Date(entryTimestamp.getTime() - exitTimestamp.getTime());
        int numHours = (int) (delta.getTime() / 3600);
        int amount = ticket.getSlot().getCostPerHour() * numHours;
        ticket.setPayment(this);
        ticket.setAmountPaid(amount);
    }
}
