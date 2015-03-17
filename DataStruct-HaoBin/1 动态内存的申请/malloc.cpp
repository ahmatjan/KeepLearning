#include <stdio.h>
#include <malloc.h>

int main()
{
	/*静态分配内存*/
	int a[5] = {5, 34, 2, 5, 8};

	/*动态分配内存*/
	printf("请输入数组的元素数，len = ");
	int len;
	scanf("%d", &len);
	int * pArr = (int *)malloc(sizeof(int) * len);
	    /*malloc申请了一部分的内存，需要用(int *)强制类型转换：因为malloc返回的是一个字节首地址，并不能确定一个
	     一个变量占几个字节。*/
	printf("请输入%d个元素：", len);
	for(int i = 0; i < len; i++)
		scanf("%d", pArr + i);
	for(i = 0; i < len; i++)
		printf("%d ",*(pArr + i));
	free(pArr);
	printf("\n");

	return 0;
}