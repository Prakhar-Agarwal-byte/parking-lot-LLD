package exceptions;

public class ParkingLotDoesNotExist extends IllegalArgumentException{
    public ParkingLotDoesNotExist() {
        super("Parking lot does not exist");
    }
}
