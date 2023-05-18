/**
 * Write a description of class UseNode here.
 * First version of Dijkstra's algorithm
 * @author Mila van Stokkum
 * @version v1 04/05/2023 - 
 */
import java.util.Scanner;

public class UseNode {
    Scanner keyboard = new Scanner(System.in);
    private int numberOfNodes;
    private String names[] = {"zero", "one", "two"};
    private Node arrayOfNodes[]; //intailise the array
    
    public UseNode(){

        System.out.println("how many nodes would you like ?");
        System.out.println("making " + keyboard.nextInt() + " nodes");
        numberOfNodes = keyboard.nextInt(); //add some catch for if they don't enter a number
        Node[] arrayOfNodes = new Node[numberOfNodes];
        //Node nodeOne = new Node("h");
        //System.out.println(nodeOne);
        Node[] arrayOfNodes = new Node[numberOfNodes];
           
        for(int i = 0; i < numberOfNodes; i++){
            arrayOfNodes[i] = new Node(i, names[i], numberOfNodes);
        }
       
        for(int i = 0; i < numberOfNodes; i++){
            System.out.println(arrayOfNodes[i].getName());
        }

    }
}
