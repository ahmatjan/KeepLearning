/*
    2012��9��15��21:32:32
	�˽����
*/
#include <stdio.h>
#include <malloc.h>

typedef struct Queue
{
	int * pBase;
	int front;
	int rear;
}QUEUE;

void init(QUEUE *);               //��ʼ������
bool full_queue(QUEUE *);         //�ж��Ƿ���
bool en_queue(QUEUE *, int);      //���
bool empty_queue(QUEUE *);        //�ж��Ƿ�Ϊ��
bool out_queue(QUEUE *, int *);   //����
void traverse(QUEUE *);           //��������

int main()
{
	QUEUE Q;
	int val;

	init(&Q);
	en_queue(&Q, 1);
	en_queue(&Q, 2);
	en_queue(&Q, 3);
	en_queue(&Q, 4);
	en_queue(&Q, 5);
	en_queue(&Q, 6);
	en_queue(&Q, 7);
	en_queue(&Q, 8);
	traverse(&Q);
	if (out_queue(&Q, &val))
		printf("���ӳɹ���ɾ����Ԫ����:%d\n", val);
	traverse(&Q);

	return 0;
}

void init(QUEUE * pQ)
{
	pQ->pBase = (int *)malloc(sizeof(int) * 6);
	pQ->front = pQ->rear = 0;
}

bool full_queue(QUEUE * pQ)
{
	if (((pQ->rear+1) % 6) == pQ->front)
		return true;
	else
		return false;
}

bool en_queue(QUEUE * pQ, int val)
{
	if (full_queue(pQ))
		return false;
	else
	{
		pQ->pBase[pQ->rear] = val;
		pQ->rear = (pQ->rear+1) % 6;

		return true;
	}
}

bool empty_queue(QUEUE * pQ)
{
	if (pQ->front == pQ->rear)
		return true;
	else
		return false;
}

bool out_queue(QUEUE * pQ, int * val)
{
	if (empty_queue(pQ))
		return false;
	else
	{
		*val = pQ->pBase[pQ->front];
		pQ->front = (pQ->front+1) % 6;
		return true;
	}
}

void traverse(QUEUE * pQ)
{
	if (empty_queue(pQ))
		printf("����Ϊ�գ�\n");
	else
	{
		int i;

		for (i = pQ->front; i != pQ->rear; i = (i+1) % 6)
			printf("%d ", pQ->pBase[i]);
		printf("\n");
	}
}