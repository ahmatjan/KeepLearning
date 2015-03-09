/*
	2012年10月11日开始做
	2012年10月16日21:16:49 AC。。。OrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrzOrz
	Current time！！！！！！！！！！！！！！
*/
#include <stdio.h>

int compute(int s, int d);

int main()
{
	int s, d;

	while (1)
	{
		scanf("%d %d",&s, &d);
		if (s==0 && d==0)
			return 0;

		if (compute(s, d+1) == -1)
			printf("Impossible\n");
		else
			printf("%d\n", compute(s, d+1));
	}

	return 0;
}

int compute(int s, int d)
{
	int S = s;
	int num = 0;

	if (S == 0)
		return 0;

	while (1)
	{
		S = (S * d) % 60;
		num++;
		if (S == s || num > 4000)
			return -1;
		if (S == 0)
			return num;
	}
}