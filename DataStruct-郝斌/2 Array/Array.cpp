/*
    2012年8月4日17:10:40
	构造数组，实现与操作系统数组一样的功能。
	通过构造数组，了解“数据结构不停，算法不同”的含义。
*/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

struct Arr
{
	int * pBase;                                        //数组第一个元素的地址
	int len;                                            //数组所能容纳的最大元素个数
	int cnt;                                            //当前数组有效元素个数
};

void init_arr(struct Arr * pArr, int length);           //初始化数组
bool append_arr(struct Arr * pArr, int val);            //追加元素
bool insert_arr(struct Arr * pArr, int pos, int val);   //插入元素
bool delete_arr(struct Arr * pArr, int pos, int * val); //删除元素,指针val用来存储被删除的元素
int get();
bool is_empty(struct Arr *);                            //判断是否为空数组
bool is_full(struct Arr * pArr);                        //判断是否为满数组
void sort_arr(struct Arr * pArr);                       //将数组排序
void show_arr(struct Arr *);                            //输出数组
void inversion_arr(struct Arr *);                       //倒置数组

int main(void)
{
	int val;
	struct Arr arr;
	init_arr(&arr, 6);
	printf("初始化以后的数组为：\n");
	show_arr(&arr);
	append_arr(&arr, 1);
	append_arr(&arr, 2);
	append_arr(&arr, 3);
	append_arr(&arr, 4);
	printf("追加元素以后的数组为：\n");
	show_arr(&arr);
	insert_arr(&arr, 3, 99);
	printf("插入元素以后的数组为：\n");
	show_arr(&arr);
	delete_arr(&arr, 4, &val);
	printf("删除元素后的数组为：\n");
	show_arr(&arr);
	printf("被删除的元素为：%d\n", val);
	sort_arr(&arr);
	printf("排序后的数组为：\n");
	show_arr(&arr);
	inversion_arr(&arr);
	printf("倒置以后的数组为：\n");
	show_arr(&arr);

	return 0;
}

void init_arr(struct Arr * pArr, int length)
{
	pArr->pBase = (int *)malloc(sizeof(struct Arr) * length);
	if (NULL == pArr->pBase)  //如果动态内存分配失败
	{
		printf("动态内存分配失败！\n");
		exit(-1);             //终止整个程序
	}
	else
	{
		pArr->len = length;
		pArr->cnt = 0;
	}

	return;
}

bool is_empty(struct Arr * pArr)
{
	if (0 == pArr->cnt)
		return true;
	else 
		return false;
}


void show_arr(struct Arr * pArr)
{
	if (is_empty(pArr))
		printf("数组为空！\n");
	else
	{
		for (int i = 0; i < pArr->cnt; i++)
			printf("%d  ", pArr->pBase[i]);
		printf("\n");
	}	
}


bool is_full(struct Arr * pArr)
{
	if (pArr->cnt == pArr->len)
		return true;
	else
		return  false;
}

bool append_arr(struct Arr * pArr, int val)
{
	if (is_full(pArr))
		return false;
	else
	{
		pArr->pBase[pArr->cnt] = val;
		pArr->cnt++;
	}
}

bool insert_arr(struct Arr * pArr, int pos, int val)
{
	if (is_full(pArr))
		return false;
	if (pos < 1 || pos > pArr->cnt + 1)
		return false;
	for (int i = pArr->cnt-1; i >= pos - 1; --i)
		pArr->pBase[i + 1] = pArr->pBase[i];
	pArr->pBase[pos - 1] = val;
	pArr->cnt++;
	return true;
}

bool delete_arr(struct Arr * pArr, int pos, int * val)
{
	if (is_empty(pArr))
		return false;
	if (pos < 1 || pos > pArr->cnt)
		return false;
	*val = pArr->pBase[pos-1];
	for (int i = pos - 1; i <= pArr->cnt; i++)
		pArr->pBase[i] = pArr->pBase[i + 1];
	pArr->cnt--;
	return true;
}

void sort_arr(struct Arr * pArr)                   //从小到大的冒泡排序
{
	int t;
	for (int i = 0; i < pArr->cnt; i++)
	{
		for (int j = i + 1; j < pArr->cnt; j++)
		{
			if (pArr->pBase[i] > pArr->pBase[j])
			{
				t = pArr->pBase[i];
				pArr->pBase[i] = pArr->pBase[j];
				pArr->pBase[j] = t;
			}
		}
	}
}

void inversion_arr(struct Arr * pArr)
{
	int temp;
	for (int i = 0, int j = pArr->cnt-1; i < j; i++, j--)
	{
		temp = pArr->pBase[i];
		pArr->pBase[i] = pArr->pBase[j];
		pArr->pBase[j] = temp;
	}
}