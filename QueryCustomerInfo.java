import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: QueryCustomerInfo.java
 * Author: LittleLittleWei
 * Time: 2021/12/5 23:22
 **/
public class QueryCustomerInfo extends JPanel implements ActionListener {
    JButton submit;
    JLabel label;
    JTextField textField;
    JTextArea textArea;
    JPanel[] panels;
    JScrollPane scrollPane;

    public  QueryCustomerInfo() {
        panels = new JPanel[3];
        for(int i = 0; i < 3; i++)
            panels[i] = new JPanel();

        submit = new JButton("submit");
        label = new JLabel("name");
        textField = new JTextField(10);
        textArea = new JTextArea(10,30);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panels[0].add(label);
        panels[0].add(textField);
        panels[0].add(submit);
        panels[1].add(scrollPane);
        for(int i = 0; i < 2; i++)
            add(panels[i]);

        submit.addActionListener(this);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String name = textField.getText();
        if(source == submit) {
            String info = DatabaseManager.queryCustomerInfo(name);
            textArea.setText(info);
        }
    }
}
