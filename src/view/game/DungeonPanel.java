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
    
    private final GridBagConstraints gbc;
    
    private final PlayerCharacter pc;
    private final Dungeon dungeon;
    
    private final JLabel floorLabel = new JLabel("Floor: ");
    private final JLabel floorNumLabel = new JLabel();
    private final JLabel scoreLabel = new JLabel("Score: ");
    private final JLabel scoreNumLabel = new JLabel();
    
    public DungeonPanel(DungeonFrame parentFrame, PlayerCharacter pc, Dungeon dungeon) {
        
        this.pc = pc;
        this.dungeon = dungeon;
        
        parentFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> {
                    System.out.println("UP");
                    if ("wall".equals(dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].getTileType())) {
                        // Do Nothing
                    }
                    else if (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].hasEnemy() == true) {
                        System.out.println("ENEMY");
                        parentFrame.openCombat(pc, new Enemy(1));
                    }
                    else if (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].hasEnemy() == true) {
                        // Open Chest
                    }
                    else {
                        // Move Player
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setPlayer(false);
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("floor");
                        pc.setPos(pc.getPosX(), pc.getPosY() - 1);
                        dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].setPlayer(true);
                    
                        // moveEnemies();
                    
                        loadDungeon();
                    }
                }
                case KeyEvent.VK_DOWN -> {
                    System.out.println("DOWN");
                    if ("wall".equals(dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].getTileType())) {
                        // Do Nothing
                    }
                    else if (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].hasEnemy() == true) {
                        System.out.println("ENEMY");
                    }
                    else if (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].hasEnemy() == true) {
                        // Open Chest
                    }
                    else {
                        // Move Player
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setPlayer(false);
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("floor");
                        pc.setPos(pc.getPosX(), pc.getPosY() + 1);
                        dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].setPlayer(true);
                    
                        // moveEnemies();
                    
                        loadDungeon();
                    }
                }
                case KeyEvent.VK_LEFT -> {
                System.out.println("LEFT");
                    if ("wall".equals(dungeon.tilemap[pc.getPosX()][pc.getPosY()].getTileType())) {
                        // Do Nothing
                    }
                    else if (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()].hasEnemy() == true) {
                        System.out.println("ENEMY");
                    }
                    else if (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()].hasEnemy() == true) {
                        // Open Chest
                    }
                    else {
                        // Move Player
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setPlayer(false);
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("floor");
                        pc.setPos(pc.getPosX() - 1, pc.getPosY());
                        dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()].setPlayer(true);
                    
                        // moveEnemies();
                    
                        loadDungeon();
                    }
                }
                case KeyEvent.VK_RIGHT -> {
                    System.out.println("RIGHT");
                    if ("wall".equals(dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].getTileType())) {
                        // Do Nothing
                    }
                    else if (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].hasEnemy() == true) {
                        System.out.println("ENEMY");
                    }
                    else if (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].hasEnemy() == true) {
                        // Open Chest
                    }
                    else {
                        // Move Player
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setPlayer(false);
                        dungeon.tilemap[pc.getPosX()][pc.getPosY()].setTileType("floor");
                        pc.setPos(pc.getPosX() + 1, pc.getPosY());
                        dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].setPlayer(true);
                    
                        // moveEnemies();
                    
                        loadDungeon();
                    }
                }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
        
        // Create Panel Layout
        this.parentFrame = parentFrame;
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        // Sets Fonts and Colors
        floorLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        floorNumLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        scoreLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        scoreNumLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        
        floorNumLabel.setText(pc.getFloorAsString());
        scoreNumLabel.setText(pc.getScoreAsString());
        
        addElements();
    }
    
    private void addElements() {
        
        gbc.insets = new Insets(0, 0, 0, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 40;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(floorLabel, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.ipady = 40;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(floorNumLabel, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.ipady = 40;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(scoreLabel, gbc);
        
        gbc.gridx = 11;
        gbc.gridy = 0;
        gbc.ipady = 40;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(scoreNumLabel, gbc);
        
        loadDungeon();
    }
    
    private void addActionEvents() {
        
    }
    
    private void loadDungeon() {
        
        gbc.ipady = 0;
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        
        this.add(new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\" + pc.getArchetype() + "_Grass.png")), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel tile = null;
        if (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() - 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 3 >= 0 && pc.getPosY() - 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() - 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() - 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 2 >= 0 && pc.getPosY() - 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() - 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() - 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 1 >= 0 && pc.getPosY() - 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() - 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() >= 0 && pc.getPosY() - 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() - 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 1 >= 0 && pc.getPosY() - 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() - 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 1;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() - 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 2 >= 0 && pc.getPosY() - 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() - 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 1;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() - 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 3 >= 0 && pc.getPosY() - 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() - 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() - 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 3 >= 0 && pc.getPosY() - 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() - 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() - 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 2 >= 0 && pc.getPosY() - 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() - 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() - 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 1 >= 0 && pc.getPosY() - 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() - 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() >= 0 && pc.getPosY() - 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() - 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 2;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() - 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 1 >= 0 && pc.getPosY() - 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() - 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 2;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() - 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 2 >= 0 && pc.getPosY() - 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() - 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 2;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() - 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 3 >= 0 && pc.getPosY() - 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() - 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY()] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 3 >= 0 && pc.getPosY() >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY()].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY()] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 2 >= 0 && pc.getPosY() >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY()].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 1 >= 0 && pc.getPosY() >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY()].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 3;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 1 >= 0 && pc.getPosY() >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY()].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 3;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY()] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 2 >= 0 && pc.getPosY() >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY()].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 3;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY()] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 3 >= 0 && pc.getPosY() >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY()].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() + 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 3 >= 0 && pc.getPosY() + 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() + 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() + 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 2 >= 0 && pc.getPosY() + 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() + 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() + 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 1 >= 0 && pc.getPosY() + 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() + 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 4;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() >= 0 && pc.getPosY() + 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 4;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() + 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 1 >= 0 && pc.getPosY() + 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() + 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 4;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() + 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 2 >= 0 && pc.getPosY() + 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() + 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 4;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() + 1] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 3 >= 0 && pc.getPosY() + 1 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() + 1].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() + 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 3 >= 0 && pc.getPosY() + 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 3][pc.getPosY() + 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() + 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 2 >= 0 && pc.getPosY() + 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 2][pc.getPosY() + 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 5;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() + 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() - 1 >= 0 && pc.getPosY() + 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() - 1][pc.getPosY() + 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 5;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() >= 0 && pc.getPosY() + 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX()][pc.getPosY() + 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 5;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() + 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 1 >= 0 && pc.getPosY() + 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 1][pc.getPosY() + 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 5;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() + 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 2 >= 0 && pc.getPosY() + 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 2][pc.getPosY() + 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 5;
        
        tile = null;
        if (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() + 2] == null) {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        else if (pc.getPosX() + 3 >= 0 && pc.getPosY() + 2 >= 0) {
            switch (dungeon.tilemap[pc.getPosX() + 3][pc.getPosY() + 2].getTileType()) {
                case "null" -> {
                    tile = new JLabel();
                    tile.setBackground(Color.BLACK);
                }
                case "wall" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Wall.png"));
                }
                case "floor" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Grass.png"));
                }
                case "chest" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Chest_Grass.png"));
                }
                case "door" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Door_Grass.png"));
                }
                case "goblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Goblin_Grass.png"));
                }
                case "hobgoblin" -> {
                    tile = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Tiles\\Hobgoblin_Grass.png"));
                }
            }
        }
        else {
            tile = new JLabel();
            tile.setBackground(Color.BLACK);
        }
        this.add(tile, gbc);
    }
}
