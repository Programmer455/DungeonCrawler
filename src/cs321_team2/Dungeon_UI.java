/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

import javax.swing.*;

/**
 *
 * @author keani
 */
public class Dungeon_UI {
    Dungeon_UI(Dungeon test)
    {
        
        int tileX = 100;
        int tileY = 100;
        JPanel panel = new JPanel(); //creates a panel 
        panel.setLayout(null);
        JFrame frame = new JFrame("Dungeon");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        
        for(int a = 0; a < test.getX(); a++)
        {
            for(int b = 0; b < test.getY(); b++)
            {
                if("wall".equals(test.tilemap[a][b][test.getLevel()].getTileType()))
                {
                    ImageIcon icon1 = new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png");
                    JLabel label1 = new JLabel(icon1);
                    label1.setBounds(tileX, tileY, 100, 100);
                    panel.add(label1);
                    
                }
                
                if("floor".equals(test.tilemap[a][b][test.getLevel()].getTileType()))
                {
                    ImageIcon icon2 = new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png");
                    JLabel label2 = new JLabel(icon2);
                    label2.setBounds(tileX, tileY, 100, 100);
                    panel.add(label2);
                    
                }
                
                tileX = tileX + 100;

            }
            tileY = tileY + 100;
            tileX = 100;
            
        }
    }
    
    
}
