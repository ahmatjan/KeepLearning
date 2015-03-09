public class Date
{
	int day, month, year;
	
	Date()
	{
		day = 1;
		month = 1;
		year = 1998;
	}

	Date(int i, int j, int k)
	{
		day = i;
		month = j;
		year = k;
	}

	public void setDate(int i, int j, int k)
	{
		day = i;
		month = j;
		year = k;
	}

	public void printDate()
	{
		System.out.println(day + "/" + month + "/" + year);
	}

	static public void main(String args[])
	{
		Date d = new Date();

		d.printDate();
		d.setDate(2, 5, 1992);
		d.printDate();
	}
}

