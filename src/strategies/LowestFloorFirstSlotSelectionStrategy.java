package strategies;

import models.Floor;
import models.ParkingLot;
import models.slots.Slot;

public class LowestFloorFirstSlotSelectionStrategy implements SlotSelectionStrategy{
    @Override
    public Slot getSlot(ParkingLot parkingLot, Floor floor, Slot selectedSlot) {
        for (Floor curFloor: parkingLot.getFloors()) {
            for (Slot slot: curFloor.getSlots()) {
                if (!slot.isOccupied() && slot.getClass().getSimpleName().equals(selectedSlot.getClass().getSimpleName())) {
                    return slot;
                }
            }
        }
        return null;
    }
}
