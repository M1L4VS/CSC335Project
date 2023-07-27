/**
 * Write a description of class Node here.
 * Use node class
 * @author Mila van Stokkum
 * @version v8 28/07/2023
 */

 //Imports needed
 import java.util.ArrayList;

 public class Node {

   //Node variables 
    private String _name;
    private Node _prevNode;
    private int _xCo;
    private int _yCo;
    private int _distanceFromStart = Integer.MAX_VALUE;
    private ArrayList<Link> _adjacentLinks = new ArrayList<Link>();

    //Make all nodes with a name and coordinates 
    public Node(String newName, int xCo, int yCo) {
       _name = newName;
       _xCo = xCo;
       _yCo = yCo;  
    }
 
    //All the getters and setters for nodes

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

    public int getXCo(){
      return _xCo; 
    }
    
    public int getYCo(){
      return _yCo; 
    }

 }