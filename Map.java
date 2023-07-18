
/**
 * Write a description of class Map here.
 * Use node class
 * @author Mila van Stokkum
 * @version v5 09/07/2023
 */

import java.util.ArrayList;

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

        Node nodeA = new Node("A", 15, 50);
        nodes.add(nodeA);
        Node nodeB = new Node("B", 35, 45);
        nodes.add(nodeB);
        Node nodeC = new Node("C", 35, 75);
        nodes.add(nodeC);
        Node nodeD = new Node("D", 55, 50);
        nodes.add(nodeD);
        Node nodeE = new Node("E", 65, 60);
        nodes.add(nodeE);
        Node nodeF = new Node("F", 85, 35);
        nodes.add(nodeF);
        Node nodeG = new Node("G", 100, 75);
        nodes.add(nodeG);
        Node nodeH = new Node("H", 120, 50);
        nodes.add(nodeH);

        // Add links
        nodeA.addLink(new Link(nodeA, nodeB, 2));
        nodeA.addLink(new Link(nodeA, nodeC, 3));
        nodeA.addLink(new Link(nodeA, nodeD, 7));

        nodeB.addLink(new Link(nodeB, nodeD, 1));
        nodeB.addLink(new Link(nodeB, nodeF, 11));

        nodeC.addLink(new Link(nodeC, nodeD, 2));

        nodeD.addLink(new Link(nodeD, nodeE, 5));
        nodeD.addLink(new Link(nodeD, nodeF, 9));

        nodeE.addLink(new Link(nodeE, nodeF, 2));
        nodeE.addLink(new Link(nodeE, nodeG, 6));
        nodeE.addLink(new Link(nodeE, nodeH, 3));

        nodeF.addLink(new Link(nodeF, nodeG, 1));

        nodeG.addLink(new Link(nodeG, nodeH, 8));

        // set start and end nodes
        startNode = nodeA;
        endNode = nodeH;
    }

}