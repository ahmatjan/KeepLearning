#include <stdio.h>

int max(int a[100], int n)	//求最高层数
{
	int highest;
	int i;

	highest = a[0];

	for (i = 1; i < n; i++)
	{
		if (a[i] > highest)
			highest = a[i];
	}

	return highest;
}

int count_time(int n, int a[100], int highest)//计算每组测试需要的总时间
{
	int i, j;
	int flag;		//标记每层是否有人下
	int time;

	time = 0;
	for (i = 0; i <= highest; i++)	//计算每层花费时间
	{
		time += 6;
		flag = 0;
		for (j = 0; j < n; j++)		//计算每层每个人花费的时间
		{
			if (a[j] == i)
			{
				time += 1;
				flag = 1;
			}
		}
		if (flag)					//每层的开门时间
			time += 5;		
	}

	time += highest * 4;			//电梯下楼花费时间

	return time;
}

int main()
{
	int c, n, a[100], time;
	int i;
	int highest;	//要到的最高层

	scanf("%d", &c);

	while (c != 0)
	{
		time = 0;

		scanf("%d", &n);
		for (i = 0; i < n; i++)		//记录每个人要到的层数到a[i]
		{
			scanf("%d", &a[i]);
		}

		highest = max(a, n);

		time = count_time(n, a, highest);	//计算每组测试需要的总时间
		
		printf("%d\n", time-6);

		c--;
	}

	return 0;
}