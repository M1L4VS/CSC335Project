/**
 * Write a description of class Link here.
 * Link class
 * @author Mila van Stokkum
 * @version v3 13/06/2023 
 */

public class Link{

    private Node _end;
    private Node _start;
    private int _weight;

    public Link(Node start, Node end, int weight) {
        _start = start;
        _end = end;
        int length = calculateLength(start, end);
        _weight = weight * length;
    }

    public Node getStart(){
        return _start;
    }

    public Node getEnd(){
        return _end;
    }

    public int getWeight(){
        return _weight;
    }

    private int calculateLength(Node startNode, Node endNode){
        double length = (Math.sqrt((endNode.getXCo() - startNode.getXCo())^2 + (endNode.getYCo() - startNode.getYCo())^2));
        return (int)length; 
    }
}