/**
 * File: main.java
 * Author: LittleLittleWei
 * Time: 2021/10/31 18:07
 **/
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Menu1.helloMenu();
        Gui gui = new Gui();

//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            // 加载驱动类
//            Class.forName("com.mysql.jdbc.Driver");
//            long start = System.currentTimeMillis();
//
//            // 建立连接
//            conn = DriverManager.getConnection("jdbc:mysql://101.42.109.18:3306/database",
//                    "database", "123456");
//            long end = System.currentTimeMillis();
//            System.out.println(conn);
//            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");
//
//            // 创建Statement对象
//            stmt = conn.createStatement();
//
//            // 执行SQL语句
//            rs = stmt.executeQuery("select * from test");
//            System.out.println("id\tname\tage\tsex");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
//                        + "\t" + rs.getInt(3) + "\t" + rs.getInt(4));
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
