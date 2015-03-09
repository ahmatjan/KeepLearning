/*
    2012年4月14日15:02:35
    删除数组元素；qsort的使用；及问号的使用；
	基于杭电2034题，地址：http://acm.hdu.edu.cn/showproblem.php?pid=2034
*/
# include <stdio.h>
# include <stdlib.h>

int comp(const int *a, const int *b)
{
    return *a - *b;
}

int main()
{
	int n, m, i, j, temp, st[200];
	
	while (scanf("%d%d", &n, &m), m * n)
	{
		for (i = 0; i < n; i++)
		{
			scanf("%d", st + i);
		}
		for (i = 0; i < m; i++)
		{
			scanf("%d", &temp);
			for (j = 0; j < n; j++)
			{
				if (st[j] == temp)
					st[j] = st[--n];//删除数组元素：最漂亮的一句
			}
		}
        for (i = 0; i < n - 1; i++)
		{
			for (j = 0; j < n - 1 - i; j++)
			{
				if (st[j] > st[j + 1])
				{
					temp = st[j];
					st[j] = st[j + 1];
					st[j + 1] = temp;
				}
			}
		}
        for (i = 0; i < n; i++)
            printf("%d ", st[i]);
        printf(n ? "\n" : "NULL\n");//条件运算符：?
    }
	
	return 0;
}
/*
     1.删除数组元素：
			for (j = 0; j < n; j++)
			{
				if (st[j] == temp)
					st[j] == st[--n];
			}

	 2.该运算符是 ? :
　　       表达式为：表达式1？表达式2：表达式3 
   　　    先求解表达式1， 　　
           若其值为真（非0）则将表达式2的值作为整个表达式的取值， 　　
	       否则（表达式1的值为0）将表达式3的值作为整个表达式的取值。 　　
	       例如: 　　max=(a>b)?a:b 　　就是将a和b二者中较大的一个赋给max。
*/