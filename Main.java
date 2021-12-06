import java.util.concurrent.TimeUnit;

/**
 * File: Main.java
 * Author: weizhenhuan
 * Time: 2021/10/31 18:07
 **/
public class Main {
    private static final int max=30, min=25;

    public static void main(String[] args) throws InterruptedException {
        Gui gui = new Gui();
//        DatabaseManager databaseManager = new DatabaseManager();
//       for (int i = 0; i < 50; i++) {
//            int data1 = getData();
//            int data2 = getData();
//            int data3 = getData();
//            int data4 = getData();
//
//            DatabaseManager.addDianjiData(data1,data2,data3,data4);
//            TimeUnit.SECONDS.sleep(1);
//        }
//        for (int i = 0; i < 30; i++) {
//            int data = getData();
//            DatabaseManager.addFengjidianjiData(data);
//            TimeUnit.SECONDS.sleep(1);
//        }
//        for (int i = 0; i < 30; i++) {
//            int data = getData();
//            DatabaseManager.addFengjishanyeData(data);
//            TimeUnit.SECONDS.sleep(1);
//        }
//        for (int i = 0; i < 30; i++) {
//            int data = getData();
//            DatabaseManager.addJiansujiData(data);
//            TimeUnit.SECONDS.sleep(1);
//        }
//        for (int i = 0; i < 30; i++) {
//            int data = getData();
//            DatabaseManager.addQitaData(data);
//            TimeUnit.SECONDS.sleep(1);
//        }
    }

    private static int getData() {
        return (int) (Math.random()*(max-min)+min);
    }
}
