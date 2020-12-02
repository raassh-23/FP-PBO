package id.ac.its.daanii163.project1;

public class Triangle {
    private double a, b, c, s;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = (a + b + c) / 2;
    }

    public Triangle() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.s = 0;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getArea() {
        return Math.sqrt(this.s * (this.s - this.a) * 
                (this.s - this.b) * (this.s - this.c));
	}
	
	public double getPerimeter() {
		return this.a + this.b + this.c;
	}
}
