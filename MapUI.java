/**
 * Write a description of class MapUI here.
 * MapUI class
 * @author Mila van Stokkum
 * @version v2 20/07/2023 
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class MapUI extends JPanel {
    
    private Map map;
    
    //Graphics variables
    int nodeWidth = 15; 
    int linkLength = 30; 
    
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for(Node node : map.nodes){ //ERROR COMES UP FOR THIS LINE
            int x = node.getXCo();
            int y = node.getYCo();
            int textOffset = 5; 

            for(Link link : node.getLinks()){
                Node endNode = link.getEnd();
                int eX = endNode.getXCo(); 
                int eY = endNode.getYCo();
                Color linkColor = new Color(171, 0, 171);
                int lineWidth = 1;

                if(map.shortestPath.contains(node) && map.shortestPath.contains(endNode)){
                    lineWidth = 2; 
                    linkColor = new Color(10, 196, 56); 
                }

                g2.setColor(linkColor);
                Line2D line = new Line2D.Float(x, y, eX, eY);
                g2.setStroke(new BasicStroke(lineWidth));
                g2.draw(line);
            }

            Color nodeColor = new Color(242, 51, 89);


            if(node == map.startNode || node == map.endNode){
                nodeColor = new Color(10, 196, 56);
            } else if(map.shortestPath.contains(node)){
                nodeColor = new Color(4, 172, 209);
            }
           
            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, nodeWidth, nodeWidth);
            //g2.drawRect(x, y, nodeWidth, nodeWidth);
            g2.drawString(node.getName(), x - textOffset, y - textOffset);
            g2.setColor(nodeColor);
            g2.fillOval(x, y, nodeWidth, nodeWidth);
            //g2.fillRect(x, y, nodeWidth, nodeWidth);

        }
    }

    public void setMap(Map map){
        this.map = map; 
        this.repaint();
    }    
}