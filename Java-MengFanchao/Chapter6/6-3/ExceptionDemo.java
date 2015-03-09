class MyException extends Exception
{
	private int detail;

	MyException(int a)
	{
		detail = a;
	}

	public String toString()
	{
		return ("MyException[" + detail + "]");
	}
}

public class ExceptionDemo
{
	static void compute(int num) throws MyException
	{
		System.out.println("compute(" + num + ")");
		if (num > 10)	
			throw new MyException(num);
		else
			System.out.println("Exited normally.");
	}

	static public void main(String args[])
	{
		try
		{
			compute(1);
			compute(20);
		}
		catch (MyException e)
		{
			System.out.println(e);
		}
	}
}
