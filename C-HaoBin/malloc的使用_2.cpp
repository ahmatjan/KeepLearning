# include <stdio.h>
# include <malloc.h>

void f(int * q)
{
	*q = 200;
}

int main(void)
{
	int * p = (int *)malloc(sizeof(int));//sizeof(int)��ʾ����int��ռ�ֽ�����
	*p = 10;
	printf("%d\n",*p);//10
	f(p);
	printf("%d\n",*p);//200

	return 0;
}