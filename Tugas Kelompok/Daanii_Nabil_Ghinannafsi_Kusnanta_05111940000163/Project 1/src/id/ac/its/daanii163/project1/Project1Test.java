package id.ac.its.daanii163.project1;

import javax.swing.JOptionPane;

public class Project1Test {
    public static void main (String[] args) {
        String inA = JOptionPane.showInputDialog("Masukkan sisi A segitiga :");
        String inB = JOptionPane.showInputDialog("Masukkan sisi B segitiga :");
        String inC = JOptionPane.showInputDialog("Masukkan sisi C segitiga :");
        
        float a = Float.parseFloat(inA);
        float b = Float.parseFloat(inB);
        float c = Float.parseFloat(inC);

        Triangle triangle = new Triangle(a, b, c);

        String output = String.format("Luas segitiga adalah %.3f satuan persegi dan kelilingnya adalah %.3f satuan", 
                triangle.getArea(), triangle.getPerimeter());

        JOptionPane.showMessageDialog(null, output , "Luas dan Keliling Segitiga", JOptionPane.PLAIN_MESSAGE);   
    }
}
