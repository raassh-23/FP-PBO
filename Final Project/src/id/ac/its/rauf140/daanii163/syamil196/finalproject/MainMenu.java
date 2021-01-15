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

public class MainMenu extends Menu {
    public MainMenu() {
        JButton playButton = new JButton("Play");
        JButton creditButton = new JButton("Credit");

        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CandyCatch.cardLayout.show(CandyCatch.mainPanel, "level");
            }
            
        });

        creditButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CandyCatch.cardLayout.show(CandyCatch.mainPanel, "credit");
            }
            
        });
    
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        add(playButton, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(15,0,0,0);
        add(creditButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bg, 0, 0, this);

        String title = "Candy Catch";
        Font fontTitle = new Font("Helvetica", Font.BOLD, 36);
        FontMetrics fmTitle = getFontMetrics(fontTitle);

        g.setColor(Color.WHITE);
        g.setFont(fontTitle);
        g.drawString(title, (CandyCatch.WIDTH - fmTitle.stringWidth(title)) / 2, 200);
    }
}
