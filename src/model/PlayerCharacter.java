/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

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
    
    public void setHP(int newHP) {
        maxHP = newHP;
    }
    
    public void setAtk(int newAtk) {
        Atk = newAtk;
    }
    
    public void setFP(int newFP) {
        maxFP = newFP;
    }
}
