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
        _weight = weight;
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
}