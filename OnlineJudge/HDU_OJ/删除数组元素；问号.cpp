/*
    2012��4��14��15:02:35
    ɾ������Ԫ�أ�qsort��ʹ�ã����ʺŵ�ʹ�ã�
	���ں���2034�⣬��ַ��http://acm.hdu.edu.cn/showproblem.php?pid=2034
*/
# include <stdio.h>
# include <stdlib.h>

int comp(const int *a, const int *b)
{
    return *a - *b;
}

int main()
{
	int n, m, i, j, temp, st[200];
	
	while (scanf("%d%d", &n, &m), m * n)
	{
		for (i = 0; i < n; i++)
		{
			scanf("%d", st + i);
		}
		for (i = 0; i < m; i++)
		{
			scanf("%d", &temp);
			for (j = 0; j < n; j++)
			{
				if (st[j] == temp)
					st[j] = st[--n];//ɾ������Ԫ�أ���Ư����һ��
			}
		}
        for (i = 0; i < n - 1; i++)
		{
			for (j = 0; j < n - 1 - i; j++)
			{
				if (st[j] > st[j + 1])
				{
					temp = st[j];
					st[j] = st[j + 1];
					st[j + 1] = temp;
				}
			}
		}
        for (i = 0; i < n; i++)
            printf("%d ", st[i]);
        printf(n ? "\n" : "NULL\n");//�����������?
    }
	
	return 0;
}
/*
     1.ɾ������Ԫ�أ�
			for (j = 0; j < n; j++)
			{
				if (st[j] == temp)
					st[j] == st[--n];
			}

	 2.��������� ? :
����       ���ʽΪ�����ʽ1�����ʽ2�����ʽ3 
   ����    �������ʽ1�� ����
           ����ֵΪ�棨��0���򽫱��ʽ2��ֵ��Ϊ�������ʽ��ȡֵ�� ����
	       ���򣨱��ʽ1��ֵΪ0�������ʽ3��ֵ��Ϊ�������ʽ��ȡֵ�� ����
	       ����: ����max=(a>b)?a:b �������ǽ�a��b�����нϴ��һ������max��
*/