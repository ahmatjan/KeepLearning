/*
    2012年4月1日0:16:27
	探究scanf 与 gets 的 返回值 问题。
*/
#include <stdio.h>

int main()
{
	char st[100];
	int i;

	while (gets(st) != 0)
	{
		/*进行大小写转换*/
		st[0] -= 32;
		for (i = 0; st[i] != '\0'; i++)
		{
			if (st[i] == ' ')
				st[i+1] -= 32;
		}
		/*进行输出*/
		puts(st);
	}
	
	return 0;
}
/*
    scanf返回值：函数返回成功赋值的数据项数，读到文件末尾出错时则返回EOF。
	gets返回值：读入成功，返回与参数buffer相同的指针；读入过程中遇到EOF或发生
	            错误，返回NULL指针。
*/