/**
 * Write a description of class Link here.
 * Link class
 * @author Mila van Stokkum
 * @version v6 28/07/2023 
 */

public class Link{

    //Node variables
    private Node _end;
    private Node _start;
    private int _weight;

    //Create links with a start and end, weight is the distance 
    public Link(Node start, Node end) {
        _start = start;
        _end = end;
        _weight = calculateLength(start, end);
    }

    //Getters and setters needed for links 
    public Node getStart(){
        return _start;
    }

    public Node getEnd(){
        return _end;
    }

    public int getWeight(){
        return _weight;
    }

    //Uses pythagoras to calculate weight; distance
    private int calculateLength(Node startNode, Node endNode){
        double xDif = endNode.getXCo() - startNode.getXCo();
        double yDif = endNode.getYCo() - startNode.getYCo();
        double length = (Math.sqrt((xDif * xDif) + (yDif * yDif)));        
        return (int)length; 
    }
}