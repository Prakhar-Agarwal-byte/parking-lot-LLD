package daos;

import models.ParkingLot;

import java.util.List;

public interface ParkingLotDao {
    void addParkingLot(ParkingLot parkingLot);
    void updateParkingLot(ParkingLot parkingLot);
    void deleteParkingLot(ParkingLot parkingLot);
    ParkingLot getParkingLotById(int id);
    List<ParkingLot> getAllParkingLots();
}
