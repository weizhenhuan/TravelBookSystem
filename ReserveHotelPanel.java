import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: ReserveHotelPanel.java
 * Author: LittleLittleWei
 * Time: 2021/11/2 10:40
 **/
public class ReserveHotelPanel extends ReservePanel implements ActionListener {
    public ReserveHotelPanel() {
        submit = new JButton("submit");
        back = new JButton("return");
        labels = new JLabel[2];
        textFields = new JTextField[2];

        labels[0] = new JLabel("custName");
        textFields[0] = new JTextField();
        labels[1] = new JLabel("location");
        textFields[1] = new JTextField();

        for (int i = 0; i < 2; i++) {
            add(labels[i]);
            add(textFields[i]);
        }

        add(submit);
        add(back);

        setLayout(new GridLayout(4,2,30,20));

        submit.addActionListener(this);
        back.addActionListener(this);

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == submit) {
            String custName = textFields[0].getText();
            String location = textFields[1].getText();
            if(DatabaseManager.reserveHotel(custName, location)) {
                Message.showInsertOKMessage();
            }
            else {
                Message.showInsertErrorMessage();
            }
        }
        else if(source == back) {

        }
        for (int i = 0; i < 2; i++) {
            textFields[i].setText("");
        }
    }
}
