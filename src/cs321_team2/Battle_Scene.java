/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_team2;

import javax.swing.*;

/**
 *
 * @author hoods
 */
public class Battle_Scene {
    
    public Battle_Scene(){
        JPanel panel = new JPanel(); //creates a panel 
        panel.setLayout(null);
        JFrame frame = new JFrame("Battle");
        JButton fight = new JButton("Fight");
       JButton run = new JButton("Retreat");
       JButton pack = new JButton("Pack");
        //Adding components for the battle scene
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.add(fight);
        panel.add(pack);
        panel.add(run);
        fight.setBounds(900,500,100,50);
        pack.setBounds(1000,500,100,50);
        run.setBounds(950,550,100,50);

    }
    
}
