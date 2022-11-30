
package cs321_team2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import view.menu.*;

/**
 *
 * @author hoods
 */
public class Battle_Scene extends JPanel implements ActionListener {
    
    private final MenuFrame parentFrame;
    
    
    private final JButton fight = new JButton("Fight");
    private final JButton run = new JButton("Retreat");
    private final JButton pReturn = new JButton("Back");
    private final JPanel atw = new JPanel();
    private final JButton att1 = new JButton("att1");
    private final JButton att2 = new JButton("att2");
    private final JButton att3 = new JButton("att3");
    
    public Battle_Scene(MenuFrame parentFrame){
        
        this.parentFrame = parentFrame;
        this.setLayout(null);
        
        att1.setFont(new Font("Verdana", Font.BOLD, 20));
        att1.setBackground(Color.RED);
        att1.setForeground(Color.WHITE);
        
        att2.setFont(new Font("Verdana", Font.BOLD, 20));
        att2.setBackground(Color.RED);
        att2.setForeground(Color.WHITE);
        
        att3.setFont(new Font("Verdana", Font.BOLD, 20));
        att3.setBackground(Color.RED);
        att3.setForeground(Color.WHITE);
        
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
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        atw.add(att3, gbc);
        
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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource().equals(fight)){
            atw.setVisible(true);
            
        }
        if(e.getSource().equals(pReturn)){
            atw.setVisible(false);
        }
    }
    
}
