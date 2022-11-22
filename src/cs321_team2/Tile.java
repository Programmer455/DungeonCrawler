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
    
    Tile(String tileType)
    {
        this.tileType = tileType;
    }
    
    void setTileType(String tileType)
    {
        this.tileType = tileType;
    }
    
    String getTileType()
    {
        return tileType;
    }
    
    void setPlayer(boolean player)
    {
        this.player = player;
    }
    
    void setChest(boolean chest)
    {
        this.chest = chest;
    }
    
    void setEnemy(boolean enemy)
    {
        this.enemy = enemy;
    }
    
    void setDoor(boolean door)
    {
        this.door = door;
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
