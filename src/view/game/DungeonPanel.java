package view.game;

import cs321_team2.PlayerCharacter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import cs321_team2.Dungeon;
import cs321_team2.Enemy;

/**
 *
 * @author Keenan Coleman
 */

public class DungeonPanel extends JPanel {
    
    private final DungeonFrame parentFrame;
    
    private final PlayerCharacter pc;
    private final Dungeon dungeon;
    
    private final JLabel grid[][] = new JLabel[24][16];
    
    public DungeonPanel(DungeonFrame parentFrame, PlayerCharacter pc, Dungeon dungeon) {
        
        this.parentFrame = parentFrame;
        this.pc = pc;
        this.dungeon = dungeon;
        
        this.setLayout(new GridLayout(16, 24));
        
        loadDungeon();
        
        parentFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Do Nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].getTileType()) {
                            case "grass" -> {
                                dungeon.moveEnemies(pc);
                                reloadDungeon();
                                
                                switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].getTileType()) {
                                    case "grass" -> {
                                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("grass");
                                        dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].setTileType("player");
                                        pc.setPos(pc.getPosX(), pc.getPosY() - 1);
                                        reloadDungeon();
                                    }
                                    case "goblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Goblin"));
                                    }
                                    case "hobgoblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                                    }
                                    case "door" -> {
                                        // Level Up
                                    }
                                }
                            }
                            case "goblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Goblin"));
                            }
                            case "hobgoblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                            }
                            case "door" -> {
                                // Level Up
                            }
                        }
                    }
                    case KeyEvent.VK_DOWN -> {
                        switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].getTileType()) {
                            case "grass" -> {
                                dungeon.moveEnemies(pc);
                                reloadDungeon();
                                
                                switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].getTileType()) {
                                    case "grass" -> {
                                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("grass");
                                        dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].setTileType("player");
                                        pc.setPos(pc.getPosX(), pc.getPosY() + 1);
                                        reloadDungeon();
                                    }
                                    case "goblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Goblin"));
                                    }
                                    case "hobgoblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                                    }
                                    case "door" -> {
                                        // Level Up
                                    }
                                }
                            }
                            case "goblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Goblin"));
                            }
                            case "hobgoblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                            }
                            case "door" -> {
                                // Level Up
                            }
                        }
                    }
                    case KeyEvent.VK_LEFT -> {
                        switch (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()].getTileType()) {
                            case "grass" -> {
                                dungeon.moveEnemies(pc);
                                reloadDungeon();
                                
                                switch (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()].getTileType()) {
                                    case "grass" -> {
                                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("grass");
                                        dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()].setTileType("player");
                                        pc.setPos(pc.getPosX() - 1, pc.getPosY());
                                        reloadDungeon();
                                    }
                                    case "goblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Goblin"));
                                    }
                                    case "hobgoblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                                    }
                                    case "door" -> {
                                        // Level Up
                                    }
                                }
                            }
                            case "goblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Goblin"));
                            }
                            case "hobgoblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                            }
                            case "door" -> {
                                // Level Up
                            }
                        }
                    }
                    case KeyEvent.VK_RIGHT -> {
                        switch (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].getTileType()) {
                            case "grass" -> {
                                dungeon.moveEnemies(pc);
                                reloadDungeon();
                                
                                switch (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].getTileType()) {
                                    case "grass" -> {
                                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("grass");
                                        dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].setTileType("player");
                                        pc.setPos(pc.getPosX() + 1, pc.getPosY());
                                        reloadDungeon();
                                    }
                                    case "goblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Goblin"));
                                    }
                                    case "hobgoblin" -> {
                                        parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                                    }
                                    case "door" -> {
                                        // Level Up
                                    }
                                }
                            }
                            case "goblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Goblin"));
                            }
                            case "hobgoblin" -> {
                                parentFrame.openCombat(pc, new Enemy("Hobgoblin"));
                            }
                            case "door" -> {
                                // Level Up
                            }
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Do Nothing
            }
        });
    }
    
    private void loadDungeon() {
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 24; j++) {
                switch (dungeon.tilemap[j][i].getTileType()) {
                    case "null" -> {
                        grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Null.png"));
                        this.add(grid[j][i]);
                    }
                    case "wall" -> {
                        grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                        this.add(grid[j][i]);
                    }
                    case "grass" -> {
                        grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                        this.add(grid[j][i]);
                    }
                    case "door" -> {
                        grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                        this.add(grid[j][i]);
                    }
                    case "player" -> {
                        switch (pc.getArchetype()) {
                            case "Warrior" -> {
                                grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\Warrior_Grass.png"));
                                this.add(grid[j][i]);
                            }
                            case "Mage" -> {
                                grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\Mage_Grass.png"));
                                this.add(grid[j][i]);
                            }
                            case "Paladin" -> {
                                grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\Paladin_Grass.png"));
                                this.add(grid[j][i]);
                            }
                        }
                    }
                    case "goblin" -> {
                        grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Enemies\\Goblin_Grass.png"));
                        this.add(grid[j][i]);
                    }
                    case "hobgoblin" -> {
                        grid[j][i] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Enemies\\Hobgoblin_Grass.png"));
                        this.add(grid[j][i]);
                    }
                }
            }
        }
    }
    
    private void reloadDungeon() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 24; j++) {
                switch (dungeon.tilemap[j][i].getTileType()) {
                    case "null" -> {
                        grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Null.png"));
                    }
                    case "wall" -> {
                        grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                    }
                    case "grass" -> {
                        grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                    }
                    case "door" -> {
                        grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                    }
                    case "player" -> {
                        switch (pc.getArchetype()) {
                            case "Warrior" -> {
                                grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\Warrior_Grass.png"));
                            }
                            case "Mage" -> {
                                grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\Mage_Grass.png"));
                            }
                            case "Paladin" -> {
                                grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\Paladin_Grass.png"));
                            }
                        }
                    }
                    case "goblin" -> {
                        grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Enemies\\Goblin_Grass.png"));
                    }
                    case "hobgoblin" -> {
                        grid[j][i].setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Enemies\\Hobgoblin_Grass.png"));
                    }
                }
            }
        }
        this.revalidate();
    }
}

