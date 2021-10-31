import javax.swing.*;
import java.awt.*;

/**
 * File: addFlightInfoPanel.java
 * Author: LittleLittleWei
 * Time: 2021/10/31 21:35
 **/
public class addFlightInfoPanel extends Panel {
    JButton button;
    JLabel[] labels;
    JTextField[] textFields;
    public addFlightInfoPanel() {
        button = new JButton("submit");
        labels = new JLabel[6];
        textFields = new JTextField[6];

        labels[0] = new JLabel("flightNum");
        labels[1] = new JLabel("price");
        labels[2] = new JLabel("sumSeats");
        labels[3] = new JLabel("numAvail");
        labels[4] = new JLabel("FromCity");
        labels[5] = new JLabel("ArivCity");


//        textFields[0] = new JTextField();
//        textFields[1] = new JTextField();
//        textFields[2] = new JTextField();
//        textFields[3] = new JTextField();
//        textFields[4] = new JTextField();
//        textFields[5] = new JTextField();

        for (int i = 0; i < 3; i++) {
//            labels[i].setBounds(i * 20,20, 20, 10);
            labels[i].setHorizontalAlignment(SwingConstants.RIGHT);

            this.add(labels[i]);
//            add(textFields[i]);
        }

        setLayout(new FlowLayout());
        setVisible(true);
        setBounds(500, 500, 400, 300);

    }


}
