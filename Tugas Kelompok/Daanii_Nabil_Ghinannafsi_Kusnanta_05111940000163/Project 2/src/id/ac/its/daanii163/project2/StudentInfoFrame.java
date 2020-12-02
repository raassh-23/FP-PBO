package id.ac.its.daanii163.project2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class StudentInfoFrame extends JFrame {
    private final JLabel student;

    public StudentInfoFrame() {
        super("Student Information");
        setLayout(new FlowLayout());

        Icon photo = new ImageIcon(getClass().getResource("photo.png"));
        student = new JLabel();
        student.setText("<html>Daanii Nabil Ghinannafsi Kusnanta<br>05111940000163</html>");
        student.setIcon(photo);;
        student.setHorizontalTextPosition(SwingConstants.RIGHT);
        student.setVerticalTextPosition(SwingConstants.TOP);
        student.setToolTipText("Daanii Nabil Ghinannafsi Kusnanta");
        add(student);
    }
}
