/*
ʱ�䣺2012��1��29��21:39:22
���ܣ��ں�����һ�θ�д�����أ�����Ԫ��ֵ��
Ŀ�ģ�����ָ���������е�Ӧ�á�
*/
# include<stdio.h>

void f(int * pArr,int len)
{
	pArr[3] = 88;
}

int main(void)
{
	int a[5] = {1,2,3,4,5};

	printf("%d\n",a[3]);
	f(a,5);
	printf("%d\n",a[3]);

	return 0;
}