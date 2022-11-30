
package cs321_team2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import view.menu.*;
import view.game.*;

/**
 *
 * @author hoods
 */
public class Battle_Scene extends JPanel implements ActionListener {
    
    private final DungeonFrame parentFrame;
    
    
    private final JButton fight = new JButton("Fight");
    private final JButton run = new JButton("Retreat");
    private final JButton pReturn = new JButton("Back");
    private final JPanel atw = new JPanel();
    private final JButton att1 = new JButton("Attack");
    private final JButton att2 = new JButton("Heal");
    private JLabel gobname = new JLabel("");
    private JLabel plname = new JLabel("");
    private JLabel gobhp= new JLabel("");
    private JLabel plhp = new JLabel("");
    private PlayerCharacter plch;
    private Enemy gob;
    
    public Battle_Scene(DungeonFrame parentFrame, PlayerCharacter pc, Enemy enemy){
        
        PlayerCharacter plch = pc;
        Enemy gob = enemy;

        this.parentFrame = parentFrame;
        this.setLayout(null);
        
        if(enemy.getAtk() == 10){
            gobname.setName("Goblin");
           // gobhp.setName(enemy.getHP());
        }else{
            gobname.setName("HobGoblin");
           // gobhp.setName(enemy.getHP());
        }
        
        att1.setFont(new Font("Verdana", Font.BOLD, 20));
        att1.setBackground(Color.RED);
        att1.setForeground(Color.WHITE);
        
        att2.setFont(new Font("Verdana", Font.BOLD, 20));
        att2.setBackground(Color.RED);
        att2.setForeground(Color.WHITE);
        
        fight.setFont(new Font("Verdana", Font.BOLD, 20));
        fight.setBackground(Color.RED);
        fight.setForeground(Color.WHITE);
        
        pReturn.setFont(new Font("Verdana", Font.BOLD, 20));
        pReturn.setBackground(Color.RED);
        pReturn.setForeground(Color.WHITE);
        
        run.setFont(new Font("Verdana", Font.BOLD, 20));
        run.setBackground(Color.RED);
        run.setForeground(Color.WHITE);
        
        addElements();
        addActionEvents();
    }
    
    private void addElements(){
        
        GridBagConstraints gbc;
        atw.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridy = 3;
        gbc.ipadx = 3;
        atw.add(pReturn, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        atw.add(att1, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        atw.add(att2, gbc);
        
        this.add(fight);
        this.add(run);
        this.add(atw);
        atw.add(pReturn);
        atw.setVisible(false);

        atw.setBounds(400,550,425,100);
        fight.setBounds(920,550,150,50);
        run.setBounds(920,600,150,50);
        
        ImageIcon bg = new ImageIcon(System.getProperty("user.dir") + "\\src\\cs321_team2\\background\\background.png");
        JLabel back = new JLabel(bg);
        this.add(back);
        back.setBounds(0,0,1200,700);
        back.setFocusable(false);  
    }
    
    private void addActionEvents(){
        fight.addActionListener(this);
        run.addActionListener(this);
        pReturn.addActionListener(this);
        att1.addActionListener(this); 
        att2.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource().equals(fight)){
            atw.setVisible(true);
        }
        if(e.getSource().equals(pReturn)){
            atw.setVisible(false);
        }
        if(e.getSource().equals(att1)){
           // = gob.getHP();
          // hp = hp - plch.getAtk();
        }
          if(e.getSource().equals(att2)){
           //int ph = 
    }
    
}
}