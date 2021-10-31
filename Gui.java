import com.sun.tools.jconsole.JConsoleContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: Gui.java
 * Author: LittleLittleWei
 * Time: 2021/10/31 19:29
 **/
public class Gui extends JFrame implements ActionListener {
    MenuBar menuBar;
    Menu addInfo, reservation, exit;
    MenuItem addFlight, addBus, addHotel;
    MenuItem bookFlight, bookBus, bookHotel;
    MenuItem exitItem;
    Panel contentPanel;

    public Gui() {
        //init MenuBar
        menuBar = new MenuBar();

        //init Menu
        addInfo = new Menu("add");
        reservation = new Menu("reservation");
        exit = new Menu("exit");

        //init MenuItem
        addFlight = new MenuItem("flight");
        addBus = new MenuItem("bus");
        addHotel = new MenuItem("hotel");
        bookFlight = new MenuItem("flight");
        bookBus = new MenuItem("bus");
        bookHotel = new MenuItem("hotel");
        exitItem = new MenuItem("exit");

        contentPanel = new Panel();

        //add action listener
        addFlight.addActionListener(this);
        addBus.addActionListener(this);
        addHotel.addActionListener(this);

        bookHotel.addActionListener(this);
        bookBus.addActionListener(this);
        bookFlight.addActionListener(this);

        exitItem.addActionListener(this);

        addInfo.add(addFlight);
        addInfo.add(addBus);
        addInfo.add(addHotel);
        reservation.add(bookBus);
        reservation.add(bookFlight);
        reservation.add(bookHotel);
        exit.add(exitItem);

        //menuBar add
        menuBar.add(addInfo);
        menuBar.add(reservation);
        menuBar.add(exit);

        JLabel label1 = new JLabel("------------------------------------------------------");
//        label1.setBounds(new Rectangle(10,20,14,50));
        label1.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel label2 = new JLabel("* Welcome to Travel Booking System *");
//        label2.setBounds(new Rectangle(500,120,14,50));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel label3 = new JLabel("------------------------------------------------------");
//        label1.setBounds(new Rectangle(10,20,14,50));
        label1.setHorizontalAlignment(SwingConstants.RIGHT);

        contentPanel.add(label1);
        contentPanel.add(label2);
        contentPanel.add(label3);
        contentPanel.setLayout(new GridLayout(3,1,20,10));

        add(contentPanel, BorderLayout.CENTER);
        setMenuBar(menuBar);
        setLayout(new FlowLayout());
        setTitle("Travel Booking System");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 400, 300);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == addHotel) {
//            showSpecificPanel(contentPanel, new MyPanel("add hotel information"));
            showSpecificPanel(contentPanel, new addFlightInfoPanel());
        }
        else if(source == exit)
            showSpecificPanel(new Panel(), contentPanel);

    }

    void showSpecificPanel(Panel contentPanel, Panel showPanel) {
        contentPanel.removeAll();
        contentPanel.add(showPanel);
        contentPanel.validate();
        contentPanel.repaint();
    }

    class MyPanel extends Panel {
        public MyPanel(String msg) {
            this.add(new JLabel(msg));
        }
    }
}
