package Hostel;

import java.util.ArrayList;
import java.util.List;

public class Hotel{
    private String name;
    private List<String> rooms;
    private float rating;

    public Hotel(String name, float rating) {
        this.name = name;
        rooms = new ArrayList<>();
        this.rating = rating;
    }
    public void addRooms(Room room){
        rooms.add(room.toString());
    }
}
