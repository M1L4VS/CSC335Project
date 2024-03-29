
/**
 * Write a description of class GUI here.
 * GUI class
 * @author Mila van Stokkum
 * @version v8 28/07/2023 
 */

//Imports needed
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//Add JFrame for graphics and ActionListener for events 
public class GUI extends JFrame implements ActionListener {

    //Make a new search 
    Search search = new Search();

    //JFrame variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JTextArea jTextArea;
    JPanel jPanel;
    MapUI mapUI;

    //Make a map 
    Map map;

    public GUI() {
        //Get GUI window info

        setTitle("Dijkstra's Algorithm Simulation");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);

        //Make maps menu
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menu = new JMenu("Maps");
        menuBar.add(menu);

        //Adding map items
        menuItem = new JMenuItem("Random map");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('r'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Built in map");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('b'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //Adding instructions and exit menu 
        menu = new JMenu("Menu");
        menuBar.add(menu);

        //Adding items to the menu 
        menuItem = new JMenuItem("Instructions");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('i'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('e'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //Make window 
        Container container = getContentPane();

        //Make map graphics 
        mapUI = new MapUI();
        container.add(mapUI, BorderLayout.CENTER);

        //Area on side of screen for algorithm logic messages 
        jTextArea = new JTextArea(10, 30);
        jTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        container.add(scrollPane, BorderLayout.EAST);

        //Pack everything and set to fit max size it can for the user's screen 
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Shortcuts guide
        printMessage("Click on menus to view shortcuts");

    }

    //Code for pop up box 
    public void makeDialogBox(String boxString) {
        JDialog box = new JDialog(this);
        box.setBounds(200, 200, 500, 100);
        TextArea area = new TextArea(boxString);
        area.setEditable(false);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle("Instructions 💡");
    }

    //Actions
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
                //Each case that could happen
            case "Random map":
               loadDefaultMap();
                break;
            case "Built in map":
                Map builtInMap = new Map();
                builtInMap.useBuiltInMap();
                setMap(builtInMap);
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

    //Loading default map
    public void loadDefaultMap(){
        Map newMap = new Map();
        newMap.useRandomMap(mapUI.getWidth(), mapUI.getHeight());
        setMap(newMap);
    }

    //Make the map
    private void setMap(Map newMap) {
        this.map = newMap;
        searchMap();
        mapUI.setMap(newMap);
        repaint();
    }

    //Search the map
    private void searchMap() {
        //Clearing JTextArea each time you refresh
        jTextArea.selectAll();
        jTextArea.replaceSelection("");
        search.DijkstraSearch(map);
        printMessages(search.getMessageLog());
        repaint();

    }

    //Make System.out.printlns neater
    public void printMessage(String message) {
        jTextArea.append(message + "\n");
    }

    //Print messages in JTextArea
    public void printMessages(ArrayList<String> messages){
        for(String message : messages){
            printMessage(message);
        }
    }
}
