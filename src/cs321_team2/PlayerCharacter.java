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
    private int XP;
    private int level;
    private int floor;
    private int posX;
    private int posY;
    
    public PlayerCharacter(String newName, String newArchetype) {
        name = newName;
        archetype = new Archetype(newArchetype);
        maxHP = 10;
        currentHP = maxHP;
        maxFP = 10;
        currentFP = maxFP;
        Atk = 10;
        XP = 0;
        level = 1;
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
    
    public void addXP(int xp) {
        XP += xp;
        if (XP >= 100) {
            levelUp();
        }
    }
    
    public void levelUp() {
        XP -= 100;
        level++;
        switch (this.getArchetype()) {
            case "Warrior" -> {
                Atk += 6;
                maxHP += 4;
                maxFP += 2;
                currentHP = maxHP;
                currentFP = maxFP;
            }
            case "Mage" -> {
                Atk += 4;
                maxHP += 2;
                maxFP += 6;
                currentHP = maxHP;
                currentFP = maxFP;
            }
            case "Paladin" -> {
                Atk += 2;
                maxHP += 6;
                maxFP += 4;
                currentHP = maxHP;
                currentFP = maxFP;
            }
        }
    }
}
