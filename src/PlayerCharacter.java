/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sawyer Neal
 */
public class PlayerCharacter {
    private final String name;
    //private Archetype archetype;
    private int maxHP;
    private int currentHP;
    private int maxFP;
    private int currentFP;
    private int Atk;
    //private Equipment helmet;
    //private Equipment armor;
    //private Equipment weapon;
    //private Item inventory[10];
    //private Tile position;
    
    public PlayerCharacter(String newName, String newArchetype) {
        name = newName;
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
    
    public void setHP(int newHP) {
        HP = newHP;
    }
    
    public void setAtk(int newAtk) {
        Atk = newAtk;
    }
    
    public void setFP(int newFP) {
        FP = newFP;
    }
}
