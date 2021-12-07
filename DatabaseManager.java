import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * File: DatabaseManager.java
 * Author: LittleLittleWei
 * Time: 2021/11/1 13:17
 **/
public class DatabaseManager {
    static ResultSet rs;
    static Connection conn;

    public DatabaseManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();
            conn = DriverManager.getConnection("jdbc:mysql://101.42.109.18:3306/database",
                    "database", "123456");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + " 毫秒");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean addFlightInfo(String flightNum, int price, int numSeats,
                                     int numAvail, String fromCity, String arivCity) {
        try {
            String word = "INSERT INTO flights VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, flightNum);
            ps.setInt(2, price);
            ps.setInt(3, numSeats);
            ps.setInt(4, numAvail);
            ps.setString(5, fromCity);
            ps.setString(6, arivCity);
            ps.execute();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            return false;
        }
    }

    public static boolean addHotelInfo(String location, int price, int numRooms, int numAvail) {
        try {
            String word = "INSERT INTO hotels VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, location);
            ps.setInt(2, price);
            ps.setInt(3, numRooms);
            ps.setInt(4, numAvail);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addBusInfo(String location, int price, int numBus, int numAvail) {
        try {
            String word = "INSERT INTO bus VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, location);
            ps.setInt(2, price);
            ps.setInt(3, numBus);
            ps.setInt(4, numAvail);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addCustomerInfo(String custName, String custID) {
        try {
            String word = "INSERT INTO customers VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, custName);
            ps.setString(2, custID);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean reserveFlight(String custName, String flightNum) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("MMddhhmmss");
        String resvKey = String.valueOf(dateFormat.format(date));
        try {
            String word = "INSERT INTO reservations VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, resvKey);
            ps.setString(2, custName);
            ps.setInt(3, 1);
            ps.setString(4, flightNum);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean reserveHotel(String custName, String location) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("MMddhhmmss");
        String resvKey = String.valueOf(dateFormat.format(date));
        try {
            String word = "INSERT INTO reservations VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, resvKey);
            ps.setString(2, custName);
            ps.setInt(3, 2);
            ps.setString(4, location);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean reserveBus(String custName, String location) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("MMddhhmmss");
        String resvKey = String.valueOf(dateFormat.format(date));
        try {
            String word = "INSERT INTO reservations VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, resvKey);
            ps.setString(2, custName);
            ps.setInt(3, 3);
            ps.setString(4, location);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static HotelInfo queryHotelInfo(String location) {
        HotelInfo hotelInfo = new HotelInfo(location, 0, 0, 0);
        try {
            String word = "SELECT * FROM hotels where location = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hotelInfo.price = rs.getInt("price");
                hotelInfo.numRooms = rs.getInt("numRooms");
                hotelInfo.numAvail = rs.getInt("numAvail");
            }
            return hotelInfo;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return hotelInfo;
        }
    }

    public static FlightInfo queryFlightInfo(String flightNum) {
        FlightInfo flightInfo = new FlightInfo(flightNum,
                0, 0, 0, "null", "null");
        try {
            String word = "SELECT * FROM flights where flightNum = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, flightNum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                flightInfo.price = rs.getInt("price");
                flightInfo.numSeats = rs.getInt("numSeats");
                flightInfo.numAvail = rs.getInt("numAvail");
                flightInfo.fromCity = rs.getString("FromCity");
                flightInfo.arivCity = rs.getString("ArivCity");
            }
            return flightInfo;
        }
        catch (SQLException e) {
//            e.printStackTrace();
            return flightInfo;
        }
    }

    public static BusInfo queryBusInfo(String location) {
        BusInfo busInfo = new BusInfo(location,
                0, 0, 0);
        try {
            String word = "SELECT * FROM bus where location = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                busInfo.price = rs.getInt("price");
                busInfo.numBus = rs.getInt("numBus");
                busInfo.numAvail = rs.getInt("numAvail");
            }
            return busInfo;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return busInfo;
        }
    }

    public static boolean updateFlightInfo(String flightNum, int price, int numSeats, int numAvail, String fromCity, String arivCity) {
        try {
            String word = "UPDATE flights SET price = ?, numSeats = ?," +
                    "numAvail = ?, FromCity = ?, ArivCity = ? " +
                    "WHERE flightNum = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setInt(1, price);
            ps.setInt(2, numSeats);
            ps.setInt(3, numAvail);
            ps.setString(4, fromCity);
            ps.setString(5, arivCity);
            ps.setString(6, flightNum);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCustomerInfo(String custName, String custID) {
        try {
            String word = "UPDATE customers SET custID = ? "+
                    "WHERE  custName = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, custID);
            ps.setString(2, custName);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateBusInfo(String location, int price, int numBus, int numAvail) {
        try {
            String word = "UPDATE bus SET price = ?, numBus = ?, numAvail = ? "+
                    "WHERE location = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setInt(1, price);
            ps.setInt(2, numBus);
            ps.setInt(3, numAvail);
            ps.setString(4, location);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateHotelInfo(String location, int price, int numRooms, int numAvail) {
        try {
            String word = "UPDATE hotels SET price = ?, numRooms = ?, numAvail = ? "+
                    "WHERE location = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setInt(1, price);
            ps.setInt(2, numRooms);
            ps.setInt(3, numAvail);
            ps.setString(4, location);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String queryCustomerInfo(String name) {
        String info = "";
        String route = new String();
        String start = "";
        ArrayList<String> fromCities = new ArrayList<String>();
        ArrayList<String> arivCities = new ArrayList<String>();
        int i = 1;
        try {
            String word = "SELECT * FROM reservations where custName = ?";
            PreparedStatement ps = conn.prepareStatement(word);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int resvType = rs.getInt("resvType");
                if (resvType == 1) {
                    String flightNum = rs.getString("info");
                    FlightInfo flightInfo = queryFlightInfo(flightNum);
                    start = (start == ""? flightInfo.getFromCity() : start);
                    String subInfo = String.valueOf(i++) + ". booking a flights \"" +
                            flightNum + "\" from \"" + flightInfo.getFromCity() +
                            "\" to \"" + flightInfo.getArivCity() + "\"\n";
                    info += subInfo;
                    fromCities.add(flightInfo.getFromCity());
                    arivCities.add(flightInfo.getArivCity());
                }
                else if (resvType == 2) {
                    String location = rs.getString("info");
                    String subInfo = String.valueOf(i++) + ". booking a hotel in \"" +
                            location + "\"\n";
                    info += subInfo;
                }
                else if (resvType == 3) {
                    String location = rs.getString("info");
                    String subInfo = String.valueOf(i++) + ". booking a  bus in \"" +
                            location + "\"\n";
                    info += subInfo;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        route = getRoute(fromCities, arivCities);
        info += "\n" + route;
        return info;
    }

    private static String getRoute(ArrayList<String> fromCities, ArrayList<String> arivCities) {
        int size = fromCities.size();
        String route = "";
        if (size == 0)
            return route;
        String start = "", end = "";
        boolean flag = true;
        int cnt = 0;
        boolean[] vis = new boolean[size];
        for (int j = 0; j < size; j++) {
            if(!vis[j]) {
                if(j != 0)  route += "\n";
                String start1 = fromCities.get(j);
                int i = j;
                end = arivCities.get(i);
                route += "route" + ++cnt + ":\n";
                route += start1 + " ====> " + end + "\n";
                for (i = 0; i < fromCities.size(); i++) {
                    if(!vis[i]) {
                        start = fromCities.get(i);
                        if (start.equals(end)) {
                            vis[i] = true;
                            end = arivCities.get(i);
                            route += start + " ====> " + end + "\n";
                            i = 0;
                        }
                    }
                }
                if(!start1.equals(end))
                    flag = false;
            }
        }
        if(flag)
            route += "该路线完整";
        else
            route += "该路线不完整";
        return route;
    }
}