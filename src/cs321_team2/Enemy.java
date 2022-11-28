
package cs321_team2;

/**
 *
 * @author hoods
 */
public class Enemy {
    private final String name;
    //private Archetype archetype;
    private int maxHP;
    private int currentHP;
    private int maxFP;
    private int currentFP;
    private int Atk;
    private int Xp;
    private int[] loc = {0,0,0};    
    
    public Enemy() {
        name = "Goblin";
        maxHP = 10;
        currentHP = maxHP;
        maxFP = 10;
        currentFP = maxFP;
        Atk = 10;
        Xp = 10;   
    }
    
    public int[] getLoc() {
    return loc;
}
    
    public int getXp (){
        return Xp;
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
