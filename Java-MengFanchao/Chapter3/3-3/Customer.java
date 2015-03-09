/*
	说明变量屏蔽及作用域实例
*/
public class Customer
{
	private String name;
	
	public static void main(String args[])
	{
		Customer customer = new Customer();
		{
			String name = "Tom David";
			customer.name = name;		
			System.out.println("The customer's name:" + customer.name);
		}
		//下列说明是正确的
		String name = "Jahon Smith";
		customer.name = name;
		System.out.println("The customer's name:" + customer.name);

	}
}
