/**
 * Write a description of class GUI here.
 * GUI class
 * @author Mila van Stokkum
 * @version v2 18/07/2023 
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
    //class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    //Graphics variables
    int nodeWidth = 15; 
    int linkLength = 30; 

    Map map;

    public GUI() {

        //get GUI window info
       
        setTitle("Dijkstra's Algorithm Simulation");

        int xDim = 500;
       
        int yDim = 500;

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
        this.pack();

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

        menu = new JMenu("Nodes & Links");
        menuBar.add(menu);
        this.pack();

        //adding items
        menuItem = new JMenuItem("Add node");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('n'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Add link");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('l'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Remove node"); //am i coding ability to remove???
        menuItem.setAccelerator(KeyStroke.getKeyStroke('o'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Remove link"); //likewise
        menuItem.setAccelerator(KeyStroke.getKeyStroke('p'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Menu");
        menuBar.add(menu);
        this.pack();

        menuItem = new JMenuItem("Instructions");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('i'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('e'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

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
                makeDialogBox("Random map generated");
                break;
            case "Built in map" : System.out.println("Using built in map");
                makeDialogBox("Built in map generated");
                break;
            case "Add node" : System.out.println("Adding a node");
                makeDialogBox("Node added");
                break;
            case "Add link" : System.out.println("Adding a link");
                makeDialogBox("Link added");
                break;
            case "Remove node" : System.out.println("Removing a node");
                makeDialogBox("Node removed");
                break;
            case "Remove link" : System.out.println("Removing a link");
                makeDialogBox("Link removed");
                break;
            case "Instructions" : System.out.println("Click enter to run Dijkstra's algorithm simulation");
                makeDialogBox("Enjoy");
                break;
            case "Exit" : System.exit(0);
                makeDialogBox("exiting Dijkstra's algorithm");
                break;
        }
        
    }
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

    //    g2.setColor(Color.PINK);
    //    g2.drawString("node", 100, 100);
    //    g2.setColor(Color.MAGENTA);
    //    g2.drawOval(200, 200, 50, 50);
    //    g2.fillOval(200, 200, 50, 50);
    //    g2.setColor(Color.CYAN);
    //    Line2D line = new Line2D.Float(150, 150, 250, 250);
    //    g2.draw(line);

        for(Node node : map.nodes){
            int x = node.getXCo();
            int y = node.getYCo();

            for(Link link : node.getLinks()){
                Node endNode = link.getEnd();
                int eX = endNode.getXCo(); 
                int eY = endNode.getYCo();
                Color linkColor = Color.MAGENTA;

                if(map.shortestPath.contains(node) && map.shortestPath.contains(endNode)){
                    linkColor = Color.GREEN; 
                }

                g2.setColor(linkColor);
                Line2D line = new Line2D.Float(x, y, eX, eY);
                g2.draw(line);
            }

            Color nodeColor = Color.RED;

            if(node == map.startNode || node == map.endNode){
                nodeColor = Color.GREEN; 
            } else if(map.shortestPath.contains(node)){
                nodeColor = Color.BLUE;
            }
           
            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, nodeWidth, nodeWidth);
            g2.setColor(nodeColor);
            g2.fillOval(x, y, nodeWidth, nodeWidth);

        }

    }

    public void setMap(Map map){
        this.map = map; 
        this.repaint();
    }

}
