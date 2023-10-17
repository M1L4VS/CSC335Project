/**
 * Write a description of class Map here.
 * Use node class
 * @author Mila van Stokkum
 * @version v11 28/07/2023
 */

 //Imports needed 
import java.util.ArrayList;
import java.util.TreeMap;

public class Map {

    //Node variables 
    public ArrayList<Node> nodes;
    public Node startNode;
    public Node endNode;
    public ArrayList<Node> shortestPath;

    //Reset the screen each time 
    public Map() {
        clearMap();
    }

    //Specifics of resetting the map
    public void clearMap() {
        nodes = new ArrayList<Node>();
        shortestPath = new ArrayList<Node>();
        startNode = null;
        endNode = null;
    }

    //Built in map option 
    public void useBuiltInMap() {

        clearMap();

        //Create map and fill with nodes and links

        Node nodeA = new Node("0", 50, 80);
        nodes.add(nodeA);
        Node nodeB = new Node("1", 100, 120);
        nodes.add(nodeB);
        Node nodeC = new Node("2", 150, 130);
        nodes.add(nodeC);
        Node nodeD = new Node("3", 140, 70);
        nodes.add(nodeD);
        Node nodeE = new Node("4", 200, 100);
        nodes.add(nodeE);
        Node nodeF = new Node("5", 250, 200);
        nodes.add(nodeF);
        Node nodeG = new Node("6", 300, 120);
        nodes.add(nodeG);
        Node nodeH = new Node("7", 400, 300);
        nodes.add(nodeH);

        //Add links
        nodeA.addLink(new Link(nodeA, nodeB));
        nodeA.addLink(new Link(nodeA, nodeC));
        nodeA.addLink(new Link(nodeA, nodeD));

        nodeB.addLink(new Link(nodeB, nodeD));
        nodeB.addLink(new Link(nodeB, nodeF));

        nodeC.addLink(new Link(nodeC, nodeD));

        nodeD.addLink(new Link(nodeD, nodeE));
        nodeD.addLink(new Link(nodeD, nodeF));

        nodeE.addLink(new Link(nodeE, nodeF));
        nodeE.addLink(new Link(nodeE, nodeG));
        nodeE.addLink(new Link(nodeE, nodeH));

        nodeF.addLink(new Link(nodeF, nodeG));

        nodeG.addLink(new Link(nodeG, nodeH));

        //Set start and end nodes
        startNode = nodeA;
        endNode = nodeH;
    }

    //Use pythagoras to calculate distance or weight of each link between nodes
    private int calculateLength(Node startNode, Node endNode) {
        double xDif = endNode.getXCo() - startNode.getXCo();
        double yDif = endNode.getYCo() - startNode.getYCo();
        double length = (Math.sqrt(Math.abs(xDif * -xDif) + Math.abs(yDif * yDif)));
        return (int) length;
    }

    //Don't let the nodes be generated too close together 
    private boolean isNearExistingNode(Node newNode) {
        for (Node node : nodes) {
            double distance = calculateLength(node, newNode);
            if (distance < 30) {
                return true;
            }
        }
        return false;
    }

    //Random generated map option 
    public void useRandomMap(int width, int height) {
        clearMap();
        int numberOfNodes = (int) ((Math.random() * 295) + 5); //Up to 300 nodes, always got at least 5 nodes
        int numberOfLinks = 3; //3 links for each node 

        for (int i = 0; i < numberOfNodes; i++) {
            
            //To center it with a border around the edge for space
            int widthBuffer = (int) (width * 0.025);
            int heightBuffer = (int) (height * 0.025);
            int x = (int) (Math.random() * (width * 0.95) + widthBuffer);
            int y = (int) (Math.random() * (height * 0.95) + heightBuffer);

            //Make the node
            Node node = new Node(Integer.toString(i), x, y);
            
            //Check it's not too close to other nodes
            if(isNearExistingNode(node)) {
                i--; //Regenerate this node (go back a step)
                continue;
            }
            
            //Add this node to the map
            nodes.add(node);

            //Setting start and end nodes 
            if(i == 0){
                this.startNode = node;
            }
            if(i == numberOfNodes - 1){
                this.endNode = node;
            }
        }

        //Going through every node for each node to find 3 closest ones
        for (Node nodeStart : nodes) {

            //Treemap sort acsendingly so can take first 3 values to get closest 3 nodes
            TreeMap<Integer, Node> closestNodes = new TreeMap<Integer, Node>();

            //Don't make a link between a node and itself 
            for (Node nodeEnd : nodes) {
                if (nodeStart == nodeEnd) {
                    continue;
                }
                
                //Calculate distance between the current start and current end node
                int distance = calculateLength(nodeStart, nodeEnd);
                closestNodes.put(distance, nodeEnd); //Adding to Treemap
            }

            int linkCount = 0;
            //Get 3 first values in Treemap - 3 closest nodes to link to 
            for (Integer key : closestNodes.keySet()) {
                //If we already have 3 links, don't find any more 
                if (linkCount > numberOfLinks) {
                    break;
                }
                //Key is the distance
                Node node = closestNodes.get(key);
                //Add a link going both ways to eliminate islands or pockets of disconnected nodes, can always reach end node
                nodeStart.addLink(new Link(nodeStart, node));
                node.addLink(new Link(node, nodeStart));
                linkCount++;
            }

        }

    }

}