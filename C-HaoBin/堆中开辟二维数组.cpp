/*
	2012年11月26日20:42:45
	在堆中开辟 5*5 二维数组
*/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

int main()
{

	int ** p;
	int i, j;
	/*动态申请二维数组空间*/
	p = (int **)malloc(5 * sizeof(int *));
	if (NULL == p)
	{
		printf("动态内存分配失败！\n");
		exit(-1);
	}
	for (i = 0; i < 5; i++)
	{
		p[i] = (int *)malloc(5 * sizeof(int));
		if (NULL == p[i])
		{
			printf("动态内存分配失败！\n");
			exit(-1);
		}
	}

	/*二维数组赋值并输出*/
	for (i = 0; i < 5; i++)
	{
		for (j = 0; j < 5; j++)
		{
			p[i][j] = 5 * i + j;
			printf(" %2d", p[i][j]);
		}
		printf("\n");
	}
	printf("\n");

	/*释放二维数组所占空间*/
	for (i = 0; i < 5; i ++)
		free(p[i]);
	free (p);

	return 0;
}