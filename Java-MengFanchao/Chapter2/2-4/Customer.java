class Customer
{
	String name, address, telephone;
	String getName()
	{
		return name;
	}
	void setName(String name)
	{
		this.name = name;
	}	
	String getAddress()
	{
		return address;
	}
	void setAddress(String address)
	{
		this.address = address;
	}
	String getTelephone()
	{
		return telephone;
	}
	void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}


	public static void main(String args[])
	{
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		
		customer1.setName("Zhang Feng");
		customer1.setAddress("# 130 Nan Road");
		customer1.setTelephone("022-23503545");

		customer2.setName("Jin Wei");
		customer2.setAddress("# 130 Bei Road");
		customer2.setTelephone("022-23503546");

		System.out.print("The first customer name:");
		System.out.println(customer1.getName());
		System.out.print("The first customer address:");
		System.out.println(customer1.getAddress());
		System.out.print("The first customer telephone:");
		System.out.println(customer1.getTelephone());
	
		System.out.print("The second customer name:");	
		System.out.println(customer2.getName());
		System.out.print("The second customer address:");
		System.out.println(customer2.getAddress());
		System.out.print("The second customer telephone:");
		System.out.println(customer2.getTelephone());
	}
}
