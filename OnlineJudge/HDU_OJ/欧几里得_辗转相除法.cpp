/*
    2012��4��5��13:25:55
	̽��ѭ���㷨�����Ż������ں���2028��
*/
#include <stdio.h>
/********************************************************/
/*�����ڴ˴�:�������������Լ��*/
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
�����㷨��
long gcd(long n, long m) 
{
    if (m == 0)
	    return 0;
	else
	    gcd(m, n % m)      //�õ���һ���ݹ麯��
}

*/
/*********************************************************/

int main()
{
	int n, i;
	long st[10000], min, max;

	while (scanf("%d", &n) != EOF)
	{   /*���������뵽������*/
		for (i = 0; i < n; i++)
		{
			scanf("%ld",&st[i]);
		}
		/*ѭ���ṹ�����Լ������С������*/
		max = min = st[0];
		for (i = 1; i < n; i++)
		{
			min = gcd(min, st[i]);
			max *= st[i];
		}
		max = max / min;
		/*������*/
		printf("%ld\n", max);
	}

	return 0;
}