/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michael Hood
 */
public class Item {
    //name, description and effect of the item
     private String name;
     private String des;
     //eff will be an array of effects that can affect the stats of the player
     //The first will raise health, second FP, third attack, and fourth will 
     //restore an amount of health
     private int[] eff = {0, 0, 0, 0};
     
     //Initialize the item
     public Item(){
         name = "";
         des = "";
     }
     //give the item its values depending on its type
     //can add more depending on how many items needed
     public void attPotion(){
         name = "Strength Potion";
         des = "This potion raises the users attack by two for the duration of the battle it is used in.";
         //raises the attack of the player by two
         eff[2] = 2;
     }
     
     
     public void fpPotion(){
         name = "Magic Potion";
         des = "This potion raises the users focus points by two for the duration of the battle it is used in.";
         //raises the focus points of the player by two
         eff[1] = 2;
     }
     
     public void hpPotion(){
         name = "Health Potion";
         des = "This potion raises the users health points by two for the duration of the battle it is used in.";
         //raises the hp of the player by two
         eff[0] = 2;
     }
     
     public void restPotion(){
         name = "Restoration Potion";
         des = "This potion restores the users health by five.";
         //restores hp of the player by five
         eff[3] = 5;
     }
    
     public String getName(){
         return name;
     }
    
     public String getDes(){
         return des;
     }
     
     public int[] getEff(){
         return eff;
     }
    
    
    
}
