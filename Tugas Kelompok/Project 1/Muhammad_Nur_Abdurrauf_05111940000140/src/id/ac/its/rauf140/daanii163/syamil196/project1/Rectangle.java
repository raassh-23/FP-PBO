package id.ac.its.rauf140.daanii163.syamil196.project1;

public class Rectangle extends Shape {
	
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
	
	@Override
	public double getArea() {
		return this.length * this.width;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (this.length + this.width);
	}
}
