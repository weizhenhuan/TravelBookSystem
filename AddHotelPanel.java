import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: AddHotelPanel.java
 * Author: LittleLittleWei
 * Time: 2021/11/1 22:03
 **/
public class AddHotelPanel extends AddPanel implements ActionListener {
    public AddHotelPanel() {
        submit = new JButton("submit");
        back = new JButton("update");
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
        String location = null;
        int price = 0;
        int numRooms = 0;
        int numAvail = 0;
        try {
            location = textFields[0].getText();
            price = Integer.parseInt(textFields[1].getText());
            numRooms = Integer.parseInt(textFields[2].getText());
            numAvail = Integer.parseInt(textFields[3].getText());
        } catch (NumberFormatException numberFormatException) {
            Message.showInsertErrorMessage();
            return;
        }
        if(source == submit) {
            if(DatabaseManager.addHotelInfo(location, price,
                    numRooms, numAvail)) {
                Message.showInsertOKMessage();
            }
            else {
                Message.showInsertErrorMessage();
            }
        }
        else if(source == back) {
            if(DatabaseManager.updateHotelInfo(location, price,
                    numRooms, numAvail)) {
                Message.showUpdateOKMessage();
            }
            else {
                Message.showUpdateErrorMessage();
            }
        }
        for (int i = 0; i < 4; i++) {
            textFields[i].setText("");
        }
    }
}
