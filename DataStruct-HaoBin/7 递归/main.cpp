/*
    2012��9��22��11:34:33
	ͨ����ŵ������ϰ�ݹ��㷨
*/
#include <stdio.h>

void hannuota(int n, char A, char B, char C)//��n�����Ӵ�Aͨ��B���ƶ���C��
{
	/*
	�����nΪ1��
		�ѱ��Ϊ1�����Ӵ�Aֱ���ƶ���C��
	����
	    ��n-1�����Ӵ�Aͨ��C�ƶ���B��
		�ѱ��Ϊn�����Ӵ�Aֱ���ƶ���C��
		��n-1�����Ӵ�Bͨ��A�ƶ���C��
	*/

	if (1 == n)
		printf("�ѱ��Ϊ%d�����Ӵ�%cֱ���ƶ���%c��\n", n, A, C);
	else
	{
		hannuota(n-1, A, C, B);
		printf("�ѱ��Ϊ%d�����Ӵ�%cֱ���ƶ���%c��\n", n, A, C);
		hannuota(n-1, B, A, C);
	}
}


int main()
{
	int n;
	char ch1 = 'A';
	char ch2 = 'B';
	char ch3 = 'C';

	printf("������n��ֵ��\n");
	scanf("%d", &n);
	hannuota(n, ch1, ch2, ch3);

	return 0;
}