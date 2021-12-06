/**
 * File: FlightInfo.java
 * Author: LittleLittleWei
 * Time: 2021/11/2 20:04
 **/
public class FlightInfo {
    String flightNum;
    int price;
    int numSeats;
    int numAvail;
    String fromCity;
    String arivCity;

    public FlightInfo(String flightNum, int price, int numSeats, int numAvail,
                      String fromCity, String arivCity) {
        this.flightNum = flightNum;
        this.price = price;
        this.numSeats = numSeats;
        this.numAvail = numAvail;
        this.fromCity = fromCity;
        this.arivCity = arivCity;
    }
}
