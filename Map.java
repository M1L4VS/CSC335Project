
/**
 * Write a description of class Map here.
 * Use node class
 * @author Mila van Stokkum
 * @version v5 09/07/2023
 */

import java.util.ArrayList;
import java.util.Scanner; 
import java.io.IOException;
import java.io.File; 

public class Map {

    public ArrayList<Node> nodes;
    public Node startNode;
    public Node endNode;
    public ArrayList<Node> shortestPath;

    public Map() {
        nodes = new ArrayList<Node>();
        shortestPath = new ArrayList<Node>();
    }

    public void useDefaultMap() {

        // Create map and fill with nodes and links

        Node nodeA = new Node("A",  50, 80);
        nodes.add(nodeA);
        Node nodeB = new Node("B", 100, 120);
        nodes.add(nodeB);
        Node nodeC = new Node("C", 150, 130);
        nodes.add(nodeC);
        Node nodeD = new Node("D", 140, 70);
        nodes.add(nodeD);
        Node nodeE = new Node("E", 200, 100);
        nodes.add(nodeE);
        Node nodeF = new Node("F", 250, 200);
        nodes.add(nodeF);
        Node nodeG = new Node("G", 300, 120);
        nodes.add(nodeG);
        Node nodeH = new Node("H", 400, 300);
        nodes.add(nodeH);

        // Add links
        nodeA.addLink(new Link(nodeA, nodeB, 1));
        nodeA.addLink(new Link(nodeA, nodeC, 1));
        nodeA.addLink(new Link(nodeA, nodeD, 1));

        nodeB.addLink(new Link(nodeB, nodeD, 1));
        nodeB.addLink(new Link(nodeB, nodeF, 1));

        nodeC.addLink(new Link(nodeC, nodeD, 1));

        nodeD.addLink(new Link(nodeD, nodeE, 1));
        nodeD.addLink(new Link(nodeD, nodeF, 1));

        nodeE.addLink(new Link(nodeE, nodeF, 1));
        nodeE.addLink(new Link(nodeE, nodeG, 1));
        nodeE.addLink(new Link(nodeE, nodeH, 1));

        nodeF.addLink(new Link(nodeF, nodeG, 1));

        nodeG.addLink(new Link(nodeG, nodeH, 1));

        // set start and end nodes
        startNode = nodeA;
        endNode = nodeH;
    }

//     public void useCSVMap(){
//         final String CSVMAPFILE = "node.csv";
//         final int MAXLINES = 100; //change to be number of max nodes etc 
//         final int VALUESPERLINE = 3; //see if can change? 
       
//         File csvMapFile = new File(CSVMAPFILE);
//         String CSVLines[] = new String[MAXLINES];
//         String allValues[][] = new String[MAXLINES][VALUESPERLINE];
//         int lineCount = 0; 

//         try {
//             Scanner fileReader = new Scanner(csvMapFile);

//             while (fileReader.hasNextLine() && lineCount < MAXLINES){
//                 String line = fileReader.nextLine();
//                 CSVLines[lineCount] = line; 
//                 lineCount++; 
//             }

//             for(int i = 0; i < lineCount ; i++){
//                 String values[] = CSVLines[i].split(",");

//                 for(int j = 0; j < values.length; j++){
//                     System.out.println(values[j]);
//                 }
//             }

//         }catch (IOException e) {System.out.println(e);}
//     }



}