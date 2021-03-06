/**
 * File: HotelInfo.java
 * Author: LittleLittleWei
 * Time: 2021/11/2 13:05
 **/
public class HotelInfo {
    String location;
    int price;
    int numRooms;
    int numAvail;

    public HotelInfo(String location, int price, int numRooms, int numAvail) {
        this.location = location;
        this.price = price;
        this.numRooms = numRooms;
        this.numAvail = numAvail;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public int getNumRooms() {
        return numRooms;
    }
}
