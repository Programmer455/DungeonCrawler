/*
Ace Wheatley
This class creates the GUI and methods for the project's tittle screen
 */
package cs321_team2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


public class TitleScreen {
    
    public TitleScreen(){
        
        JPanel panel = new JPanel(); //creates a panel 
        JFrame frame = new JFrame(); //creates the frame aka window
        
        frame.setSize(1200, 700); //sets size of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets closing conditions
        frame.add(panel); //adds the panel to the frame
       
        panel.setLayout(null);
        
        JLabel label = new JLabel("Dungeon Crawler"); //Creates Game Title
        label.setBounds(500,160,150,25);
        panel.add(label);
        
        JButton StartButton = new JButton("Start Game"); //Creates Button With Text
        StartButton.setBounds(500,200,150,25); //sets size of StartButton
        panel.add(StartButton); //adds StartButton to panel so it is visible
        
        
        frame.setVisible(true); //makes frame visible to user
}   
}
