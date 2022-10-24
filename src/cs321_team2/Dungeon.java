/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

/**
 *
 * @author keani
 */
public class Dungeon {
    
    int x, y, z;//sets the size of the Dungeon
    Tile tilemap[][][];
    
    Dungeon(int x, int y, int z)//Makes dungeon based on x, y, z
    {
        this.x = x;
        this.y = y;
        this.z = z;
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
                    tilemap[x][y][z] = new Tile();
                }
            }
        }
    }
}
