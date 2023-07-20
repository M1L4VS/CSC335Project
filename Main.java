/**
 * Write a description of class Main here.
 * Use node class
 * @author Mila van Stokkum
 * @version v5 09/07/2023
 */

 public class Main{

    public static void main(String[] args){

        //Initialise GUI window 
        GUI gui = new GUI(); 
        gui.setVisible(true);

        //Initialise map and create nodes & links
        Map map = new Map();
        map.useRandomMap();
        gui.setMap(map);

        //Create the search object, and run it on the map
        Search search = new Search();
        search.DijkstraSearch(map);

    }

 }
 