/**
 * Write a description of class GUI here.
 * GUI class
 * @author Mila van Stokkum
 * @version v3 18/07/2023 
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.KeyStroke.*;
import javax.swing.JDialog.*;
import java.awt.geom.*;

public class GUI extends JFrame implements ActionListener
{
    Search search = new Search();
    
    //class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JTextArea jTextArea;
    JPanel jPanel;
    MapUI mapUI;
    public final int NODESDIM = 700;

    Map map;

    public GUI()  {
        //get GUI window info
       
        setTitle("Dijkstra's Algorithm Simulation");
        int xDim = 800;
        int yDim = 800;

        //shortcuts guide
        System.out.println("Click on menus to view shortcuts");

        this.getContentPane().setPreferredSize(new Dimension(xDim, yDim)); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menu = new JMenu("Maps");
        menuBar.add(menu);

        //adding items
        menuItem = new JMenuItem("Random map");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('r'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Built in map");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('b'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //ADD CSV IMPORT OPTION HERE? 

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

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;

        jPanel = new JPanel(new GridBagLayout());
        add(jPanel);
        jPanel.setBackground(Color.BLUE);

        mapUI = new MapUI();
        mapUI.setPreferredSize(new Dimension(NODESDIM, NODESDIM));
        jPanel.add(mapUI, c);

        jTextArea = new JTextArea(10, 20);
        //jPanel.add(jTextArea, c);

        this.pack();   
    }

    public void makeDialogBox(String boxString){
        JDialog box = new JDialog(this);
        box.setBounds(200, 200, 250, 150);
        TextArea area = new TextArea(boxString);
        area.setEditable(false);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle("Pop up");
    }


    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();


        switch(cmd){
            case "Random map" : System.out.println("Using random map");
                //makeDialogBox("Random map generated");
                map.useRandomMap();
                search.DijkstraSearch(map);
                repaint();
                break;
            case "Built in map" : System.out.println("Using built in map");
                //makeDialogBox("Built in map generated");
                map.useDefaultMap();
                search.DijkstraSearch(map);
                repaint();
                break;
            case "Instructions" : System.out.println("Click enter to run Dijkstra's algorithm simulation");
                makeDialogBox("Enjoy");
                break;
            case "Exit" : System.exit(0);
                makeDialogBox("exiting Dijkstra's algorithm");
                break;
        }
        
    }
    
public void setMap(Map map){
        this.map = map; 
        mapUI.setMap(map);
        repaint();
    }
}
