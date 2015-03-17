/*
时间：2012年1月29日21:39:22
功能：通过指针使函数输出数组中元素的值。
目的：掌握指针在数组中的应用。
*/
# include<stdio.h>

void f(int * pArr,int len)//因为数组名是个指针常量，所以有个形参是指针变量。
{
	int i;
	for(i=0;i<len;i++)
		printf("%d ",pArr[i]);//pArr[i]=*(pArr+i)
	printf("\n");
}
//确定一个一维数组需要两个参数：一个是指针变量；一个是数组长度。

int main(void)
{
	int a[5] = {1,2,3,4,5};
	int b[5] = {-1,-2,-3,-4,-5};

	f(a,5);
	f(b,6);

	return 0;
}
