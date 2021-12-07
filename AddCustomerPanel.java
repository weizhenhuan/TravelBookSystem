import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: AddCustomerPanel.java
 * Author: LittleLittleWei
 * Time: 2021/11/2 21:07
 **/
public class AddCustomerPanel extends AddPanel implements ActionListener {
    public AddCustomerPanel() {
        submit = new JButton("submit");
        back = new JButton("update");
        labels = new JLabel[2];
        textFields = new JTextField[2];

        labels[0] = new JLabel("custName");
        labels[1] = new JLabel("custID");

        textFields[0] = new JTextField();
        textFields[1] = new JTextField();

        for (int i = 0; i < 2; i++) {
            add(labels[i]);
            add(textFields[i]);
        }
        setLayout(new GridLayout(4,2,30,20));
//        Button temp = new Button();
//        temp.setVisible(false);
//        add(temp);
        add(submit);
        add(back);
        submit.addActionListener(this);
        back.addActionListener(this);

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String custName = null;
        String custID = null;
        try {
            custName = textFields[0].getText();
            custID = textFields[1].getText();
        } catch (NumberFormatException numberFormatException) {
            Message.showInsertErrorMessage();
            return;
        }
        if(source == submit) {

            if(DatabaseManager.addCustomerInfo(custName, custID)) {
                Message.showInsertOKMessage();
            }
            else {
                Message.showInsertErrorMessage();
            }
        }
        else if(source == back) {
            if(DatabaseManager.updateCustomerInfo(custName, custID)) {
                Message.showUpdateOKMessage();
            }
            else {
                Message.showUpdateErrorMessage();
            }
        }
        for (int i = 0; i < 2; i++) {
            textFields[i].setText("");
        }
    }
}
