/*
2013年3月23日16:54:09
HDU OJ 4509
也是 腾讯马拉松 2月21日 第5题
*/
#include <stdio.h>

bool is_later(int h1, int m1, int h, int m)	//判断某时间点是否在开始时间点后
{
	if ((h>h1) || ((h==h1)&&(m>=m1)))
		return true;
	else
		return false;
}

bool is_former(int h2, int m2, int h, int m)	//判断某时间点是否在结束时间点前
{
	if ((h<h2) || ((h==h2)&&(m<m2)))
		return true;
	else 
		return false;
}

bool is_invade(int h1, int m1, int h2, int m2, int h, int m) //判断改时间点是否被这件事占用
{
	if (is_later(h1, m1, h, m) && is_former(h2, m2, h, m))
		return true;
	else
		return false;
}

int main()
{
	int n, i, j;
	int h1, m1, h2, m2, h, m;
	int time[24][60];
	int free_time;

	while (scanf("%d", &n) != EOF)
	{
		for (i = 0; i < 24; i++)	//标志量初始化，表示每个时间点未被占用
		{
			for (j = 0; j < 60; j++)
			{
				time[i][j] = 0;
			}
		}

		for (i = 0; i < n; i++)		//对每件事进行分析，看它占用了哪些时间点
		{
			scanf("%d:%d %d:%d", &h1, &m1, &h2, &m2);
			for (h = 0; h < 24; h++)
			{
				for (m = 0; m < 60; m++)
				{
					if (time[h][m] == 0)
					{
						if (is_invade(h1, m1, h2, m2, h, m))
							time[h][m] = 1;
					}
				}
			}
		}

		free_time = 0; 
		for (h = 0; h < 24; h++)	//统计空余时间
		{
			for (m = 0; m < 60; m++)
			{
				if (!time[h][m])
					free_time++;
			}
		}

		printf("%d\n", free_time);
	}


	return 0;
}

/*
思路：
	该题采用了 标记量 的方式，来标记哪些时间被占用，哪些未被占用。

总结：
	1. 确定了 内联函数 确实能用，但是发现 是否是内联函数 运行时间一样长!
	2. 确定了 bool类型 确实能用。
	3. 当初没有做出来的原因：
		① 审题错误，导致第一回思路错误
		② 想采用更好算法，导致 逻辑过于复杂，程序出现了错误。
	4. 这回 花了一个小时 才做出来， 原因：
		程序出了错误，调试了半天。
	错误原因：
		① 把 == 写成了 =
		② bool 变量 默认返回 true，因此需要考虑返回 false情况。
*/