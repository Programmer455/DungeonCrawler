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
    
    Tile()
    {
        tileType = "";
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
   
    
}
