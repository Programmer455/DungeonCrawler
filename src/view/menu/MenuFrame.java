package view.menu;

import cs321_team2.*;
import javax.swing.*;
import view.game.*;
import model.*;
import cs321_team2.*;

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
    
    public void openGame(PlayerCharacter pc) {
        Dungeon dungeon = new Dungeon(pc, 1);
        
        this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        
        DungeonFrame dungeonFrame = new DungeonFrame(pc, dungeon);
        dungeonFrame.setVisible(true);
        this.dispose();
    }
    
    // Exits Program
    public void exitGame() {
        this.dispose();
    }
    
    public void startBattle() {
        this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        
        panel = new Battle_Scene(this);
        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
        
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setTitle("Unnamed Dungeon Crawler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
