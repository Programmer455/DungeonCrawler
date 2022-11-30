
package cs321_team2;

/**
 *
 * @author Michael Hood
 */
public class Enemy {
    private final String name;
    private int HP;
    private int Atk;
    private int XP;
    
    public Enemy(String name) {
        switch (name) {
            case "Goblin" -> {
                this.name = name;
                HP = 15;
                Atk = 2;
                XP = 50;
            }
            case "Hobgoblin" -> {
                this.name = name;
                HP = 40;
                Atk = 6;
                XP = 100;
            }
            default -> {
                this.name = "null";
                HP = 1;
                Atk = 1;
                XP = 0;
            }
        }
    }
    
    
    public int getXP (){
        return XP;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHP() {
        return HP;
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
}
