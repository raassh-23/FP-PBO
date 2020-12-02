package id.ac.its.rauf140.daanii163.syamil196.project1;

import javax.swing.JOptionPane;

public class Project1Test {

	public static void main(String[] args) {
		String inShape = JOptionPane.showInputDialog("Masukkan bidang yang diinginkan (Rectangle, ...)");

		if (inShape.equals("Rectangle")) {
			String inLength = JOptionPane.showInputDialog("Masukkan panjang");
			String inWidth = JOptionPane.showInputDialog("Masukkan lebar");
			
			float length = Float.parseFloat(inLength);
			float width = Float.parseFloat(inWidth);

			Rectangle rect = new Rectangle(length, width);

			String output = String.format("Luasnya adalah %.3f satuan persegi dan kellingnya adalah %.3f satuan", rect.getArea(), rect.getPerimeter());

			JOptionPane.showMessageDialog(null, output , "Luas dan keliling", JOptionPane.PLAIN_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(null, "Input bidang salah");
		}
	}

}
