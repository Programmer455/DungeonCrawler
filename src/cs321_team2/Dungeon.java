/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

import java.io.*;
import java.util.*;
import model.*;
import cs321_team2.*;
import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Keenan Coleman
 */
public class Dungeon {
    
    private int floor;
    public Tile tilemap[][] = new Tile[24][16];
    
    // Constructor
    public Dungeon(PlayerCharacter pc, int floor) {
        this.floor = floor;
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 24; j++) {
                tilemap[j][i] = new Tile();
            }
        }
        
        try {
            setDungeon(pc);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Reads Level File to Create Dungeon
    private void setDungeon(PlayerCharacter pc) throws FileNotFoundException {
        
        File fl = new File(System.getProperty("user.dir") + "\\src\\cs321_team2\\Levels\\Level" + String.valueOf(floor) + ".txt");
        Scanner sc = new Scanner(fl);
        
        // Loops through Dungeon Grid
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 24; j++) {
                switch (sc.next()) {
                    case "0" -> {
                        tilemap[j][i].setTileType("null");
                    }
                    case "1" -> {
                        tilemap[j][i].setTileType("wall");
                    }
                    case "2" -> {
                        tilemap[j][i].setTileType("grass");
                    }
                    case "3" -> {
                        tilemap[j][i].setTileType("door");
                    }
                    case "4" -> {
                        tilemap[j][i].setTileType("player");
                        pc.setPos(j, i);
                    }
                    case "5" -> {
                        tilemap[j][i].setTileType("goblin");
                    }
                    case "6" -> {
                        tilemap[j][i].setTileType("hobgoblin");
                    }
                }
            }
        }
    }
    
    // Moves Enemies closer to Player
    public void moveEnemies(PlayerCharacter pc) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 24; j++) {
                if (tilemap[j][i].getTileType() == "goblin" && tilemap[j][i].getMoved() == false) {
                    moveEnemy(pc, "goblin", j, i);
                }
                else if (tilemap[j][i].getTileType() == "hobgoblin" && tilemap[j][i].getMoved() == false) {
                    moveEnemy(pc, "hobgoblin", j, i);
                }
            }
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 24; j++) {
                tilemap[j][i].setMoved(false);
            }
        }
    }
    
    private void moveEnemy(PlayerCharacter pc, String type, int x, int y) {
        if (abs(pc.getPosX() - x) >= abs(pc.getPosY() - y)) {
            if (pc.getPosX() - x >= 0) {
                if (tilemap[x + 1][y].getTileType() == "grass") {
                    tilemap[x + 1][y].setTileType(type);
                    tilemap[x + 1][y].setMoved(true);
                    tilemap[x][y].setTileType("grass");
                }
                else if (pc.getPosY() - y >= 0) {
                    if (tilemap[x][y + 1].getTileType() == "grass") {
                        tilemap[x][y + 1].setTileType(type);
                        tilemap[x][y + 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y - 1].getTileType() == "grass") {
                        tilemap[x][y - 1].setTileType(type);
                        tilemap[x][y - 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x - 1][y].getTileType() == "grass") {
                        tilemap[x - 1][y].setTileType(type);
                        tilemap[x - 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
                else {
                    if (tilemap[x][y - 1].getTileType() == "grass") {
                        tilemap[x][y - 1].setTileType(type);
                        tilemap[x][y - 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y + 1].getTileType() == "grass") {
                        tilemap[x][y + 1].setTileType(type);
                        tilemap[x][y + 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x - 1][y].getTileType() == "grass") {
                        tilemap[x - 1][y].setTileType(type);
                        tilemap[x - 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
            }
            else {
                if (tilemap[x - 1][y].getTileType() == "grass") {
                    tilemap[x - 1][y].setTileType(type);
                    tilemap[x - 1][y].setMoved(true);
                    tilemap[x][y].setTileType("grass");
                }
                else if (pc.getPosY() - y >= 0) {
                    if (tilemap[x][y + 1].getTileType() == "grass") {
                        tilemap[x][y + 1].setTileType(type);
                        tilemap[x][y + 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y - 1].getTileType() == "grass") {
                        tilemap[x][y - 1].setTileType(type);
                        tilemap[x][y - 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x + 1][y].getTileType() == "grass") {
                        tilemap[x + 1][y].setTileType(type);
                        tilemap[x + 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
                else {
                    if (tilemap[x][y - 1].getTileType() == "grass") {
                        tilemap[x][y - 1].setTileType(type);
                        tilemap[x][y - 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y + 1].getTileType() == "grass") {
                        tilemap[x][y + 1].setTileType(type);
                        tilemap[x][y + 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x + 1][y].getTileType() == "grass") {
                        tilemap[x + 1][y].setTileType(type);
                        tilemap[x + 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
            }
        }
        else {
            if (pc.getPosY() - y >= 0) {
                if (tilemap[x][y + 1].getTileType() == "grass") {
                    tilemap[x][y + 1].setTileType(type);
                    tilemap[x][y + 1].setMoved(true);
                    tilemap[x][y].setTileType("grass");
                }
                else if (pc.getPosX() - x >= 0) {
                    if (tilemap[x + 1][y].getTileType() == "grass") {
                        tilemap[x + 1][y].setTileType(type);
                        tilemap[x + 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x - 1][y].getTileType() == "grass") {
                        tilemap[x - 1][y].setTileType(type);
                        tilemap[x - 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y - 1].getTileType() == "grass") {
                        tilemap[x][y - 1].setTileType(type);
                        tilemap[x][y - 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
                else {
                    if (tilemap[x - 1][y].getTileType() == "grass") {
                        tilemap[x - 1][y].setTileType(type);
                        tilemap[x - 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x + 1][y].getTileType() == "grass") {
                        tilemap[x + 1][y].setTileType(type);
                        tilemap[x + 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y - 1].getTileType() == "grass") {
                        tilemap[x][y - 1].setTileType(type);
                        tilemap[x][y - 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
            }
            else {
                if (tilemap[x][y - 1].getTileType() == "grass") {
                    tilemap[x][y - 1].setTileType(type);
                    tilemap[x][y - 1].setMoved(true);
                    tilemap[x][y].setTileType("grass");
                }
                else if (pc.getPosX() - x >= 0) {
                    if (tilemap[x + 1][y].getTileType() == "grass") {
                        tilemap[x + 1][y].setTileType(type);
                        tilemap[x + 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x - 1][y].getTileType() == "grass") {
                        tilemap[x - 1][y].setTileType(type);
                        tilemap[x - 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y + 1].getTileType() == "grass") {
                        tilemap[x][y + 1].setTileType(type);
                        tilemap[x][y + 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
                else {
                    if (tilemap[x - 1][y].getTileType() == "grass") {
                        tilemap[x - 1][y].setTileType(type);
                        tilemap[x - 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x + 1][y].getTileType() == "grass") {
                        tilemap[x + 1][y].setTileType(type);
                        tilemap[x + 1][y].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                    else if (tilemap[x][y + 1].getTileType() == "grass") {
                        tilemap[x][y + 1].setTileType(type);
                        tilemap[x][y + 1].setMoved(true);
                        tilemap[x][y].setTileType("grass");
                    }
                }
            }
        }
    }
    
    public int getFloor() {
        return floor;
    }
    
}