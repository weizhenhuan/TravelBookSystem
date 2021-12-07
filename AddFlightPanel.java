import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: addFlightInfoPanel.java
 * Author: LittleLittleWei
 * Time: 2021/10/31 21:35
 **/
public class AddFlightPanel extends AddPanel implements ActionListener {
    public AddFlightPanel() {
        submit = new JButton("submit");
        back = new JButton("update");
        labels = new JLabel[6];
        textFields = new JTextField[6];

        labels[0] = new JLabel("flightNum");
        labels[1] = new JLabel("price");
        labels[2] = new JLabel("sumSeats");
        labels[3] = new JLabel("numAvail");
        labels[4] = new JLabel("FromCity");
        labels[5] = new JLabel("ArivCity");

        textFields[0] = new JTextField();
        textFields[1] = new JTextField();
        textFields[2] = new JTextField();
        textFields[3] = new JTextField();
        textFields[4] = new JTextField();
        textFields[5] = new JTextField();

        for (int i = 0; i < 6; i++) {
            add(labels[i]);
            add(textFields[i]);
        }
        setLayout(new GridLayout(4,1,30,20));
        Button temp = new Button();
        temp.setVisible(false);
        add(temp);
        add(submit);
        add(back);

        submit.addActionListener(this);
        back.addActionListener(this);

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String flightNum = "null";
        int price = 0;
        int numSeats = 0;
        int numAvail = 0;
        String fromCity = "null";
        String arivCity = "null";
        Object source = e.getSource();
        try {
            flightNum = textFields[0].getText();
            price = Integer.parseInt(textFields[1].getText());
            numSeats = Integer.parseInt(textFields[2].getText());
            numAvail = Integer.parseInt(textFields[3].getText());
            fromCity = textFields[4].getText();
            arivCity = textFields[5].getText();
        } catch (NumberFormatException numberFormatException) {
            Message.showInsertErrorMessage();
            return;
        };

        if(source == submit) {
            if(DatabaseManager.addFlightInfo(flightNum, price,
                    numSeats, numAvail, fromCity, arivCity)) {
                Message.showInsertOKMessage();
            }
            else {
                Message.showInsertErrorMessage();
            }
        }
        else if(source == back) {
            if(DatabaseManager.updateFlightInfo(flightNum, price,
                    numSeats, numAvail, fromCity, arivCity)) {
                Message.showUpdateOKMessage();
            }
            else {
                Message.showUpdateErrorMessage();
            }
        }
        for (int i = 0; i < 6; i++) {
            textFields[i].setText("");
        }

    }
}
