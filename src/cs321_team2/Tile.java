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
 
    private String tileType;
    private boolean hasMoved = false;
    
    public Tile() {
        tileType = "null";
    }
    
    public Tile(String name) {
        tileType = name;
    }
    
    public void setTileType(String name) {
        tileType = name;
    }
    
    public String getTileType() {
        return tileType;
    }
    
    public void setMoved(boolean bool) {
        hasMoved = bool;
    }
    
    public boolean getMoved() {
        return hasMoved;
    } 
    
    /**
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
    */
}