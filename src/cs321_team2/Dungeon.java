/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

import java.io.*;
import java.util.*;
/**
 *
 * @author keani
 */
public class Dungeon {
    
    int x, y, z;//sets the size of the Dungeon
    int level;
    Tile tilemap[][][];
    
    Dungeon(int x, int y, int z)//Makes dungeon based on x, y, z
    {
        this.x = x;
        this.y = y;
        this.z = z;
        level = 0;
        tilemap = new Tile[x][y][z];
    }
    
    void setEmptyDungeon()//sets all indexes of the dungeon to an empty tile
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
    
    void readDungeon()//print the tiletype of each tile in the dungeon
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
    
    void readLevel()//print the tiletype of wach tile in the current level
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
    
    void setLevel()//fill the dungeon with a tile type based on level
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
    
   void DungeonLogic(Tile current)//Dungeon logic based on player location
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
   
   String Door()//used to choose which file to read from
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
}