
/**
 * Write a description of class Map here.
 * Use node class
 * @author Mila van Stokkum
 * @version v6 20/07/2023
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

public void useRandomMap(){
    double numberOfNodes = Math.random()*100;
    numberOfNodes = (int)numberOfNodes;
    double numberOfLinks = Math.random()*5;
    numberOfLinks = (int)numberOfLinks;

    for (int i = 0; i < numberOfNodes; i++){
        int nodeName = 1; 
        int nextNodeName = 1; 
        String nodeNameString = Integer.toString(nodeName); 
        String nextNodeNameString = Integer.toString(nextNodeName);
        double x = Math.random()*500;
        x = (int)x; //does this turn them to ints?
        double y = Math.random()*500;
        y = (int)y;

        double xnn = Math.random()*500;
        xnn = (int)xnn; //does this turn them to ints?
        double ynn = Math.random()*500;
        ynn = (int)ynn;

        Node node = new Node(nodeNameString, x, y);
        Node nextNode = new Node(nextNodeNameString, xnn, ynn)
        nodes.add(node);
        nodeName++; 

        //should this be inside or outside? need nodes list to pick random ones from to make random links? 
        for (int j = 0; j < numberOfLinks; j++){
            double linkWeight = Math.random()*10;
            linkWeight = (int)linkWeight;
            node.addLink(new Link(node, nextNode, linkWeight));
        }
    }

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