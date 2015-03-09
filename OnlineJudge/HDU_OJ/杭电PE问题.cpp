/*
    2012年3月14日20:29:07(憋了一晚上啊~~)
	使每个输出结果之间存在一个空格，但最后一个结果后没有空格；
	解决了杭电ACM  PE的问题
*/
#include <stdio.h>

int main(void)
{
	int m, n, i, s, a, b, c, array[100], t;

	while (scanf("%d %d", &m, &n) != EOF)
	{
		s = 0;
	
		//判断水仙花数，并把其值赋给数组
		for (i = m; i <= n; i++)
		{
			a = i / 100;
			b = (i / 10) % 10;
			c = i % 10;
			if (i == (a*a*a + b*b*b + c*c*c))
			{
				array[s++] = i;
			}
		}

		//如果没有水仙花数，输出no，并跳出；
		if (s == 0)
		{
			printf("no\n");
		}

		//如果有水仙花数，则前几个数，输出 数+空格；最后一个数输出，然后后面加换行
		for (i = 0; i < s; i++)
		{
			if (i == (s-1))
			printf("%d\n", array[i]);
			else printf("%d ", array[i]);
		}
	}

	return 0;
}

/*
    PS：要想解决这种问题，尽量将结果与数组联系起来
	    即，将每个结果放入数组的一个元素中，然后
		for (i = 0; i < s; i ++)
		{
		   if (i == s-1)
		       printf...
		   else 
		       printf ....
		}
*/