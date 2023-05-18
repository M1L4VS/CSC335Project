
/**
 * Write a description of class Node here.
 * Node class
 * @author Mila van Stokkum
 * @version v2 30/05/2023 -
 */

import java.util.ArrayList;

public class Node {
   private String _name;
   private int _distanceFromStart = Integer.MAX_VALUE;
   private ArrayList<Link> _adjacentNodes = new ArrayList<Link>();

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
      _adjacentNodes.add(link);
   }

   public String toString() {
      return _name;
   }
}