package id.ac.its.rauf140.project1;

import javax.swing.JOptionPane;

public class Project1Test {
	public static void main(String[] args) {
			String inLength = JOptionPane.showInputDialog("Masukkan panjang persegi empat");
			String inWidth = JOptionPane.showInputDialog("Masukkan lebar persegi empat");
			
			float length = Float.parseFloat(inLength);
			float width = Float.parseFloat(inWidth);

			Rectangle rect = new Rectangle(length, width);

			String output = String.format("Luas persegi empat adalah %.3f satuan persegi dan kellingnya adalah %.3f satuan", rect.getArea(), rect.getPerimeter());

			JOptionPane.showMessageDialog(null, output , "Luas dan keliling persegi empat", JOptionPane.PLAIN_MESSAGE);
	}

}
