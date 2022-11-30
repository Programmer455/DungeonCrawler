
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
    private int Atk;
    private int Xp;
    private int locX;
    private int locY;
    private int type;
    
    public Enemy(int kind) {
        if(kind == 1){
        name = "Goblin";
        maxHP = 55;
        currentHP = maxHP;
        Atk = 10;
        Xp = 20;
    }else{
        name = "HobGoblin";
        maxHP = 150;
        currentHP = maxHP;
        Atk = 18;
        Xp = 50;
        }
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

    public int getAtk() {
        return Atk;
    }
    
    public void setHP(int newHP) {
        maxHP = newHP;
    }
    
    public void setAtk(int newAtk) {
        Atk = newAtk;
    }
}
