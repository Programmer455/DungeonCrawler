/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

import java.io.*;
import java.util.*;
import model.*;
import cs321_team2.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Keenan Coleman
 */
public class Dungeon {
    
    private int floor;
    public Tile tilemap[][] = new Tile[32][32];
    private Enemy enemies[] = new Enemy[16];
    
    public Dungeon(PlayerCharacter pc, int floor) {
        this.floor = floor;
        try {
            setDungeon(pc);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setDungeon(PlayerCharacter pc) throws FileNotFoundException {
        
        File fl = new File(System.getProperty("user.dir") + "\\src\\cs321_team2\\Levels\\Level" + String.valueOf(floor) + ".txt");
        Scanner sc = new Scanner(fl);
        
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (sc.hasNext()) {
                    String type = sc.next();
                    if (type.equals("endl")) {
                        j = 32;
                    }
                    else if (type.equals("start")) {
                        tilemap[j][i] = new Tile();
                        tilemap[j][i].setTileType(type);
                        tilemap[j][i].setPlayer(true);
                        pc.setPos(j, i);
                    }
                    else if (type.equals("chest")) {
                        tilemap[j][i] = new Tile();
                        tilemap[j][i].setTileType(type);
                        tilemap[j][i].setChest(true);
                    }
                    else if (type.equals("door")) {
                        tilemap[j][i] = new Tile();
                        tilemap[j][i].setTileType(type);
                        tilemap[j][i].setDoor(true);
                    }
                    else if (type.equals("goblin")) {
                        tilemap[j][i] = new Tile();
                        tilemap[j][i].setTileType(type);
                        tilemap[j][i].setEnemyType("goblin");
                    }
                    else if (type.equals("hobgoblin")) {
                        tilemap[j][i] = new Tile();
                        tilemap[j][i].setTileType(type);
                        tilemap[j][i].setEnemyType("hobgoblin");
                    }
                    else {
                        tilemap[j][i] = new Tile();
                        tilemap[j][i].setTileType(type);
                    }
                }
                else {
                    j = 32;
                    i = 32;
                }
                
                
            }
        }
    }
    
    public void moveEnemies() {
        
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