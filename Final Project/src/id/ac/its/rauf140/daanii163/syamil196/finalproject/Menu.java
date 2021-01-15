package id.ac.its.rauf140.daanii163.syamil196.finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu extends JPanel {
    protected Image bg;

    public Menu() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(CandyCatch.WIDTH, CandyCatch.HEIGHT));
        bg = new ImageIcon("src/resources/bgNormal.png").getImage();
    }

}
