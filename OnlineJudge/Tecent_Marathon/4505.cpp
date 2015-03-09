#include <stdio.h>

int max(int a[100], int n)	//����߲���
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

int count_time(int n, int a[100], int highest)//����ÿ�������Ҫ����ʱ��
{
	int i, j;
	int flag;		//���ÿ���Ƿ�������
	int time;

	time = 0;
	for (i = 0; i <= highest; i++)	//����ÿ�㻨��ʱ��
	{
		time += 6;
		flag = 0;
		for (j = 0; j < n; j++)		//����ÿ��ÿ���˻��ѵ�ʱ��
		{
			if (a[j] == i)
			{
				time += 1;
				flag = 1;
			}
		}
		if (flag)					//ÿ��Ŀ���ʱ��
			time += 5;		
	}

	time += highest * 4;			//������¥����ʱ��

	return time;
}

int main()
{
	int c, n, a[100], time;
	int i;
	int highest;	//Ҫ������߲�

	scanf("%d", &c);

	while (c != 0)
	{
		time = 0;

		scanf("%d", &n);
		for (i = 0; i < n; i++)		//��¼ÿ����Ҫ���Ĳ�����a[i]
		{
			scanf("%d", &a[i]);
		}

		highest = max(a, n);

		time = count_time(n, a, highest);	//����ÿ�������Ҫ����ʱ��
		
		printf("%d\n", time-6);

		c--;
	}

	return 0;
}