import models.ParkingLot;
import models.Ticket;
import models.payment.Cash;
import models.slots.Truck;
import services.ParkingLotService;
import strategies.LowestFloorFirstSlotSelectionStrategy;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        ParkingLot p1 = new ParkingLot("PL-1", 5);
//        System.out.println(parkingLotService.getFreeSlots(p1, new Bike(1)));
        Ticket t1 = parkingLotService.reserveSlot(p1, null, new Truck(1), new LowestFloorFirstSlotSelectionStrategy());
        parkingLotService.freeSlot(t1, new Cash());
        System.out.println(t1);
    }
}
