package view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Ace Wheatley
 */
public class MenuFrame extends JFrame {
    
    private JPanel panel = new TitlePanel(this);
    
    public MenuFrame() {
        
        // Sets Initial Panel to TitlePanel
        this.getContentPane().add(panel);
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Sets Current Panel to TitlePanel
    public void openTitle() {
        
        this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        
        panel = new TitlePanel(this);
        
        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Sets Current Panel to CharacterSelectPanel
    public void openCharacterSelect() {
        
        this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        
        panel = new CharacterSelectPanel(this);
        
        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Sets Current Panel to LeaderboardPanel
    public void openLeaderboard() {
        
    }
    
    // Sets Current Panel to CreditsPanel
    public void openCredits() {
        
    }
    
    // Exits Program
    public void exitGame() {
        this.dispose();
    }
}
