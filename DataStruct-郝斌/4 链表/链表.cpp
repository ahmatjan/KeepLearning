/*
    2012��9��5��10:36:48
	�˽���ϵ�������ݽṹ
*/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

typedef struct Node
{
	int data;                //������
	struct Node * pNext;     //ָ����
}NODE, * PNODE;

PNODE create_list(void);   //��������
void traverse_list(PNODE); //��������
bool is_empty(PNODE);      //�ж������Ƿ�Ϊ��
int length_list(PNODE);    //��������
void sort_list(PNODE);     //��������
bool insert_list(PNODE pHead, int pos, int val);     //����ڵ�
bool delete_list(PNODE pHead, int pos, int * val);   //ɾ���ڵ�

int main()
{
	PNODE pHead = NULL;
	int val;
	
	pHead = create_list();
	traverse_list(pHead);
	insert_list(pHead, 3, 89);
	traverse_list(pHead);
	delete_list(pHead, 4, &val);
	traverse_list(pHead);






	//if (is_empty(pHead))
	//	printf("����Ϊ��\n");
	//else
	//	printf("����Ϊ��\n");
	//printf("����ĳ���Ϊ:%d\n", length_list(pHead));

	//sort_list(pHead);
	//traverse_list(pHead);
	
	return 0;
}

/*��������*/
PNODE create_list(void)
{
	int len;         //������
	int val;         //��ʱ���������
	int i;
	
	/*����ͷ���*/
	PNODE pHead;
	pHead = (PNODE)malloc(sizeof(NODE));
	if (NULL == pHead)
	{
		printf("��̬�����ڴ�ʧ��\n");
		exit(-1);
	}
	
    /*����β�ڵ�*/
	PNODE pTail = pHead;
	
	/*׷�ӽڵ�*/
	printf("��������Ҫ�����ڵ�ĸ����� len = ");
	scanf("%d", &len);
	for (i = 0; i < len; ++i)
	{
		printf("�������%d��������ֵ��", i + 1);
		scanf("%d", &val);
		PNODE pNew = (PNODE)malloc(sizeof(NODE));
		if(NULL == pNew)
		{
			printf("��̬�����ڴ�ʧ��\n");
			exit(-1);
		}
		pNew->data = val;
		pNew->pNext = NULL;
		pTail->pNext = pNew;
		pTail = pNew;
	}
	
	return pHead;
}

/*��������*/
void traverse_list(PNODE pHead)
{
	
	PNODE p = pHead->pNext;
	
	printf("����������Ϊ��\n");
	while(NULL != p)
	{
		printf("%d ", p->data);
		p = p->pNext;
	}
	
	printf("\n\n");
	return;
}

/*�ж������Ƿ�Ϊ��*/
bool is_empty(PNODE pHead)
{
	if (NULL == pHead->pNext)
		return true;
	else
		return false;
}

/*��������*/
int length_list(PNODE pHead)
{
	PNODE p = pHead;
	int cnt = 0;
	
	while (NULL != p->pNext)
	{
		cnt++;
		p = p->pNext;
	}
	
	return cnt;
}


/*�����С����*/
void sort_list(PNODE pHead)
{
	int i, j, t;
	int len = length_list(pHead);
	PNODE p, q;
/*��ⷺ�͵ĸ����p=p->pNext������p++*/
	for (i = 0, p = pHead->pNext; i < len-1; i++, p = p->pNext)   
	{
		for (j = i+1,  q = p->pNext; j < len; j++, q = q->pNext)
		{
			if (p->data > q->data)
			{
				t = p->data;
				p->data = q->data;
				q->data = t;
			}
		}
	}
}


/*����ڵ�*/
bool insert_list(PNODE pHead, int pos, int val)
{
	PNODE p = pHead;
	int i = 0;

	/*��p��ָ���Ƶ�pos��ǰһ���ڵ�*/
	while (i<pos-1 && NULL!=p)
	{
		p = p->pNext;
		i++;
	}

	/*��ǿ����׳�ԣ����⡾posΪ-1�� ���� ��pos����length����������������*/
	if (i>pos-1 || NULL==p)
		return false;

	PNODE pNew = (PNODE)malloc(sizeof(NODE));
	if (NULL == pNew)
	{
		printf("��̬�ڴ����ʧ��\n");
		exit(-1);
	}

	pNew->data = val;
    pNew->pNext = p->pNext;
	p->pNext = pNew;

	return true;
}

/*ɾ���ڵ�*/
bool delete_list(PNODE pHead, int pos, int * val)
{
	int i = 0;
	PNODE p = pHead;

	while (NULL!=p->pNext && i<pos-1)
	{
		p = p->pNext;
		i++;
	}

	if (NULL==p->pNext || i>pos-1)
		return false;

	PNODE q = p->pNext;
	p->pNext = p->pNext->pNext;
	free(q);
	q = NULL;

	return true;
}