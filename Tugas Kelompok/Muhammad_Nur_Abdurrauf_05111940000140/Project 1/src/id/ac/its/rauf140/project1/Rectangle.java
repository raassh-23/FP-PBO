package id.ac.its.rauf140.project1;

public class Rectangle {
	
	protected double length;
	protected double width;
	
	public Rectangle() {
		this.length = 0.0;
		this.width = 0.0;
	}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		return this.length * this.width;
	}
	
	public double getPerimeter() {
		return 2 * (this.length + this.width);
	}
}
