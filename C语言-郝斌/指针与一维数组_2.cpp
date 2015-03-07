/*
时间：2012年1月29日21:39:22
功能：在函数中一次改写（返回）数组元素值。
目的：掌握指针在数组中的应用。
*/
# include<stdio.h>

void f(int * pArr,int len)
{
	pArr[3] = 88;
}

int main(void)
{
	int a[5] = {1,2,3,4,5};

	printf("%d\n",a[3]);
	f(a,5);
	printf("%d\n",a[3]);

	return 0;
}