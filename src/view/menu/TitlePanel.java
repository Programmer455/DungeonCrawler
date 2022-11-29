package view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Ace Wheatley
 */
public class TitlePanel extends JPanel implements ActionListener {
    
    private final MenuFrame parentFrame;
    
    private final GridBagConstraints gbc;
    
    private final JLabel descLabel = new JLabel("Unnamed Dungeon Crawler");
    private final JButton startButton = new JButton("Start Game");
    private final JButton leaderboardButton = new JButton("Leaderboard");
    private final JButton creditsButton = new JButton("Credits");
    private final JButton exitButton = new JButton("Exit Game");
    
    
    public TitlePanel(MenuFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        descLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        
        startButton.setFont(new Font("Verdana", Font.BOLD, 20));
        startButton.setBackground(Color.RED);
        startButton.setForeground(Color.WHITE);
        
        leaderboardButton.setFont(new Font("Verdana", Font.BOLD, 20));
        leaderboardButton.setBackground(Color.RED);
        leaderboardButton.setForeground(Color.WHITE);
        
        creditsButton.setFont(new Font("Verdana", Font.BOLD, 20));
        creditsButton.setBackground(Color.RED);
        creditsButton.setForeground(Color.WHITE);
        
        exitButton.setFont(new Font("Verdana", Font.BOLD, 20));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        
        addElements();
        addActionEvents();
    }
    
    private void addElements() {
        
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(descLabel, gbc);
        
        gbc.ipady = 20;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(startButton, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(leaderboardButton, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(creditsButton, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(exitButton, gbc);
    }
    
    private void addActionEvents() {
        startButton.addActionListener(this);
        leaderboardButton.addActionListener(this);
        creditsButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            parentFrame.openCharacterSelect();
        }
        else if (e.getSource() == leaderboardButton) {
            
        }
        else if (e.getSource() == creditsButton) {
            
        }
        else if (e.getSource() == exitButton) {
            parentFrame.exitGame();
        }
    }
}
