import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: QueryHotelInfo.java
 * Author: LittleLittleWei
 * Time: 2021/11/2 15:04
 **/
public class QueryHotelInfo extends QueryPanel implements ActionListener {
    public QueryHotelInfo() {
        submit = new JButton("submit");
        back = new JButton("return");
        labels = new JLabel[4];
        textFields = new JTextField[4];

        labels[0] = new JLabel("location", JLabel.RIGHT);
        labels[1] = new JLabel("price", JLabel.RIGHT);
        labels[2] = new JLabel("numRooms", JLabel.RIGHT);
        labels[3] = new JLabel("numAvail", JLabel.RIGHT);

        textFields[0] = new JTextField();
        textFields[1] = new JTextField();
        textFields[2] = new JTextField();
        textFields[3] = new JTextField();

        for (int i = 0; i < 4; i++) {
            add(labels[i]);
            add(textFields[i]);
            if(i != 0) {
                textFields[i].setEditable(false);
            }
        }
        setLayout(new GridLayout(3,2,30,20));
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
            String location = textFields[0].getText();
            HotelInfo hotelInfo = DatabaseManager.queryHotelInfo(location);
            textFields[1].setText(String.valueOf(hotelInfo.price));
            textFields[2].setText(String.valueOf(hotelInfo.numRooms));
            textFields[3].setText(String.valueOf(hotelInfo.numAvail));
        }
        else if(source == back) {

        }
    }
}
