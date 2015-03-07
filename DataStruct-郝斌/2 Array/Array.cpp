/*
    2012��8��4��17:10:40
	�������飬ʵ�������ϵͳ����һ���Ĺ��ܡ�
	ͨ���������飬�˽⡰���ݽṹ��ͣ���㷨��ͬ���ĺ��塣
*/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

struct Arr
{
	int * pBase;                                        //�����һ��Ԫ�صĵ�ַ
	int len;                                            //�����������ɵ����Ԫ�ظ���
	int cnt;                                            //��ǰ������ЧԪ�ظ���
};

void init_arr(struct Arr * pArr, int length);           //��ʼ������
bool append_arr(struct Arr * pArr, int val);            //׷��Ԫ��
bool insert_arr(struct Arr * pArr, int pos, int val);   //����Ԫ��
bool delete_arr(struct Arr * pArr, int pos, int * val); //ɾ��Ԫ��,ָ��val�����洢��ɾ����Ԫ��
int get();
bool is_empty(struct Arr *);                            //�ж��Ƿ�Ϊ������
bool is_full(struct Arr * pArr);                        //�ж��Ƿ�Ϊ������
void sort_arr(struct Arr * pArr);                       //����������
void show_arr(struct Arr *);                            //�������
void inversion_arr(struct Arr *);                       //��������

int main(void)
{
	int val;
	struct Arr arr;
	init_arr(&arr, 6);
	printf("��ʼ���Ժ������Ϊ��\n");
	show_arr(&arr);
	append_arr(&arr, 1);
	append_arr(&arr, 2);
	append_arr(&arr, 3);
	append_arr(&arr, 4);
	printf("׷��Ԫ���Ժ������Ϊ��\n");
	show_arr(&arr);
	insert_arr(&arr, 3, 99);
	printf("����Ԫ���Ժ������Ϊ��\n");
	show_arr(&arr);
	delete_arr(&arr, 4, &val);
	printf("ɾ��Ԫ�غ������Ϊ��\n");
	show_arr(&arr);
	printf("��ɾ����Ԫ��Ϊ��%d\n", val);
	sort_arr(&arr);
	printf("����������Ϊ��\n");
	show_arr(&arr);
	inversion_arr(&arr);
	printf("�����Ժ������Ϊ��\n");
	show_arr(&arr);

	return 0;
}

void init_arr(struct Arr * pArr, int length)
{
	pArr->pBase = (int *)malloc(sizeof(struct Arr) * length);
	if (NULL == pArr->pBase)  //�����̬�ڴ����ʧ��
	{
		printf("��̬�ڴ����ʧ�ܣ�\n");
		exit(-1);             //��ֹ��������
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
		printf("����Ϊ�գ�\n");
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

void sort_arr(struct Arr * pArr)                   //��С�����ð������
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