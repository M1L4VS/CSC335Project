/**
 * Write a description of class Node here.
 * First version of Dijkstra's algorithm
 * @author Mila van Stokkum
 * @version v1 04/05/2023 - 
 */

 //Things to import so I can use Java 
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.KeyStroke.*;
import javax.swing.JDialog.*;
import java.awt.geom.*;

public class Node extends JFrame {

    private String nodeName;
    private int nodeNumber;
    private int numberOfNodes;

    public Node (String newName) {
       nodeName = newName;
    }

    public Node (int newNumber, String newName) {
        nodeName = newName;
        nodeNumber = newNumber;
     }

     public String returnName(){
        return nodeName();
     }

     public int returnNumber(){
        return nodeNumber();
     }

     public Node(int newNumber, String newName, int numberofNodes)
     {        
         nodeName = newName;
         nodeNumber = newNumber;
         numberOfNodes = numberOfNodes;
     }
}
