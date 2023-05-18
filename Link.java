/**
 * Write a description of class Link here.
 * Link class
 * @author Mila van Stokkum
 * @version v2 18/05/2023 
 */

public class Link{

    private Node _end;
    private int _weight;

    public Link(Node end, int weight) {
        _end = end;
        _weight = weight;
    }

    public Node getEnd(){
        return _end;
    }

    public int getWeight(){
        return _weight;
    }
}