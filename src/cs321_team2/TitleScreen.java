/*
Ace Wheatley
This class creates the GUI and methods for the project's tittle screen
 */
package cs321_team2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.*;


public class TitleScreen {
    
    public TitleScreen(){
        
        JPanel panel = new JPanel(); //creates a panel 
        JFrame frame = new JFrame(); //creates the frame aka window
        
        //Title Screen Frame settings
        frame.setSize(1200, 700); //sets size of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets closing conditions
        frame.add(panel); //adds the panel to the frame
       
        panel.setLayout(null);
        
        // Game Title Settings
        JLabel label = new JLabel("Dungeon Crawler"); //Creates Game Title
        label.setBounds(500,150,275,50);
        panel.add(label);
        
        // Start Game Button Settings
        JButton StartButton = new JButton("Start Game"); //Creates Button With Text
        StartButton.setBounds(500,200,200,75); //sets position of StartButton
        StartButton.setBackground(Color.RED);
        StartButton.setForeground(Color.WHITE);
        panel.add(StartButton); //adds StartButton to panel so it is visible
        
        //Leaderboard Button Settings
        JButton LeaderBoardButton = new JButton("LeaderBoard"); //Creates Button With Text
        LeaderBoardButton.setBounds(500,300,200,75); //sets position of StartButton
        LeaderBoardButton.setBackground(Color.RED);
        LeaderBoardButton.setForeground(Color.WHITE);
        panel.add(LeaderBoardButton); //adds StartButton to panel so it is visible
        
        //CreditsButton Settings
        JButton CreditsButton = new JButton("Credits"); //Creates Button With Text
         CreditsButton.setBounds(500,400,200,75); //sets position 
         CreditsButton.setBackground(Color.RED);
         CreditsButton.setForeground(Color.WHITE);
        panel.add( CreditsButton); //adds to panel so it is visible
        
        frame.setVisible(true); //makes frame visible to user
}   
}
