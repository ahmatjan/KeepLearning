/*
    2012��3��4��13:46:18(acm��1091��)
	while������ʹ��
    while��ʱ���������������жϣ�ֻ��������ѭ������while (1)
*/
# include <stdio.h>

int main(void)
{
    int a, b;

    while(scanf( "%d %d" , &a , &b ))
    {
        if(a == 0 && b == 0)
			break;
        else 
			printf("%d\n", a+b);
    }

	return 0;
}
