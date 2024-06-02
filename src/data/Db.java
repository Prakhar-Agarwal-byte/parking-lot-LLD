package data;

import models.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Db {
    public final Map<String, ParkingLot> parkingLots = new HashMap<>();
    private static volatile Db INSTANCE = null;
    private Db() {}
    public static Db getInstance() {
        if (INSTANCE == null) {
            synchronized (Db.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Db();
                }
            }
        }
        return INSTANCE;
    }
}
