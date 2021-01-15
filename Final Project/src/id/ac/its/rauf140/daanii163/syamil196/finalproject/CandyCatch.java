package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;

public class CandyCatch extends JFrame{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    public CandyCatch() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new LevelHard());
        
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

//     public static void main(String[] args) {
//         HighscoreManager hm = new HighscoreManager("highscoreTest.ser");
//
//         Scanner scanner = new Scanner(System.in);
//
//         System.out.print(hm.getHighscoreString());
//
//         while (scanner.hasNextLine()) {
//             String name = scanner.nextLine();
//             int score = Integer.parseInt(scanner.nextLine());
//
//             hm.addScore(name, score);
//             System.out.print(hm.getHighscoreString());
//        
//         }
//     }
}
