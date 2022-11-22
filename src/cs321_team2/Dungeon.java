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
        for(int i = 0; i < x-1; i++)
        {
            for(int f = 0; f < y-1; f++)
            {
                for(int s = 0; s < z-1; s++)
                {
                    tilemap[x][y][z] = new Tile();
                }
            }
        }
    }
    
    void readDungeon()//print the tiletype of each tile in the dungeon
    {
        for(int i = 0; i < x-1; i++)
        {
            for(int f = 0; f < y-1; f++)
            {
                for(int s = 0; s < z-1; s++)
                {
                    System.out.println(tilemap[x][y][level].tileType);
                }
            }
        }
    }
    
    void setLevel()//fill the dungeon with a tile type based on level
    {
        try{
            File f1 = new File(Door());
            Scanner sc = new Scanner(f1);
            for(int i = 0; i < x-1; i++)
            {
                for(int f = 0; f < y-1; f++)
                {
                    for(int s = 0; s < z-1; s++)
                    {
                        tilemap[x][y][z] = new Tile();
                        tilemap[x][y][level].tileType = sc.next();
                    }
                }
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    
   void DungeonLogic(Tile current)//Dungeon logic based on player location
   {
       if((current.player && current.chest) == true)
       {
           //add random item to inventory
       }
       
       if((current.player && current.door) == true)
       {
           level = level + 1;
           setLevel();
       }
       
       if((current.player && current.enemy) == true)
       {
           //add battle stuff
       }

   }
   
   String Door()//used to choose which file to read from
   {
       switch(level)
       {
           case 0 -> {
               return "D:\\Netbeans\\NetBeans-15\\Dungeon\\DungeonCrawler\\src\\cs321_team2\\Levels\\Level1.txt";
            }
           case 1 -> {
               return "D:\\Netbeans\\NetBeans-15\\Dungeon\\DungeonCrawler\\src\\cs321_team2\\Levels\\Level2.txt";
            }
           default ->
                   {
                       return("D:\\Netbeans\\NetBeans-15\\Dungeon\\DungeonCrawler\\src\\cs321_team2\\Levels\\Level1.txt");
                   }
                
       }
   }
}
