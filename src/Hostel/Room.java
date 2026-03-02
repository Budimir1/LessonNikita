package Hostel;

public class Room {
    private int number;
    private String type;
    private float price;
    public boolean isAvailable;

    public Room(int number, String type, float price, boolean isAvailable) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int freePlace(int countFreePlace){
        if (isAvailable) {
            countFreePlace +=1;
        }
        return countFreePlace;
    }

    public double priceRoom(int day){
        float totalPrice = price * day;
        return totalPrice;
    }
}
