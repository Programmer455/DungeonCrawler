/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoods
 */
public class Item {
    //name, description and effect of the item
     private String name;
     private String des;
     private int type;
     private int eff;
     
     //Initialize the item
     public Item(){
         name = "";
         des = "";
         type = 0;
         eff = 0;         
     }
     //give the item its values depending on its type
     //can add more depending on how many items needed
     public void attPotion(){
         name = "Attack Potion";
         des = "This potion raises the users attack by two for the duration of the battle it is used in.";
         //the type will determine which stat is affected by this item
         //for type one the attack stat will be affected
         //subject to change 
         type = 1; 
         //effect will be how much each stat is affected
         //possibly can be made into an array in case multiple stats need to be affected
         //this one will raise the attack by two.
         //also subject to change
         eff = 2;
     }
     
     public String getName(){
         return name;
     }
    
     public String getDes(){
         return des;
     }
     
     public int getType(){
         return type;
     }
     
     public int getEff(){
         return eff;
     }
    
    
    
}
