import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: QueryFlightInfo.java
 * Author: LittleLittleWei
 * Time: 2021/11/2 15:11
 **/
public class QueryFlightInfo extends QueryPanel implements ActionListener {
    public QueryFlightInfo() {
        submit = new JButton("submit");
        back = new JButton("return");
        labels = new JLabel[6];
        textFields = new JTextField[6];

        labels[0] = new JLabel("flightNum");
        labels[1] = new JLabel("price");
        labels[2] = new JLabel("numSeats");
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
            if(i != 0) {
                textFields[i].setEditable(false);
            }
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
        Object source = e.getSource();
        if(source == submit) {
            String flightNum = textFields[0].getText();
            FlightInfo flightInfo = DatabaseManager.queryFlightInfo(flightNum);
            textFields[1].setText(String.valueOf(flightInfo.price));
            textFields[2].setText(String.valueOf(flightInfo.numSeats));
            textFields[3].setText(String.valueOf(flightInfo.numAvail));
            textFields[4].setText(String.valueOf(flightInfo.fromCity));
            textFields[5].setText(String.valueOf(flightInfo.arivCity));
        }
        else if(source == back) {

        }
    }
}
