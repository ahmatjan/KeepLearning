/*
	2012��11��26��20:42:45
	�ڶ��п��� 5*5 ��ά����
*/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

int main()
{

	int ** p;
	int i, j;
	/*��̬�����ά����ռ�*/
	p = (int **)malloc(5 * sizeof(int *));
	if (NULL == p)
	{
		printf("��̬�ڴ����ʧ�ܣ�\n");
		exit(-1);
	}
	for (i = 0; i < 5; i++)
	{
		p[i] = (int *)malloc(5 * sizeof(int));
		if (NULL == p[i])
		{
			printf("��̬�ڴ����ʧ�ܣ�\n");
			exit(-1);
		}
	}

	/*��ά���鸳ֵ�����*/
	for (i = 0; i < 5; i++)
	{
		for (j = 0; j < 5; j++)
		{
			p[i][j] = 5 * i + j;
			printf(" %2d", p[i][j]);
		}
		printf("\n");
	}
	printf("\n");

	/*�ͷŶ�ά������ռ�ռ�*/
	for (i = 0; i < 5; i ++)
		free(p[i]);
	free (p);

	return 0;
}