package id.ac.its.Syamil196.project1;

import javax.swing.JOptionPane;

public class Project1Test {

	public static void main(String[] args) {
			String inRadius = JOptionPane.showInputDialog("Masukkan Radius");
			
			float radius =  Float.parseFloat(inRadius);
			
			Circle crcl = new Circle(radius);
			
			String output = String.format("Luasnya adalah %.3f satuan persegi dan kelilingnya adalah %.3f satuan persegi", crcl.getArea(), crcl.getPerimeter());
			
			JOptionPane.showMessageDialog( null, output, "Luas dan keliling", JOptionPane.PLAIN_MESSAGE);
	}
	
}
