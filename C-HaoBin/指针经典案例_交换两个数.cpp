/*
    ʱ�䣺2012��1��24��22:25:00
	���ܣ�����������
	Ŀ�ģ�Ū��ָ��Ĺ���
*/
# include <stdio.h>
/*����һʧ�ܣ��β���swap���������󣬼��ͷţ���û�з��ص�main����*/
void swap_1(int a,int b)
{
	int t;

	t = a;
	a = b;
	b = t;
}
/*������ʧ�ܣ�a��b�ĵ�ַ����p��q�У�swap_2ֻ�ǽ�����p��q�����ݣ���û�иı�a��b�ĵ�ַ*/
/*�ܽ᣺swap_2��Ҫ����a��b�ĵ�ַ�������ǲ����ܵ�*/
void swap_2(int * p,int * q)
{
	int * t;

	t = p;
	p = q;
	q = t;
}
/*�������ɹ�:ͨ��ָ�룬�ı���a��b�����ڴ�Ĵ洢����*/
void swap_3(int * p,int * q)
{
	int t;
	t = *p;
	*p = *q;
	*q = t;
}
void main()
{
	int a = 3;
	int b = 5;

	swap_3(&a,&b);
	printf("a = %d\nb = %d\n",a,b);
	return 0;
}