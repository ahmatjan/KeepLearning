/*
2013��3��23��16:54:09
HDU OJ 4509
Ҳ�� ��Ѷ������ 2��21�� ��5��
*/
#include <stdio.h>

bool is_later(int h1, int m1, int h, int m)	//�ж�ĳʱ����Ƿ��ڿ�ʼʱ����
{
	if ((h>h1) || ((h==h1)&&(m>=m1)))
		return true;
	else
		return false;
}

bool is_former(int h2, int m2, int h, int m)	//�ж�ĳʱ����Ƿ��ڽ���ʱ���ǰ
{
	if ((h<h2) || ((h==h2)&&(m<m2)))
		return true;
	else 
		return false;
}

bool is_invade(int h1, int m1, int h2, int m2, int h, int m) //�жϸ�ʱ����Ƿ������ռ��
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
		for (i = 0; i < 24; i++)	//��־����ʼ������ʾÿ��ʱ���δ��ռ��
		{
			for (j = 0; j < 60; j++)
			{
				time[i][j] = 0;
			}
		}

		for (i = 0; i < n; i++)		//��ÿ���½��з���������ռ������Щʱ���
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
		for (h = 0; h < 24; h++)	//ͳ�ƿ���ʱ��
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
˼·��
	��������� ����� �ķ�ʽ���������Щʱ�䱻ռ�ã���Щδ��ռ�á�

�ܽ᣺
	1. ȷ���� �������� ȷʵ���ã����Ƿ��� �Ƿ����������� ����ʱ��һ����!
	2. ȷ���� bool���� ȷʵ���á�
	3. ����û����������ԭ��
		�� ������󣬵��µ�һ��˼·����
		�� ����ø����㷨������ �߼����ڸ��ӣ���������˴���
	4. ��� ����һ��Сʱ ���������� ԭ��
		������˴��󣬵����˰��졣
	����ԭ��
		�� �� == д���� =
		�� bool ���� Ĭ�Ϸ��� true�������Ҫ���Ƿ��� false�����
*/