/**
 * File: Menu1.java
 * Author: LittleLittleWei
 * Time: 2021/10/31 19:12
 **/
public class Menu1 {
    static String helloMenu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("------------------------------------------\n");
        buffer.append("* welcome to my hotel reservation system*\n");
        buffer.append("------------------------------------------\n");
//        System.out.println(buffer.toString());
        return buffer.toString();
    }
    static void commandMenu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("请选择你要完成的功能");
        buffer.append("1、增加航班信息");
        buffer.append("2、增加大巴车信息");
        buffer.append("3、增加宾馆房间信息");
        buffer.append("4、增加客户信息");
        buffer.append("5、");
    }
}
