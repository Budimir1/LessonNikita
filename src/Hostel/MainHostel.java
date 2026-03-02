package Hostel;

public class MainHostel {
    public static void main(String[] args) {
        Hotel hostel1 = new Hotel("Pobeda",  4.7f);
        Room rooms1 = new Room(1, "2-ух комнатная", 20123f, true);
        Room rooms2 = new Room(1, "1 комнатная", 10123f, false);
        Room rooms3 = new Room(1, "3-ух комнатная", 30123f, true);
        hostel1.addRooms(rooms1);
        hostel1.addRooms(rooms2);
        hostel1.addRooms(rooms3);
        Guest guest1 = new Guest("Dima", "+79398349", "dima@mail,ru");
        Booking booking = new Booking(guest1, rooms2, true, false);

        rooms1.freePlace(0);
        rooms2.freePlace(0);
        rooms3.freePlace(0);
        rooms1.priceRoom(2);
        rooms2.priceRoom(4);
        rooms3.priceRoom(6);
        booking.booking(true);

        System.out.println(guest1);
        System.out.println(rooms1);
        System.out.println(booking);
        System.out.println(rooms3.priceRoom(6));
    }


}
