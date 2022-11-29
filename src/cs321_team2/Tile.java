/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

/**
 *
 * @author Keenan Coleman
 */
public class Tile {
 
    private String tileType;//What type of tile it is(Ex. character, chest, etc.)
    private boolean hasPlayer;
    private boolean hasChest;
    private String enemyType;
    private boolean hasDoor;
    
    public Tile()
    {
        tileType = "null";
        hasPlayer = false;
        hasChest = false;
        enemyType = "null";
        hasDoor = false;
    }
    
    public void setTileType(String name)
    {
        tileType = name;
    }
    
    public String getTileType()
    {
        return tileType;
    }
    
    public void setPlayer(boolean bool)
    {
        hasPlayer = bool;
    }
    
    public void setChest(boolean bool)
    {
        hasChest = bool;
    }
    
    public void setEnemyType(String type)
    {
        enemyType = type;
    }
    
    public void setDoor(boolean bool)
    {
        hasDoor = bool;
    }
    
    public boolean hasChest()
    {
        return hasChest;
    }
    public boolean hasPlayer()
    {
        return hasPlayer;
    }
    public boolean hasEnemy()
    {
        if (enemyType.equals("null")) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public boolean hasDoor()
    {
        return hasDoor;
    }
    
}