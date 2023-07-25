
/**
 * Write a description of class GUI here.
 * GUI class
 * @author Mila van Stokkum
 * @version v4 25/07/2023 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
    Search search = new Search();

    // class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JTextArea jTextArea;
    JPanel jPanel;
    MapUI mapUI;

    Map map;

    public GUI() {
        // get GUI window info

        setTitle("Dijkstra's Algorithm Simulation");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menu = new JMenu("Maps");
        menuBar.add(menu);

        // adding items
        menuItem = new JMenuItem("Random map");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('r'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Built in map");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('b'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Menu");
        menuBar.add(menu);

        menuItem = new JMenuItem("Instructions");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('i'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('e'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        Container container = getContentPane();

        mapUI = new MapUI();
        container.add(mapUI, BorderLayout.CENTER);

        jTextArea = new JTextArea(10, 20);
        jTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        container.add(scrollPane, BorderLayout.SOUTH);

        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // shortcuts guide
        printMessage("Click on menus to view shortcuts");

    }

    public void makeDialogBox(String boxString) {
        JDialog box = new JDialog(this);
        box.setBounds(200, 200, 350, 80);
        TextArea area = new TextArea(boxString);
        area.setEditable(false);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle("Pop up");
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Random map":
                printMessage("Using random map");
                map.useRandomMap();
                searchMap();
                break;
            case "Built in map":
                printMessage("Using built in map");
                map.useDefaultMap();
                searchMap();
                break;
            case "Instructions":
                printMessage("Instructions on pop up");
                makeDialogBox("Click in the Map menu to use random [r], or a built in one [b], or to exit [e]");
                break;
            case "Exit":
                System.exit(0);
                makeDialogBox("exiting Dijkstra's algorithm");
                break;
        }

    }

    public void setMap(Map map) {
        this.map = map;
        mapUI.setMap(map);
        repaint();
    }

    public void searchMap() {
        // clearing JTextArea each time you refresh
        jTextArea.selectAll();
        jTextArea.replaceSelection("");

        search.DijkstraSearch(map);
        printMessages(search.getMessageLog());
        repaint();

    }

    public void printMessage(String message) {
        jTextArea.append(message + "\n");
    }

    public void printMessages(ArrayList<String> messages){
        for(String message : messages){
            printMessage(message);
        }
    }
}
