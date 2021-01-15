package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LevelSelect extends Menu {

    public LevelSelect() {
        JButton easyButton = new JButton("easy");
        JButton normalButton = new JButton("normal");
        JButton hardButton = new JButton("hard");
        JButton backButton = new JButton("back");

        easyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CandyCatch.cardLayout.show(CandyCatch.mainPanel, "levelEasy");
            }
            
        });

        normalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CandyCatch.cardLayout.show(CandyCatch.mainPanel, "levelNormal");
            }
            
        });

        hardButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CandyCatch.cardLayout.show(CandyCatch.mainPanel, "levelHard");
            }
            
        });

        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CandyCatch.cardLayout.show(CandyCatch.mainPanel, "title");
            }
            
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        add(easyButton, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(15,0,0,0);
        add(normalButton, gbc);

        gbc.gridy = 2;
        add(hardButton, gbc);

        gbc.gridy = 3;
        add(backButton, gbc);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bg, 0, 0, this);

        String title = "Choose Difficulty";
        Font fontTitle = new Font("Helvetica", Font.BOLD, 36);
        FontMetrics fmTitle = getFontMetrics(fontTitle);

        g.setColor(Color.WHITE);
        g.setFont(fontTitle);
        g.drawString(title, (CandyCatch.WIDTH - fmTitle.stringWidth(title)) / 2, 200);
    }
}
