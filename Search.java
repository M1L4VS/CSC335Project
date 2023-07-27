/**
 * Write a description of class Search here.
 * Use node class
 * @author Mila van Stokkum
 * @version v10 28/07/2023
 */
import java.util.ArrayList;

public class Search {

    //Track logic messages to print out for user
    private ArrayList<String> messageLog = new ArrayList<String>();

    public void DijkstraSearch(Map map){

        //Reset messages every search
        messageLog.clear();

        //Setting the start & end nodes
        Node startNode = map.startNode;
        Node endNode = map.endNode;

        //Start at the startNode, set it to a distance of 0 and add to queue
        startNode.setDistance(0);
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(startNode);

        int startToEndDistance = 0;

        //While there are still nodes to search 
        while(queue.size() > 0){

            //Get the first node in the queue, then remove it 
            Node currentNode = queue.get(0);
            queue.remove(0);

            //Which node is being currently looked at 
            printMessage("Visiting " + currentNode + " with distance " + currentNode.getDistance());

            //If we are at the end node, stop searching
            if(currentNode == endNode){
                printMessage("Reached end node!");
                startToEndDistance = currentNode.getDistance();
                break;
            }

            //Search through all links from the node
            for(Link link : currentNode.getLinks()){
                
                //Get the node at the end of the link
                Node nextNode = link.getEnd();

                //If the node is unvisited, set the distance and add to queue (they are all initially set to MAX_VALUE)
                if(nextNode.getDistance() == Integer.MAX_VALUE){
                    nextNode.setDistance(currentNode.getDistance() + link.getWeight());
                    nextNode.setPrevNode(currentNode);
                    queue.add(nextNode);
                    printMessage("Adding " + nextNode + " to the queue with distance " + nextNode.getDistance());
                }

                //If the node is already visited, see if this distance is shorter than the currently set distance
                else{
                    int distance = currentNode.getDistance() + link.getWeight();
                    if(distance < nextNode.getDistance()){
                        nextNode.setDistance(distance);
                        nextNode.setPrevNode(currentNode);
                        printMessage("Updating shortest total distance to " + nextNode + " is " + nextNode.getDistance());
                    }
                }
            }

        }

        //Total shortest distance for the path 
        printMessage("Shortest distance from " + startNode + " to " + endNode + " is " + startToEndDistance);

        //Track shortest path, backtrack, but fill from start so don't need to reverse
        Node currentNode = endNode;
        while(currentNode != null){
            map.shortestPath.add(0, currentNode);
            currentNode = currentNode.getPrevNode(); 
        }

        //Print out shortest path
        printMessage("Shortest path is: ");
        for(Node node : map.shortestPath){
            printMessage(node.getName());
        }
    }

    //Make all the System.out.printlns shorter 
    private void printMessage(String message){
        System.out.println(message);
        messageLog.add(message);
    }

    //Get all the printMessages 
    public ArrayList<String> getMessageLog(){
        return messageLog; 
    }

}