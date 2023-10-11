/**
 * Write a description of class Main here.
 * Use node class
 * @author Mila van Stokkum
 * @version v7 28/07/2023
 */

 public class Main{

    public static void main(String[] args) throws InterruptedException{

        //Initialise GUI window 
        GUI gui = new GUI(); 
        gui.setVisible(true);

        //Make the programme wait until loading up everything because BlueJ can't work with it as it was
        Thread.sleep(500);
        
        //Initialise map and create nodes & links
        Map map = new Map();
        
        //Add map to GUI and search it
        gui.setMap(map);
        gui.searchMap();        
    }

 }
 