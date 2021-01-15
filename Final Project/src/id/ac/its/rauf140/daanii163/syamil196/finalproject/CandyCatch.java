package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CandyCatch extends JFrame{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;
    public static CardLayout cardLayout;
    public static JPanel mainPanel;

    public CandyCatch() {
        
        initUI();
    }
    
    private void initUI() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new MainMenu(), "title");
        mainPanel.add(new LevelSelect(), "level");
        mainPanel.add(new CreditPage(), "credit");
        
        add(mainPanel);
        
        setResizable(false);
        pack();
        
        setTitle("Candy Catch");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
        	CandyCatch ex = new CandyCatch();
            ex.setVisible(true);
        });
    }
}
