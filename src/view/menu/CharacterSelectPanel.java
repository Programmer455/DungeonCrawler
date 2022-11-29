package view.menu;

import model.PlayerCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Sawyer Neal
 */
public class CharacterSelectPanel extends JPanel implements ActionListener {

    private final MenuFrame parentFrame;
    
    private final GridBagConstraints gbc;
    
    // Components
    private final JLabel descLabel = new JLabel("Create Your Character!");
    private final JLabel nameLabel = new JLabel("Enter Name");
    private final JTextField nameTextField = new JTextField();
    private final JLabel archetypeLabel = new JLabel("Pick a Class");
    private final JRadioButton warriorButton = new JRadioButton("Warrior");
    private final JRadioButton mageButton = new JRadioButton("Mage");
    private final JRadioButton paladinButton = new JRadioButton("Paladin");
    private final JButton enterButton = new JButton("Begin");
    private final JButton backButton = new JButton("<- Go Back");
    private final ButtonGroup classes = new ButtonGroup();
    private final Dimension maxTextFieldDim = new Dimension(600, 30);
    
    
    // Constructor
    public CharacterSelectPanel(MenuFrame parentFrame) {
        
        // Create Panel Layout
        this.parentFrame = parentFrame;
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        // Add RadioButtons to ButtonGroup
        classes.add(warriorButton);
        classes.add(mageButton);
        classes.add(paladinButton);
        
        // Set Fonts and Colors
        descLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        nameLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        archetypeLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        
        nameTextField.setMaximumSize(maxTextFieldDim);
        
        backButton.setFont(new Font("Verdana", Font.BOLD, 10));
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        
        enterButton.setFont(new Font("Verdana", Font.BOLD, 20));
        enterButton.setBackground(Color.RED);
        enterButton.setForeground(Color.WHITE);
        
        warriorButton.setFont(new Font("Verdana", Font.BOLD, 10));
        mageButton.setFont(new Font("Verdana", Font.BOLD, 10));
        paladinButton.setFont(new Font("Verdana", Font.BOLD, 10));
        
        addElements();
        addActionEvents();
    }
    
    // Add Buttons, Labels, etc. to Panel
    private void addElements() {
        
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(backButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipady = 50;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(descLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 10;
        
        this.add(nameLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(nameTextField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(archetypeLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(warriorButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(mageButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        this.add(paladinButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(enterButton, gbc);
    }
    
    // Add ActionListener to Buttons
    private void addActionEvents() {
        warriorButton.addActionListener(this);
        mageButton.addActionListener(this);
        paladinButton.addActionListener(this);
        enterButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    // Detects Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        // Create Character object and Move to GameFrame
        if (e.getSource() == enterButton) {
            /**
            if (warriorButton.isSelected()) {
                PlayerCharacter PC = new PlayerCharacter(nameTextField.getText(), "Warrior");
                
            }
            */
        }
        // Return to TitlePanel
        else if (e.getSource() == backButton) {
            parentFrame.openTitle();
        }
    }
}
