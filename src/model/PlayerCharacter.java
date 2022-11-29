package model;

import cs321_team2.*;
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
    
    public int getHP() {
        return currentHP;
    }
    
    public int getFP() {
        return currentFP;
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
    
    public void setHP(int newHP) {
        maxHP = newHP;
    }
    
    public void setAtk(int newAtk) {
        Atk = newAtk;
    }
    
    public void setFP(int newFP) {
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
