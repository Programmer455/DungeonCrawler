package view.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import cs321_team2.*;

/**
 *
 * @author Keenan Coleman
 */
public class DungeonFrame extends JFrame {
    
    public DungeonFrame(PlayerCharacter pc, Dungeon dungeon) {
        
        this.getContentPane().add(new DungeonPanel(this, pc, dungeon));
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setFocusable(true);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void openCombat(PlayerCharacter pc, Enemy enemy) {
        
    }
    
}
