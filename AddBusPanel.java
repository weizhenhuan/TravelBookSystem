import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: AddBusPanel.java
 * Author: LittleLittleWei
 * Time: 2021/11/1 22:25
 **/
public class AddBusPanel extends AddPanel implements ActionListener {
    public AddBusPanel() {
        submit = new JButton("submit");
        back = new JButton("update");
        labels = new JLabel[4];
        textFields = new JTextField[4];

        labels[0] = new JLabel("location");
        labels[1] = new JLabel("price");
        labels[2] = new JLabel("numBus");
        labels[3] = new JLabel("numAvail");

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
        String location = textFields[0].getText();
        int price = Integer.parseInt(textFields[1].getText());
        int numBus = Integer.parseInt(textFields[2].getText());
        int numAvail = Integer.parseInt(textFields[3].getText());

        if(source == submit) {
            if(DatabaseManager.addBusInfo(location, price,
                    numBus, numAvail)) {
                Message.showInsertOKMessage();
            }
            else {
                Message.showInsertErrorMessage();
            }
        }
        else if(source == back) {
            if(DatabaseManager.updateBusInfo(location, price,
                    numBus, numAvail)) {
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
