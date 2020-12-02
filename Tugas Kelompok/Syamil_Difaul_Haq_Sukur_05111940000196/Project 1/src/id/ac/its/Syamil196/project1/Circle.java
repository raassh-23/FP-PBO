package id.ac.its.Syamil196.project1;

public class Circle extends Shape {
	
	protected double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public Circle() {
		this.radius = 0.0;
	}
	
	public Circle(double radius) {
		this.radius=radius;
	}
	
	@Override
	public double getArea() {
		return 3.14*this.radius*this.radius;
	}

	@Override
	public double getPerimeter() {
		return 2*3.14*this.radius;
	}
	
}
