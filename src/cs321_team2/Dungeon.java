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
    
    /**
    public void setEmptyDungeon()//sets all indexes of the dungeon to an empty tile
    {
        for(int i = 0; i < x; i++)
        { 
            for(int f = 0; f < y; f++)
            {
                for(int s = 0; s < z; s++)
                {
                    tilemap[i][f][s] = new Tile();
                }
            }
        }
    }
    
    public void readDungeon()//print the tiletype of each tile in the dungeon
    {
        for(int i = 0; i < x; i++)
        {
            for(int f = 0; f < y; f++)
            {
                for(int s = 0; s < z; s++)
                {
                    System.out.println(tilemap[i][f][s].getTileType());
                }
            }
        }
    }
    
    public void readLevel()//print the tiletype of wach tile in the current level
    {
        for(int i = 0; i < x; i++)
        {
            for(int f = 0; f < y; f++)
            {

                 System.out.print(tilemap[i][f][level].getTileType() + " ");
            }
            
            System.out.println();
        }
    }
    
    public void setLevel()//fill the dungeon with a tile type based on level
    {
        try{
            File f1 = new File(Door());
            Scanner sc = new Scanner(f1);
            for(int i = 0; i < x; i++)
            {
                for(int f = 0; f < y; f++)
                {
                    tilemap[i][f][level].setTileType(sc.next());
                }
            }
            
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    
   public void DungeonLogic(Tile current)//Dungeon logic based on player location
   {
       if((current.hasPlayer() && current.hasChest()) == true)
       {
           //add random item to inventory
       }
       
       if((current.hasPlayer() && current.hasDoor()) == true)
       {
           level = level + 1;
           setLevel();
       }
       
       if((current.hasPlayer() && current.hasEnemy()) == true)
       {
           //add battle stuff
       }

   }
   
   public String Door()//used to choose which file to read from
   {
       switch(level)
       {
           case 0 -> {
               return System.getProperty("user.dir") + "\\src\\cs321_team2\\Levels\\Level1.txt";
            }
           case 1 -> {
               return System.getProperty("user.dir") + "\\src\\cs321_team2\\Levels\\Level2.txt";
            }
           default ->
                   {
                       return System.getProperty("user.dir") + "\\src\\cs321_team2\\Levels\\Level1.txt";
                   }
                
       }
   }
   */
    
}