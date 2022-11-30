
package cs321_team2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import view.menu.*;
import view.game.*;

/**
 *
 * @author Michael Hood
 */
public class Battle_Scene extends JPanel implements ActionListener {
    
    private final DungeonFrame parentFrame;
    
    private final Enemy enemy;
    private final PlayerCharacter pc;
    
    private final JLabel playerMovesLabel = new JLabel();
    private final JLabel enemyMovesLabel = new JLabel();
    private final JLabel enemyHPLabel = new JLabel("HP:");
    private final JLabel enemyHPNumLabel = new JLabel();
    private final JLabel enemyIconLabel = new JLabel();
    private final JLabel enemyNameLabel = new JLabel();
    private final JLabel backgroundLabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\background\\background.png"));
    private final JLabel playerNameLabel = new JLabel();
    private final JLabel playerIconLabel = new JLabel();
    private final JLabel playerHPLabel = new JLabel("HP:");
    private final JLabel playerHPNumLabel = new JLabel();
    private final JLabel playerFPLabel = new JLabel("FP:");
    private final JLabel playerFPNumLabel = new JLabel();
    private final JButton attack1Button = new JButton();
    private final JButton attack2Button = new JButton();
    private final JButton attack3Button = new JButton();
    private final JButton attack4Button = new JButton();
    
    private final Random rand = new Random();
    
    public Battle_Scene(DungeonFrame parentFrame, PlayerCharacter pc, Enemy enemy){
        
        this.pc = pc;
        this.enemy = enemy;

        this.parentFrame = parentFrame;
        this.setLayout(null);
        
        playerMovesLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        enemyMovesLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        enemyHPLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        enemyHPNumLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        enemyNameLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        playerNameLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        playerHPLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        playerHPNumLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        playerFPLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        playerFPNumLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        attack1Button.setFont(new Font("Verdana", Font.BOLD, 20));
        attack2Button.setFont(new Font("Verdana", Font.BOLD, 20));
        attack3Button.setFont(new Font("Verdana", Font.BOLD, 20));
        attack4Button.setFont(new Font("Verdana", Font.BOLD, 20));
        
        attack1Button.setBackground(Color.RED);
        attack1Button.setForeground(Color.WHITE);
        attack2Button.setBackground(Color.RED);
        attack2Button.setForeground(Color.WHITE);
        attack3Button.setBackground(Color.RED);
        attack3Button.setForeground(Color.WHITE);
        attack4Button.setBackground(Color.RED);
        attack4Button.setForeground(Color.WHITE);
        
        enemyNameLabel.setText(enemy.getName());
        playerNameLabel.setText(pc.getName());
        enemyIconLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Enemies\\" + enemy.getName() + ".png"));
        playerIconLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\Characters\\" + pc.getArchetype() + ".png"));
        enemyHPNumLabel.setText(String.valueOf(enemy.getHP()));
        playerHPNumLabel.setText(String.valueOf(pc.getHP()));
        playerFPNumLabel.setText(String.valueOf(pc.getFP()));
        
        addElements();
        addAttackButtons();
        addActionEvents();
        setLabels();
    }
    
    private void addElements(){
       
        
        playerMovesLabel.setBounds(20, 10, 600, 60);
        playerMovesLabel.setText("Test");
        this.add(playerMovesLabel);
        
        enemyMovesLabel.setBounds(20, 70, 600, 60);
        enemyMovesLabel.setText("Test Label");
        this.add(enemyMovesLabel);
        
        enemyHPLabel.setBounds(640, 10, 80, 60);
        this.add(enemyHPLabel);
        
        enemyHPNumLabel.setBounds(640, 70, 80, 60);
        this.add(enemyHPNumLabel);
        
        enemyIconLabel.setBounds(740, 10, 120, 120);
        this.add(enemyIconLabel);
        
        enemyNameLabel.setBounds(880, 10, 120, 120);
        this.add(enemyNameLabel);
        
        backgroundLabel.setBounds(10, 140, 1170, 380);
        this.add(backgroundLabel);
        
        playerNameLabel.setBounds(20, 540, 120, 120);
        this.add(playerNameLabel);
        
        playerIconLabel.setBounds(160, 540, 120, 120);
        this.add(playerIconLabel);
        
        playerHPLabel.setBounds(300, 540, 80, 60);
        this.add(playerHPLabel);
        
        playerHPNumLabel.setBounds(300, 600, 80, 60);
        this.add(playerHPNumLabel);
        
        playerFPLabel.setBounds(390, 540, 80, 60);
        this.add(playerFPLabel);
        
        playerFPNumLabel.setBounds(390, 600, 80, 60);
        this.add(playerFPNumLabel);
    }
    
    private void addAttackButtons() {
        switch (pc.getArchetype()) {
            case "Warrior" -> {
                attack1Button.setText("Axe Slash");
                attack2Button.setText("Attack Boost");
                attack3Button.setText("Flurry Axtack");
                attack4Button.setText("Axecution");
            }
            case "Mage" -> {
                attack1Button.setText("Staff Whack");
                attack2Button.setText("Magic Missile");
                attack3Button.setText("Leech Life");
                attack4Button.setText("Fireball");
            }
            case "Paladin" -> {
                attack1Button.setText("Holy Smite");
                attack2Button.setText("Holy Healing");
                attack3Button.setText("Holy Light");
                attack4Button.setText("Holy Discombobulation");
            }
        }
        
        switch (pc.getLevel()) {
            case 1 -> {
                attack1Button.setVisible(true);
                attack2Button.setVisible(true);
                attack3Button.setVisible(false);
                attack4Button.setVisible(false);
            }
            case 2 -> {
                attack1Button.setVisible(true);
                attack2Button.setVisible(true);
                attack3Button.setVisible(true);
                attack4Button.setVisible(false);
            }
            case 3 -> {
                attack1Button.setVisible(true);
                attack2Button.setVisible(true);
                attack3Button.setVisible(true);
                attack4Button.setVisible(true);
            }
        }
        
        attack1Button.setBounds(480, 540, 240, 50);
        this.add(attack1Button);
        
        attack2Button.setBounds(730, 540, 240, 50);
        this.add(attack2Button);
        
        attack3Button.setBounds(480, 600, 240, 50);
        this.add(attack3Button);
        
        attack4Button.setBounds(730, 600, 240, 50);
        this.add(attack4Button);
    }
    
    private void addActionEvents(){
        attack1Button.addActionListener(this);
        attack2Button.addActionListener(this);
        attack3Button.addActionListener(this);
        attack4Button.addActionListener(this);
    }
    
    private void setLabels() {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if (e.getSource() == attack1Button) {
            if (rand.nextInt(6) == 0) {
                pc.setCurrentHP(pc.getCurrentHP() - (2 * enemy.getAtk()));
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + (2 * enemy.getAtk()) + " damage!");
            }
            else {
                pc.setCurrentHP(pc.getCurrentHP() - enemy.getAtk());
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + enemy.getAtk() + " damage!");
            }
            
            if (pc.getCurrentHP() <= 0) {
                // End Game
            }
            
            if (rand.nextInt(6) == 0) {
                enemy.setHP(enemy.getHP() - (2 * pc.getAtk()));
                playerMovesLabel.setText(pc.getName() + " attacked " + enemy.getName() + " for " + (2 * pc.getAtk()) + " damage!");
            }
            else {
                enemy.setHP(enemy.getHP() - pc.getAtk());
                playerMovesLabel.setText(pc.getName() + " attacked " + enemy.getName() + " for " + pc.getAtk() + " damage!");
            }
            
            // if 
        }
        else if (e.getSource() == attack2Button) {
            if (rand.nextInt(6) == 0) {
                pc.setCurrentHP(pc.getCurrentHP() - (2 * enemy.getAtk()));
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + (2 * enemy.getAtk()) + " damage!");
            }
            else {
                pc.setCurrentHP(pc.getCurrentHP() - enemy.getAtk());
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + enemy.getAtk() + " damage!");
            }
            
            this.revalidate();
            
            if (pc.getCurrentHP() <= 0) {
                // End Game
            }
        }
        else if (e.getSource() == attack3Button) {
            if (rand.nextInt(6) == 0) {
                pc.setCurrentHP(pc.getCurrentHP() - (2 * enemy.getAtk()));
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + (2 * enemy.getAtk()) + " damage!");
            }
            else {
                pc.setCurrentHP(pc.getCurrentHP() - enemy.getAtk());
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + enemy.getAtk() + " damage!");
            }
            
            this.revalidate();
            
            if (pc.getCurrentHP() <= 0) {
                // End Game
            }
            
        }
        else if (e.getSource() == attack4Button) {
            if (rand.nextInt(6) == 0) {
                pc.setCurrentHP(pc.getCurrentHP() - (2 * enemy.getAtk()));
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + (2 * enemy.getAtk()) + " damage!");
            }
            else {
                pc.setCurrentHP(pc.getCurrentHP() - enemy.getAtk());
                enemyMovesLabel.setText(enemy.getName() + " attacked " + pc.getName() + " for " + enemy.getAtk() + " damage!");
            }
            
            this.revalidate();
            
            if (pc.getCurrentHP() <= 0) {
                // End Game
            }
        }
    }
    
}
