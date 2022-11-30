package view.game;

import cs321_team2.PlayerCharacter;
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
        
        this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        
        Battle_Scene panel = new Battle_Scene(this, pc, enemy);
        
        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
        Battle_Scene cb = new Battle_Scene(this, pc, enemy);
        this.getContentPane().add(cb);
        
        this.setSize(1200, 700);
        this.setResizable(false);
        cb.setVisible(true);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cb); */
        
    }
    
}
