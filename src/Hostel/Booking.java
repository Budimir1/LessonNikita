package Hostel;

public class Booking {
    private Guest guest;
    private Room room;
    private boolean checkIn;
    private boolean checkOut;

    public Booking(Guest guest, Room room, boolean checkIn, boolean checkOut) {
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public boolean booking(boolean booking){
        if(room.isAvailable){
            booking =true;
        }
        return booking;
    }

}
