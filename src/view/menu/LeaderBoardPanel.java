package view.menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


/**
 *
 * @author Michael Hood
 */
public class LeaderBoardPanel extends JPanel implements ActionListener {
    
    private final MenuFrame parentFrame;
    
    // Components
    private final DefaultListModel listModel = new DefaultListModel();
    
    private final JLabel descLabel = new JLabel("LeaderBoard");
    private final JButton returnButton = new JButton("<- Return");
    private final JList list = new JList(listModel); 
    private final JScrollPane listScroller = new JScrollPane(list);


    public LeaderBoardPanel(MenuFrame parentFrame){
        
        this.parentFrame = parentFrame;
       
        
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);
        
        listScroller.setPreferredSize(new Dimension(25, 700));
        list.setFont(new Font("Verdana", Font.BOLD, 15));
        
        descLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        
        returnButton.setFont(new Font("Verdana", Font.BOLD, 10));
        returnButton.setBackground(Color.RED);
        returnButton.setForeground(Color.WHITE);
        
        addElements();
        addActionEvents();
        
    }
    
        public void setList(){                               
            Scanner console = new Scanner(System.in);
            try
            {
            FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\view\\menu\\LeaderBoard.txt"); 
            Scanner inFile = new Scanner(fr); 
            String line;
            line = inFile.nextLine();
            listModel.addElement(line);
            }
            catch (FileNotFoundException ex)   {
                  }

            }
        
    
        private void addElements() {
        
        this.add(returnButton);
        this.add(descLabel);
        this.add(list);
        
        returnButton.setBounds(600, 30, 50, 10);
        descLabel.setBounds(700, 20, 150, 10);
        list.setBounds(400, 300, 20, 400);
        
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
            parentFrame.openTitle();
        }
    }
    
    
    
}
