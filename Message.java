import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: Message.java
 * Author: LittleLittleWei
 * Time: 2021/11/1 17:46
 **/
public class Message extends JFrame {
    static JLabel label;
    static Dialog dialog;
    JButton button;
    public Message() {
        label = new JLabel();
        button = new JButton("OK");
        dialog = new Dialog(this, "Message", true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        label.setHorizontalAlignment(0);
        button.setBounds(0,0,5,5);

        dialog.add(label);
        dialog.add(button);
        dialog.setLayout(new GridLayout(2,1));
        dialog.setBounds(700,300,20,120);
        dialog.setVisible(false);

        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void showInsertOKMessage() {
        label.setText("insert data successfully!");
        dialog.setVisible(true);
    }
    static void showInsertErrorMessage() {
        label.setText("insert data unsuccessfully!");
        dialog.setVisible(true);
    }
    static void showUpdateOKMessage() {
        label.setText("update data successfully!");
        dialog.setVisible(true);
    }
    static void showUpdateErrorMessage() {
        label.setText("update data unsuccessfully!");
        dialog.setVisible(true);
    }
}
