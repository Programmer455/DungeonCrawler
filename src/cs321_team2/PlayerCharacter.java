package cs321_team2;

import cs321_team2.*;
import model.Archetype;
/**
 *
 * @author Sawyer Neal
 */
public class PlayerCharacter {
    private final String name;
    private Archetype archetype;
    private int maxHP;
    private int currentHP;
    private int maxFP;
    private int currentFP;
    private int Atk;
    private int floor;
    private int posX;
    private int posY;
    //private Equipment armor;
    //private Equipment weapon;
    //private Item inventory[10];
    //private Tile position;
    
    public PlayerCharacter(String newName, String newArchetype) {
        name = newName;
        archetype = new Archetype(newArchetype);
        maxHP = 10;
        currentHP = maxHP;
        maxFP = 10;
        currentFP = maxFP;
        Atk = 10;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCurrentHP() {
        return currentHP;
    }
    
    public int getMaxHP() {
        return maxHP;
    }
    
    public int getCurrentFP() {
        return currentFP;
    }
    
    public int getMaxFP() {
        return maxFP;
    }
    
    public int getAtk() {
        return Atk;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public String getFloorAsString() {
        return String.valueOf(floor);
    }
    
    public int getScore() {
        return archetype.getXP();
    }
    
    public String getScoreAsString() {
        return String.valueOf(archetype.getXP());
    }
    
    public int getPosX() {
        return posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
    public String getArchetype() {
        return archetype.getArchetype();
    }
    
    public int getLevel() {
        return archetype.getLevel();
    }
    
    public void setCurrentHP(int newHP) {
        currentHP = newHP;
    }
    
    public void setMaxHP(int newHP) {
        maxHP = newHP;
    }
    
    public void setAtk(int newAtk) {
        Atk = newAtk;
    }
    
    public void setCurrentFP(int newFP) {
        currentFP = newFP;
    }
    
    public void setMaxFP(int newFP) {
        maxFP = newFP;
    }
    
    public void setFloor(int newFloor) {
        floor = newFloor;
    }
    
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }
}
