/**
 * File: BusInfo.java
 * Author: LittleLittleWei
 * Time: 2021/11/2 20:20
 **/
public class BusInfo {
    String location;
    int price;
    int numBus;
    int numAvail;

    public BusInfo(String location, int price, int numBus, int numAvail) {
        this.location = location;
        this.price = price;
        this.numBus = numBus;
        this.numAvail = numAvail;
    }
}
