/*
1.ɨ��n��ֵ������һ��n���ڵ�ѭ����������������д��1 - n����š�
2.����һ�������ſ����õ������������3600��������
3.����ѭ������ʼ��̭������executed��¼����̭����Ŀ��ֱ��executed==n-1,�˳�ѭ��
4.�˳�ѭ��
*/

#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <math.h>
#define NULL 0

typedef struct Node
{
	int data;
	struct Node * pPrevious;
	struct Node * pNext;
}NODE, *PNODE;

PNODE create_list(int n);				//����һ������
PNODE delete_list(PNODE p);				//ɾ���ڵ�
void traverse_list(PNODE p, int n);		//��������
int * test_prime();						//����������

int main()
{
	int n, i;
	int * prime;
	int executed = 0;
	PNODE p;
	
	prime = test_prime();			//�������������		


	while (1)
	{
		scanf("%d", &n);
		if (n == 0)
			return 0;
		p = create_list(n);
		while (1)
		{
			for (i = 0; i < prime[executed] - 1; i++, p = p->pNext);
			p = delete_list(p);
			executed++;
			if (executed == n - 1)
				break;
		}
		printf("%d\n", p->data);
	}

	return 0;
}

PNODE create_list(int n)
{
	PNODE pHead = (PNODE)malloc(sizeof(NODE));
	PNODE pTail = pHead;
	pHead->data = 1;
	pTail->pNext = NULL;
	pTail->pPrevious = NULL;
	
	for (int i = 2; i <= n; i++)
	{
		PNODE p = (PNODE)malloc(sizeof(NODE));
		p->data = i;
		p->pNext = NULL;
		p->pPrevious = pTail;
		pTail->pNext = p;
		pTail = p;
	}
	
	pTail->pNext = pHead;
	pHead->pPrevious = pTail;
	
	return pHead;
}

PNODE delete_list(PNODE p)
{
	PNODE temp = p->pNext;
	p->pPrevious->pNext = p->pNext;
	
	return temp;
}

void traverse_list(PNODE p, int n)
{
	for (int i = 0; i < n; i++, p = p->pNext)
	{
		printf("%d ", p->data);
	}
	printf("\n");
}

int* test_prime(void)
{
	int num = 0;
	int * prime = (int *)malloc(sizeof(int) * 40000);
	prime[num++] = 2;
	
	for (int i = 3; i < 400000; i += 2)
	{
		int is_prime = 1;
		for (int j = 2; j <= sqrt(i); j++)
		{
			if (i%j == 0)
			{
				is_prime = 0;
				break;
			}
		}
		if (is_prime)
			prime[num++] = i;
	}
	
	return prime;
}