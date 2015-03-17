/*
    2012年2月15日16:29:45
	构造、使用、释放动态一维数组
*/
# include <stdio.h>
# include <malloc.h>

int main(void)
{
	int a[5];//静态构造的一维数组：共占用20个字节，每4个字节组成一个元素，函数运行结束后，空间自动释放。
	int len;
	int * pArr;
	int i;

	//构造动态一维数组
	printf("请输入数组元素数：");
	scanf("%d",&len);
	pArr = (int *)malloc(4 * len);//动态构造一维数组：数组名叫pArr，有len个元素。该行效果类似于int pArr[len];

	//输入一位数组各元素
	printf("请输入数组元素：\n");
	for (i=0;i<len;++i)
		scanf("%d",&pArr[i]);

	//输出一维数组各元素
	printf("数组各元素如下：\n");
	for (i=0;i<len;++i)
		printf("%d ",pArr[i]);

	//扩大或缩小数组
	printf("\n");
	realloc(pArr,100);

    //释放动态一维数组
	free(pArr);

	return 0;
}