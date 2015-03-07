/*
    2012年2月13日14:46:21
	字符串的存储和输出
*/
# include <stdio.h>

int main()
{
	char st[15];
	printf("Input string:");
	gets(st);
	puts(st);

	return 0;
}
/*
     字符串的录入：
	 3.char * st = "C language";
	 7.char * st;
	   st = "C language"                      PS:这就是传说中的字符串指针存储, 【char * st】等价于 【char st[]】;
     4.char c[] = "C program";                PS:实际存储的是"C program\0"

	
	 5.char st[15];                      
	   scanf("%s",st);
	 6.char st[15];
	   gets(st);							  PS:scanf和gets的区别：scanf遇空格结束，gets遇换行结束




	 字符串的输出：
	 1.printf("%s\n",c);
	 2.puts(c);                               PS：输出字符串后，会自动加换行；
	 
*/

/*
	2012年11月20日22:09:19感悟

	C语言中字符串存储主要采用字符数组：
	申请空间：  char st[15];    char st[];   char * st;
	赋值：		第一种直接赋值或scanf皆可
				第二三中必须直接赋值，不能scanf
*/