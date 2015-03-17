/*
    2012年9月22日11:34:33
	通过汉诺塔，练习递归算法
*/
#include <stdio.h>

void hannuota(int n, char A, char B, char C)//把n个盘子从A通过B，移动到C上
{
	/*
	如果（n为1）
		把编号为1的盘子从A直接移动到C上
	否则
	    把n-1个盘子从A通过C移动到B上
		把编号为n的盘子从A直接移动到C上
		把n-1个盘子从B通过A移动到C上
	*/

	if (1 == n)
		printf("把编号为%d的盘子从%c直接移动到%c上\n", n, A, C);
	else
	{
		hannuota(n-1, A, C, B);
		printf("把编号为%d的盘子从%c直接移动到%c上\n", n, A, C);
		hannuota(n-1, B, A, C);
	}
}


int main()
{
	int n;
	char ch1 = 'A';
	char ch2 = 'B';
	char ch3 = 'C';

	printf("请输入n的值：\n");
	scanf("%d", &n);
	hannuota(n, ch1, ch2, ch3);

	return 0;
}