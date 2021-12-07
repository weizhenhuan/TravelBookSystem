import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: MainPanel.java
 * Author: LittleLittleWei
 * Time: 2021/10/31 19:29
 **/
public class MainPanel extends JFrame implements ActionListener {
    MenuBar menuBar;
    Menu addInfo, reserve, query, exit;
    MenuItem addFlight, addBus, addHotel, addCustomer;
    MenuItem reserveFlight, reserveBus, reserveHotel;
    MenuItem queryFlight, queryBus, queryHotel, queryCustomer;
    MenuItem exitItem;
    JPanel contentPanel;
    CardLayout c1 = new CardLayout();
    Message message = new Message();

    WelcomePanel welcomePanel = new WelcomePanel();
    AddFlightPanel addFlightInfoPanel = new AddFlightPanel();
    AddHotelPanel addHotelPanel = new AddHotelPanel();
    AddBusPanel addBusPanel = new AddBusPanel();
    ReserveFlightPanel reserveFlightPanel = new ReserveFlightPanel();
    ReserveBusPanel reserveBusPanel = new ReserveBusPanel();
    ReserveHotelPanel reserveHotelPanel = new ReserveHotelPanel();

    public MainPanel() {
        //init MenuBar
        menuBar = new MenuBar();

        //init Menu
        addInfo = new Menu("add / update");
        reserve = new Menu("reserve");
        query = new Menu("query");
        exit = new Menu("exit");

        //init MenuItem
        initMenuItem();

        contentPanel = new JPanel();

        //add action listener
        itemAddActionListener();

        addInfo.add(addFlight);
        addInfo.add(addBus);
        addInfo.add(addHotel);
        addInfo.add(addCustomer);
        reserve.add(reserveFlight);
        reserve.add(reserveHotel);
        reserve.add(reserveBus);
        query.add(queryFlight);
        query.add(queryHotel);
        query.add(queryBus);
        query.add(queryCustomer);
        exit.add(exitItem);

        //menuBar add
        menuBar.add(addInfo);
        menuBar.add(reserve);
        menuBar.add(query);
        menuBar.add(exit);

        addChildPanel();

        add(contentPanel, BorderLayout.CENTER);
        setMenuBar(menuBar);
        setTitle("Travel Booking System");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 300);
        setIconImage(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == addFlight) {
            c1.first(contentPanel);
            c1.next(contentPanel);
        }
        else if(source == addHotel) {
            c1.first(contentPanel);
            for (int i = 0; i < 2; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == addBus) {
            c1.first(contentPanel);
            for (int i = 0; i < 3; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == addCustomer) {
            c1.first(contentPanel);
            for (int i = 0; i < 4; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == reserveFlight) {
            c1.first(contentPanel);
            for (int i = 0; i < 5; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == reserveHotel) {
            c1.first(contentPanel);
            for (int i = 0; i < 6; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == reserveBus) {
            c1.first(contentPanel);
            for (int i = 0; i < 7; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == queryFlight) {
            c1.first(contentPanel);
            for (int i = 0; i < 8; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == queryHotel) {
            c1.first(contentPanel);
            for (int i = 0; i < 9; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == queryBus) {
            c1.first(contentPanel);
            for (int i = 0; i < 10; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == queryCustomer) {
            c1.first(contentPanel);
            for (int i = 0; i < 11; i++) {
                c1.next(contentPanel);
            }
        }
        else if(source == exitItem) {
            c1.first(contentPanel);
        }
    }

    public void changeContentPane(Container contentPane) {
        this.setContentPane(contentPane);
        this.revalidate();
    }

    void showSpecificPanel(Panel contentPanel, Panel showPanel) {
        contentPanel.removeAll();
        contentPanel.add(showPanel);
        contentPanel.validate();
        contentPanel.repaint();
    }

    private void initMenuItem() {
        addFlight = new MenuItem("flight");
        addBus = new MenuItem("bus");
        addHotel = new MenuItem("hotel");
        addCustomer = new MenuItem("customer");
        reserveFlight = new MenuItem("flight");
        reserveBus = new MenuItem("bus");
        reserveHotel = new MenuItem("hotel");
        queryFlight = new MenuItem("flight");
        queryBus = new MenuItem("bus");
        queryHotel = new MenuItem("hotel");
        queryCustomer = new MenuItem("customer");
        exitItem = new MenuItem("exit");
    }

    private void itemAddActionListener() {
        addFlight.addActionListener(this);
        addBus.addActionListener(this);
        addHotel.addActionListener(this);
        addCustomer.addActionListener(this);

        reserveHotel.addActionListener(this);
        reserveBus.addActionListener(this);
        reserveFlight.addActionListener(this);

        queryHotel.addActionListener(this);
        queryBus.addActionListener(this);
        queryFlight.addActionListener(this);
        queryCustomer.addActionListener(this);
        exitItem.addActionListener(this);
    }
    private void addChildPanel() {

//        contentPanel.add(new WelcomePanel());
//        contentPanel.add(new AddFlightInfoPanel(),"1");
//        contentPanel.add(new AddHotelPanel(),"2");
//        contentPanel.add(new AddBusPanel(),"3");
//        contentPanel.add(new ReserveFlightPanel(),"4");
//        contentPanel.add(new ReserveHotelPanel(),"5");
//        contentPanel.add(new ReserveBusPanel(),"6");
        contentPanel.add(welcomePanel);
        contentPanel.add(addFlightInfoPanel);
        contentPanel.add(addHotelPanel);
        contentPanel.add(addBusPanel);
        contentPanel.add(new AddCustomerPanel());
        contentPanel.add(reserveFlightPanel);
        contentPanel.add(reserveHotelPanel);
        contentPanel.add(reserveBusPanel);
        contentPanel.add(new QueryFlightInfo());
        contentPanel.add(new QueryHotelInfo());
        contentPanel.add(new QueryBusInfo());
        contentPanel.add(new QueryCustomerInfo());

        contentPanel.setLayout(c1);
    }
}
