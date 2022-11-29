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
        
        this.getContentPane().add(panel);
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
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
    
    public void openLeaderboard() {
        
    }
    
    public void openCredits() {
        
    }
    
    public void exitGame() {
        this.dispose();
    }
}
