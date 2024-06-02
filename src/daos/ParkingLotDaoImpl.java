package daos;

import data.Db;
import exceptions.ParkingLotDoesNotExist;
import models.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDaoImpl implements ParkingLotDao{
    private final Db db = Db.getInstance();
    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        db.parkingLots.put(parkingLot.getId(), parkingLot);
    }

    @Override
    public void updateParkingLot(ParkingLot parkingLot) {
        ParkingLot oldParkingLot = db.parkingLots.get(parkingLot.getId());
        if (oldParkingLot == null) throw new ParkingLotDoesNotExist();
        db.parkingLots.put(parkingLot.getId(), parkingLot);
    }

    @Override
    public void deleteParkingLot(ParkingLot parkingLot) {
        db.parkingLots.remove(parkingLot.getId());
    }

    @Override
    public ParkingLot getParkingLotById(int id) {
        ParkingLot parkingLot = db.parkingLots.get(id);
        if (parkingLot == null) throw new ParkingLotDoesNotExist();
        return parkingLot;
    }

    @Override
    public List<ParkingLot> getAllParkingLots() {
        return new ArrayList<>(db.parkingLots.values());
    }
}
