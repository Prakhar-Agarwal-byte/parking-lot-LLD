package strategies;

import models.Floor;
import models.ParkingLot;
import models.slots.Slot;

public interface SlotSelectionStrategy {
    Slot getSlot(ParkingLot parkingLot, Floor floor, Slot selectedSlot);
}
