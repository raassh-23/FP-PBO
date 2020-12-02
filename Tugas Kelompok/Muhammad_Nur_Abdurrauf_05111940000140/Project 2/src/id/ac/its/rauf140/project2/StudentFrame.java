package id.ac.its.rauf140.project2;

import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StudentFrame extends JFrame {
    private final JLabel student;

    public StudentFrame() {
        setLayout(new FlowLayout());

        student = new JLabel();
        Icon photo = new ImageIcon(getClass().getResource("photo.png"));
        student.setIcon(photo);
        student.setText("<html>Nama: Muhammad Nur Abdurrauf<br>NRP: 05111940000140</html>");
        student.setHorizontalTextPosition(SwingConstants.CENTER);
        student.setVerticalTextPosition(SwingConstants.BOTTOM);
        student.setToolTipText("Muhammad Nur Abdurrauf");
        add(student);
    }
}
