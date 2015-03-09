/*
    2012年4月5日13:25:55
	探究循环算法的最优化，基于杭电2028题
*/
#include <stdio.h>
/********************************************************/
/*亮点在此处:求两个数的最大公约数*/
long gcd(long n, long m)
{
	int c;

	c = n % m;
	while (c != 0)
	{
		n = m;
		m = c;
		c = n % m;
	}
	return m;
}
/*
更优算法：
long gcd(long n, long m) 
{
    if (m == 0)
	    return 0;
	else
	    gcd(m, n % m)      //用的是一个递归函数
}

*/
/*********************************************************/

int main()
{
	int n, i;
	long st[10000], min, max;

	while (scanf("%d", &n) != EOF)
	{   /*把数据输入到数组中*/
		for (i = 0; i < n; i++)
		{
			scanf("%ld",&st[i]);
		}
		/*循环结构求最大公约数及最小公倍数*/
		max = min = st[0];
		for (i = 1; i < n; i++)
		{
			min = gcd(min, st[i]);
			max *= st[i];
		}
		max = max / min;
		/*输出结果*/
		printf("%ld\n", max);
	}

	return 0;
}