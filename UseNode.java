/**
 * Write a description of class UseNode here.
 * Use node class
 * @author Mila van Stokkum
 * @version v4 13/06/2023
 */
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.KeyStroke.*;
import javax.swing.JDialog.*;
import java.awt.geom.*;

import java.util.Scanner;

public class UseNode {
    Scanner keyboard = new Scanner(System.in);
    // private int numberOfNodes;
    // private String names[] = {"zero", "one", "two"};
    // private Node arrayOfNodes[]; // initialise the array

    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.setDistance(0);
        nodeA.addLink(new Link(nodeA, nodeB, 2));
        nodeA.addLink(new Link(nodeA, nodeC, 4));

        nodeB.addLink(new Link(nodeB, nodeC, 3));
        nodeB.addLink(new Link(nodeB, nodeD, 1));
        nodeB.addLink(new Link(nodeB, nodeE, 5));

        nodeC.addLink(new Link(nodeC, nodeD, 2));

        nodeD.addLink(new Link(nodeD, nodeE, 1));
        nodeD.addLink(new Link(nodeD, nodeF, 2));

        nodeE.addLink(new Link(nodeE, nodeF, 2));

        // Start at node A
        Node currentNode = nodeA;
        Node prevNode = null; 
        Node nextStartingNode = null;
        while (true) {

            // Print the current node
            //System.out.println(
                   // "Current node: " + currentNode.getName() + " Total distance: " + currentNode.getDistance());

            for (Link link : currentNode.getLinks()) {
                Node nextNode = link.getEnd();
                System.out.println("current node is: " + currentNode);
                System.out.println("testing link to: " + nextNode);
                int distance = currentNode.getDistance() + link.getWeight();
                System.out.println("total distance is: " + distance);
                if (distance < nextNode.getDistance()) {
                    nextNode.setDistance(distance);
                    //prevNode = currentNode; 
                    System.out.println("updating shortest total distance to: "  + nextNode + " to: " + nextNode.getDistance());
                }else{
                    System.out.println("distance from " + currentNode + " to " + nextNode + " was not shorter than the shortest distance to " + nextNode + " which was " + nextNode.getDistance() + ", from " + currentNode.getPrevNode());
                    //not right; make seperate method to get starting point node?
                    //if currentNode is A then prevNode will be null 
                    //is prev node necessary?
                }

                // Set the closest node as the next starting node
                if (nextStartingNode == null || nextNode.getDistance() < nextStartingNode.getDistance()) {
                    nextStartingNode = nextNode;
                    System.out.println("this was the shortest distance so far, updating shortest path to be from " + currentNode + " to " + nextStartingNode);
                }else{
                    System.out.println("this distance, " + nextNode.getDistance() + " was not shorter than the current shortest distance, " + nextStartingNode.getDistance() + " which was to " + nextStartingNode);

                }
            }
        

            System.out.println("have gone through all links from " + currentNode);
            System.out.println("shortest link path was from " + currentNode + " to " + nextStartingNode);
            currentNode = nextStartingNode;
            nextStartingNode = null;

            // If there are no more nodes to visit, break out of the loop
            if (currentNode == null) {
                System.out.println("No more nodes to visit");
                break;
            }
        }

        // System.out.println("how many nodes would you like ?");
        // System.out.println("making " + keyboard.nextInt() + " nodes");
        // numberOfNodes = keyboard.nextInt(); //add some catch for if they don't enter
        // a number
        // Node[] arrayOfNodes = new Node[numberOfNodes];
        // //Node nodeOne = new Node("h");
        // //System.out.println(nodeOne);
        // Node[] arrayOfNodes = new Node[numberOfNodes];

        // for(int i = 0; i < numberOfNodes; i++){
        // arrayOfNodes[i] = new Node(i, names[i], numberOfNodes);
        // }

        // for(int i = 0; i < numberOfNodes; i++){
        // System.out.println(arrayOfNodes[i].getName());
        // }

    }
}