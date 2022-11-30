
package view.game;

import cs321_team2.PlayerCharacter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import cs321_team2.Dungeon;
import cs321_team2.Enemy;
import view.menu.MenuFrame;


/**
 *
 * @author hoods
 */
public class gameOverPanel extends JPanel implements ActionListener {
    
    private final DungeonFrame parentFrame;
    
    private final JLabel descLabel = new JLabel("Game Over");
    private final JButton returnButton = new JButton("<- Return");
    
    gameOverPanel(DungeonFrame parentFrame){
        this.parentFrame = parentFrame;
        
        descLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        
        returnButton.setFont(new Font("Verdana", Font.BOLD, 10));
        returnButton.setBackground(Color.RED);
        returnButton.setForeground(Color.WHITE);
        
        addElements();
        addActionEvents();
    }
    
           private void addElements() {
        
        this.add(returnButton);
        this.add(descLabel);
        
        returnButton.setBounds(600, 30, 50, 10);
        descLabel.setBounds(700, 20, 150, 10);
        
    }
    
    // Adds ActionListener to Buttons
    private void addActionEvents() {
        returnButton.addActionListener(this);
    }

    // Detects Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        // Moves to CharacterSelectPanel
        if (e.getSource() == returnButton) {
            parentFrame.getContentPane().removeAll();
            parentFrame.getContentPane().invalidate();
            
            MenuFrame newFrame = new MenuFrame();
            newFrame.setVisible(true);
            newFrame.openTitle();
            parentFrame.dispose();
            
        }
    }
    
}
