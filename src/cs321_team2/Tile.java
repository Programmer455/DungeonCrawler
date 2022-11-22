/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

/**
 *
 * @author keani
 */
public class Tile {
 
    String tileType;//What type of tile it is(Ex. character, chest, etc.)
    boolean player;
    boolean chest;
    boolean enemy;
    boolean door;
    
    Tile()
    {
        tileType = "";
        player = false;
        chest = false;
        enemy = false;
    }
    
    Tile(String name)
    {
        tileType = name;
    }
    
    void setTileType(String name)
    {
        tileType = name;
    }
    
    String getTileType()
    {
        return tileType;
    }
    
    void setPlayer(boolean bool)
    {
        player = bool;
    }
    
    void setChest(boolean bool)
    {
        chest = bool;
    }
    
    void setEnemy(boolean bool)
    {
        enemy = bool;
    }
    
    void setDoor(boolean bool)
    {
        door = bool;
    }
    
    boolean hasChest()
    {
        return chest;
    }
    boolean hasPlayer()
    {
        return player;
    }
    boolean hasEnemy()
    {
        return enemy;
    }
    
}