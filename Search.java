/**
 * Write a description of class Search here.
 * Use node class
 * @author Mila van Stokkum
 * @version v5 09/07/2023
 */
import java.util.ArrayList;

public class Search {

    private ArrayList<String> messageLog = new ArrayList<String>();

    public void DijkstraSearch(Map map){

        messageLog.clear();

        //Setting the start & end nodes
        Node startNode = map.startNode;
        Node endNode = map.endNode;

        //Start at the startNode, set it to a distance of 0 and add to queue
        startNode.setDistance(0);
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(startNode);

        int startToEndDistance = 0;

        while(queue.size() > 0){

            //Get the first node in the queue
            Node currentNode = queue.get(0);
            queue.remove(0);

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

        printMessage("Shortest distance from " + startNode + " to " + endNode + " is " + startToEndDistance);

        //Track shortest path, backtrack, but fill from start so don't need to reverse
        Node currentNode = endNode;
        while(currentNode != null){
            map.shortestPath.add(0, currentNode);
            currentNode = currentNode.getPrevNode(); //wrong? seems to print too many out for shortest
        }

        //Print out shortest path
        printMessage("Shortest path is: ");
        for(Node node : map.shortestPath){
            printMessage(node.getName());
        }
    }

    private void printMessage(String message){
        System.out.println(message);
        messageLog.add(message);
    }

    public ArrayList<String> getMessageLog(){
        return messageLog; 
    }

}