/*
	2012年10月3日11:52:48
	了解快速排序
*/
#include <stdio.h>

void QuickSort(int * a, int low, int high);//快速排序，为a[low]到a[high]排序
int FindPos(int * a, int low, int high);   //找位置，把a[low]排到对应位置，并返回位置标号

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
	快速排序：运用了【递归】，先为数组第一个元素排位置，再在位置两边分别【快速排序】  
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
	找位置：把a[low]排到对应位置，并返回位置标号
	三while循环：	while 1： pos右侧，依次检查a[high]，直到把 <val 的值传给 a[low];
					while 2： pos左侧，依次检查a[low]， 直到把 >val 的值传给 a[high];
					while 3:  使while 1和while 2相互循环，直到找准val位置。
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