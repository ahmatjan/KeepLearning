interface Shape2D
{
	double pi = 3.14;
	double area();
}

class Circle implements Shape2D
{
	private double radius;

	public Circle(double r)
	{
		radius = r;
	}

	public double area()
	{
		return (pi * radius * radius);
	}
}

class Rectangle implements Shape2D
{
	private int width, height;

	public Rectangle(int w, int h)
	{
		width = w;
		height = h;
	}

	public double area()
	{
		return (width * height);
	}
}

public class InterfaceTester
{
	static public void main(String args[])
	{
		Circle cir = new Circle(3);
		System.out.println("The area of circle is:" + cir.area());
		Rectangle rect = new Rectangle(3, 4);
		System.out.println("The area of rectangle is:" + rect.area());
	}
}
