/**
 * Write a description of class Node here.
 * Use node class
 * @author Mila van Stokkum
 * @version v5 09/07/2023
 */

 import java.util.ArrayList;

 public class Node {
    private String _name;
    private Node _prevNode;
    private int _xCo;
    private int _yCo;
    private int _distanceFromStart = Integer.MAX_VALUE;
    private ArrayList<Link> _adjacentLinks = new ArrayList<Link>();

    public Node(String newName) {
       _name = newName;
    }
 
    public String getName() {
       return _name;
    }
 
    public void setDistance(int distance) {
       _distanceFromStart = distance;
    }
 
    public int getDistance() {
       return _distanceFromStart;
    }
 
    public void addLink(Link link) {
       _adjacentLinks.add(link);
    }
 
    public ArrayList<Link> getLinks() {
       return _adjacentLinks;
    }
 
    public String toString() {
       return _name;
    }
    
    public void setPrevNode(Node prevNode){
      _prevNode = prevNode;
    }

    public Node getPrevNode(){
      return _prevNode;
    }

   //assign coordinates to all nodes 

    public void setXCo(int xCo){
         _xCo = xCo; 
    }

    public int getXCo(){
      return _xCo; 
    }

    public void setYCo(int yCo){
         _yCo = yCo; 
    }

    public int getYCo(){
      return _yCo; 
    }

 }