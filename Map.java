
/**
 * Write a description of class Map here.
 * Use node class
 * @author Mila van Stokkum
 * @version v6 20/07/2023
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.IOException;
import java.io.File;

public class Map {

    public ArrayList<Node> nodes;
    public Node startNode;
    public Node endNode;
    public ArrayList<Node> shortestPath;
    public final int NODESDIM = 670;

    public Map() {
        nodes = new ArrayList<Node>();
        shortestPath = new ArrayList<Node>();
    }

    public void useDefaultMap() {

        nodes.clear();

        // Create map and fill with nodes and links

        Node nodeA = new Node("A", 50, 80);
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

    private int calculateLength(Node startNode, Node endNode) {
        double xDif = endNode.getXCo() - startNode.getXCo();
        double yDif = endNode.getYCo() - startNode.getYCo();
        double length = (Math.sqrt((xDif * xDif) + (yDif * yDif)));
        return (int) length;
    }

    public void useRandomMap() {
        nodes.clear();
        int numberOfNodes = (int) ((Math.random() * 200) + 100); //up to 200 nodes
        int numberOfLinks = 3; // random # between 1 and 3 

        for (int i = 0; i < numberOfNodes; i++) {
            String nodeNameString = Integer.toString(i);
            double nodeCoord = (Math.random() * NODESDIM + 10); 
            int x = (int) (nodeCoord);
            int y = (int) (nodeCoord);

            Node node = new Node(nodeNameString, x, y);
            nodes.add(node);

            if (i == 0){
                this.startNode = node;
            }
            if (i == numberOfNodes - 1){
                this.endNode = node;
            }
        }

        for (Node nodeStart : nodes) {
            TreeMap<Integer, Node> closestNodes = new TreeMap<Integer, Node>();

            for (Node nodeEnd : nodes) {
                if (nodeStart == nodeEnd) {
                    continue;
                }
                // calculate distance between the start and end nodes to find the nearest 3
                // nodes
                int distance = calculateLength(nodeStart, nodeEnd);
                closestNodes.put(distance, nodeEnd);
            }

            int linkCount = 0;
            for (Integer key : closestNodes.keySet()) {
                if (linkCount > numberOfLinks) {
                    break;
                }
                Node node = closestNodes.get(key);
                nodeStart.addLink(new Link(nodeStart, node, 1));
                linkCount++;
            }

        }

    }

    public void useCSVMap() {
        final String CSVMAPFILE = "node.csv";
        final int MAXLINES = 100; // change to be number of max nodes etc
        final int VALUESPERLINE = 3; // see if can change?

        File csvMapFile = new File(CSVMAPFILE);
        String CSVLines[] = new String[MAXLINES];
        String allValues[][] = new String[MAXLINES][VALUESPERLINE];
        int lineCount = 0;

        try {
            Scanner fileReader = new Scanner(csvMapFile);

            while (fileReader.hasNextLine() && lineCount < MAXLINES) {
                String line = fileReader.nextLine();
                CSVLines[lineCount] = line;
                lineCount++;
            }

            for (int i = 0; i < lineCount; i++) {
                String values[] = CSVLines[i].split(",");

                for (int j = 0; j < values.length; j++) {
                    System.out.println(values[j]);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}