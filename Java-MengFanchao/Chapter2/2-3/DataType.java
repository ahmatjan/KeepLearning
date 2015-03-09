import java.util.*;

public class DataType
{
	public static void main(String args[])
	{
		boolean	flag;
		char 		yeschar;
		byte 			finbyte;
		int			intvalue;
		short		shortvalue;
		long			longvalue;
		float			floatvalue;
		double		doublevalue;
		
		flag = true;
		yeschar = 'y';
		finbyte = 30;
		intvalue = -70000;
		shortvalue = 20000;
		longvalue = 2001;
		floatvalue = 9.997E-5f;
		doublevalue = floatvalue * floatvalue;
		
		System.out.println("The values are:");
		System.out.println("布尔型变量	flag = " + flag);
		System.out.println("字符类型变量yeschar = " + yeschar);
		System.out.println("字节类型变量 finbye = " + finbyte);
		System.out.println("整型变量		intvalue = " + intvalue);
		System.out.println("段整型变量	shortvalue = " + shortvalue);
		System.out.println("长整型变量	longvalue = " + longvalue);
		System.out.println("浮点型变量	floatvalue = " + floatvalue);
		System.out.println("双精度变量	doublevalue = " + doublevalue);
	}
}
//靠
