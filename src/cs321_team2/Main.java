/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs321_team2;

/**
 *
 * @author sawye
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       new TitleScreen();
       Dungeon test = new Dungeon(4, 4, 1);
       test.setEmptyDungeon();
       test.setLevel();
       test.readDungeon();
       
    }
    
}
