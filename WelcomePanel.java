import javax.swing.*;
import java.awt.*;

/**
 * File: WelcomePanel.java
 * Author: LittleLittleWei
 * Time: 2021/11/1 10:56
 **/
public class WelcomePanel extends Panel {
    JLabel label1 = new JLabel("------------------------------------------------------");
    JLabel label2 = new JLabel("* Welcome to Travel Booking System *");
    JLabel label3 = new JLabel("------------------------------------------------------");

    public WelcomePanel() {
        add(label1);
        add(label2);
        add(label3);
    }
}
