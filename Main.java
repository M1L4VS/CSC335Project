/**
 * Write a description of class Main here.
 * Use node class
 * @author Mila van Stokkum
 * @version v7 28/07/2023
 */

 public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the GUI
        GUI gui = new GUI();
        gui.setVisible(true);

        // Make the program wait to allow GUI to load
        Thread.sleep(1000);

        // Initialize the map
        Map map = new Map();

        // Set the map in the GUI and trigger repaint
        gui.setMap(map);
        gui.searchMap();
    }
}

 