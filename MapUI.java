/**
 * Write a description of class MapUI here.
 * MapUI class
 * @author Mila van Stokkum
 * @version v10 28/07/2023 
 */

//Imports needed
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class MapUI extends JPanel {

    // Get the map
    private Map map;

    // Graphics variables
    int nodeWidth = 15;
    int linkLength = 30;

    // Setting up graphics
    // Set and paint the map
    public void setMap(Map map) {
        this.map = map;
        this.repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        // If no map, return
        if (map == null)
            return;

        for (Node node : map.nodes) {
            int x = node.getXCo();
            int y = node.getYCo();

            // Draw links
            for (Link link : node.getLinks()) {
                Node endNode = link.getEnd();
                int eX = endNode.getXCo();
                int eY = endNode.getYCo();
                Color linkColor = new Color(171, 0, 171);
                int lineWidth = 1;

                // Green and thicker links if part of shortest path
                if (map.shortestPath.contains(node) && map.shortestPath.contains(endNode)
                        && endNode.getPrevNode() == node) {
                    lineWidth = 3;
                    linkColor = new Color(10, 196, 56);
                }

                g2.setColor(linkColor);
                Line2D line = new Line2D.Float(x, y, eX, eY);
                g2.setStroke(new BasicStroke(lineWidth));
                g2.draw(line);
            }
        }

        // Draw nodes
        for (Node node : map.nodes) {
            int x = node.getXCo();
            int y = node.getYCo();
            int textOffset = 8;
            int ovalOffset = nodeWidth / 2;
            Color nodeColor = new Color(242, 51, 89);
            g2.setStroke(new BasicStroke(3));

            // If start, end or part of shortest path, change accordingly
            if (node == map.startNode || node == map.endNode) {
                nodeColor = new Color(10, 196, 56);
            } else if (map.shortestPath.contains(node)) {
                nodeColor = new Color(4, 172, 209);
            } else {
                g2.setStroke(new BasicStroke(1));
            }

            // Make node in center of link end
            // Drawing names of each node above them
            int offsetX = x - ovalOffset;
            int offsetY = y - ovalOffset;
            g2.setColor(Color.BLACK);
            g2.drawOval(offsetX, offsetY, nodeWidth, nodeWidth);
            g2.setFont(new Font("Calibri", Font.BOLD, 15));
            g2.drawString(node.getName(), x - textOffset, y - textOffset);
            g2.setColor(nodeColor);
            g2.fillOval(offsetX, offsetY, nodeWidth, nodeWidth);

        }

    }
}
