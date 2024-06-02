package models;

import models.slots.Bike;
import models.slots.Car;
import models.slots.Slot;
import models.slots.Truck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLot {
    private final String id;
    List<Floor> floors;

    public ParkingLot(String id, int numFloors) {
        this.id = id;
        this.floors = new ArrayList<>(numFloors);
        for (int i = 0; i < numFloors; i++) {
            Slot s1 = new Truck(1);
            Slot s2 = new Car(2);
            Slot s3 = new Car(3);
            Slot s4 = new Bike(4);
            Slot s5 = new Bike(5);
            Slot s6 = new Bike(6);
            Slot s7 = new Bike(7);
            List<Slot> slots = new ArrayList<>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7));
            Floor floor = new Floor(i, slots);
            floors.add(floor);
        }
    }

    public String getId() {
        return id;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id='" + id + '\'' +
                ", floors=" + floors +
                '}';
    }
}
