/*
    2012��9��11��11:45:30
	�˽�ջ�Ĺ��췽��
*/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

typedef struct Node
{
	int data;
	struct Node * pNext;
}NODE, * PNODE;

typedef struct Stack
{
	PNODE pTop;
	PNODE pBottom;
}STACK, * PSTACK;

void init(PSTACK);             //��ʼ��ջ
void push(PSTACK, int);        //ѹջ
bool empty(PSTACK);            //�ж�ջ�Ƿ�Ϊ��
void traverse(PSTACK);         //����ջ
void pop(PSTACK);              //��ջ
void clear(PSTACK);            //���ջ

int main()
{
	STACK S;
	int val;
    /*���Գ�ʼ��ջ��ѹջ����*/
	init(&S);
	push(&S, 1);
	push(&S, 2);
	push(&S, 3);
	push(&S, 4);
	push(&S, 5);
	traverse(&S);
    /*���Գ�ջ*/
	pop(&S);
	traverse(&S);
	/*�������ջ*/
	clear(&S);
	traverse(&S);

	return 0;
}

/*��ʼ��ջ����ʹpTop��pBottomָ��ͬһ�ڵ�*/
void init(PSTACK pS)
{
	pS->pBottom = (PNODE)malloc(sizeof(NODE));
	if (pS->pBottom == NULL)
	{
		printf("��̬�ڴ����ʧ�ܣ�\n");
		exit(-1);
	}
	pS->pBottom->pNext = NULL;
	pS->pTop = pS->pBottom;

	return;
}
/*ѹջ��������һ���½ڵ㣬�������ڵ����棬���½ڵ���Ϊ���ڵ�*/
void push(PSTACK pS, int val)
{
	PNODE pNew;
	pNew = (PNODE)malloc(sizeof(NODE));
	if (NULL == pNew)
	{
		printf("��̬�ڴ����ʧ�ܣ�\n");
		exit(-1);
	}
	pNew->data = val;
	pNew->pNext = pS->pTop;
	pS->pTop = pNew;

	return;
}

/*�ж�ջ�Ƿ�Ϊ��*/
bool empty(PSTACK pS)
{
	if (pS->pTop == pS->pBottom)
		return true;
	else
		return false;
}

/*����ջ����������ʱ����temp����pTop��ʼһֱ����ָ*/
void traverse(PSTACK pS)
{
	if (empty(pS))
		printf("ջΪ�� ��\n");
	else
	{
		PNODE temp;
		temp = pS->pTop;
		printf("����ջ��");
		while (temp != pS->pBottom)
		{
			printf("%d ", temp->data);
			temp = temp->pNext;
		}
		printf("\n");
	}

	return;
}

/*��ջ���� pTop���ƣ��Ұ�ԭpTopռ�õĿռ��ͷ�*/
void pop(PSTACK pS)
{
	if (empty(pS))
		printf("ջΪ�գ�\n");
	else
	{
		PNODE temp = pS->pTop;
		pS->pTop = pS->pTop->pNext;
		printf("��ɾ����ջ��������Ϊ��%d\n", temp->data);
		free(temp);
	}

	return;
}

/*���ջ�������Ƴ�ջ*/
void clear(PSTACK pS)
{
	if (empty(pS))
		printf("ջΪ�գ�\n");
	else
	while (pS->pTop != pS->pBottom)
	{
		PNODE temp = pS->pTop;
		pS->pTop = pS->pTop->pNext;
		free(temp);
	}

	return;
}