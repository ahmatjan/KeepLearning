/*
	2012��10��3��11:52:48
	�˽��������
*/
#include <stdio.h>

void QuickSort(int * a, int low, int high);//��������Ϊa[low]��a[high]����
int FindPos(int * a, int low, int high);   //��λ�ã���a[low]�ŵ���Ӧλ�ã�������λ�ñ��

int main()
{
	int a[6] = {-3, 20, 58, 488, 11, -6};

	QuickSort(a, 0, 5);

	for (int i = 0; i < 6; i++)
		printf("%d ", a[i]);
	printf("\n");


	return 0;
}

/*	
	�������������ˡ��ݹ顿����Ϊ�����һ��Ԫ����λ�ã�����λ�����߷ֱ𡾿�������  
*/
void QuickSort(int * a, int low, int high)
{
	int pos;

	if (low < high)
	{
		pos = FindPos(a, low, high);
		QuickSort(a, low, pos-1);
		QuickSort(a, pos+1, high);
	}
}

/*
	��λ�ã���a[low]�ŵ���Ӧλ�ã�������λ�ñ��
	��whileѭ����	while 1�� pos�Ҳ࣬���μ��a[high]��ֱ���� <val ��ֵ���� a[low];
					while 2�� pos��࣬���μ��a[low]�� ֱ���� >val ��ֵ���� a[high];
					while 3:  ʹwhile 1��while 2�໥ѭ����ֱ����׼valλ�á�
*/
int FindPos(int * a, int low, int high)
{
	int val = a[low];

	while (low < high)                       //3
	{
		while (low < high && a[high] > val)  //1
			--high;
		a[low] = a[high];

		while (low < high && a[low] < val)   //2
			++low;
		a[high] = a[low];
	}

	a[low] = val;

	return low;
}