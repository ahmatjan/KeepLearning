public class Point
{
	void print()
	{
		System.out.println("This is the superclass!");
	}

	static public void main(String args[])
	{
		Point superp = new Point();

		superp.print();
		superp = new Point3d();
		superp.print();
	}
}

class Point3d extends Point
{
	void print()
	{
		System.out.println("This is the subclass!");
	}
}
