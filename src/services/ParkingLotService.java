package services;

import daos.ParkingLotDao;
import daos.ParkingLotDaoImpl;
import models.Floor;
import models.ParkingLot;
import models.Ticket;
import models.payment.Payment;
import models.slots.Slot;
import strategies.SlotSelectionStrategy;

import java.util.*;

public class ParkingLotService {
    private final ParkingLotDao parkingLotDao = new ParkingLotDaoImpl();

    public Ticket reserveSlot(ParkingLot parkingLot, Floor floor, Slot selectedSlot, SlotSelectionStrategy strategy) {
        Slot slot = strategy.getSlot(parkingLot, floor, selectedSlot);
        slot.setOccupied(true);
        return new Ticket(parkingLot, floor, slot);
    }

    public void freeSlot(Ticket ticket, Payment paymentMethod) {
        ticket.setExitTimestamp(new Date());
        paymentMethod.pay(ticket);
        ticket.getSlot().setOccupied(false);
    }

    public Map<Floor, List<Slot>> getFreeSlots(ParkingLot parkingLot, Slot selectedSlot) {
        List<Floor> floors = parkingLot.getFloors();
        Map<Floor, List<Slot>> slots = new HashMap<>();
        for (Floor floor : floors) {
            List<Slot> emptySlots = new ArrayList<>();
            for (Slot slot: floor.getSlots()) {
                if (!slot.isOccupied() && slot.getClass().getSimpleName().equals(selectedSlot.getClass().getSimpleName())) {
                    emptySlots.add(slot);
                }
            }
            slots.put(floor, emptySlots);
        }
        return slots;
    }

    public Map<Floor, List<Slot>> getOccupiedSlots(ParkingLot parkingLot, Slot selectedSlot) {
        List<Floor> floors = parkingLot.getFloors();
        Map<Floor, List<Slot>> slots = new HashMap<>();
        for (Floor floor : floors) {
            List<Slot> emptySlots = new ArrayList<>();
            for (Slot slot: floor.getSlots()) {
                if (slot.isOccupied() && slot.getClass().getSimpleName().equals(selectedSlot.getClass().getSimpleName())) {
                    emptySlots.add(slot);
                }
            }
            slots.put(floor, emptySlots);
        }
        return slots;
    }
}
