/*
    2012��2��20��15:41:38(��ѧУ��ϴ�˸��裬���˸��ޣ�O(��_��)O����~)
	ѧϰ�������֪ʶ
*/
# include <stdio.h>
# include <malloc.h>
# include <stdlib.h>

struct Node
{
	int data;//������
	struct Node * pNext;//ָ����
};

//��������
struct Node * create_list(void);
void traverse_list(struct Node * pHead);

int main (void)
{
	struct Node * pHead = NULL;

    pHead = create_list();//creat_list()�����ķ���ֵ��ͷ����ָ��;pHead��ͷָ�롣
	traverse_list(pHead);//������������

	return 0;
}

struct Node * create_list(void)
{
	int len;    //�����洢�����Ԫ������
	int i;      //��������forѭ����
	int val;    //������ʱ�洢�������������
	
	//����һ��ͷ����һ��β��㣬��ָ��ͬһ�鶯̬�����ڴ档
	struct Node * pHead;
	struct Node * pTail;
	pHead = (struct Node *)malloc(sizeof(struct Node));
	if(NULL == pHead)
	{
		printf("���䶯̬�ռ�ʧ�ܣ������˳���\n");
		exit(-1);
	}
    pTail = pHead;
	pTail->pNext = NULL;

	//����len���½�㣬���ӵ���pTail֮��
	printf("����������������");
	scanf("%d",&len);
	for(i=0;i<len;++i)
	{
		printf("�������%d��Ԫ�ص�ֵ��",i+1);
		scanf("%d",&val);
		struct Node * pNew = (struct Node *)malloc(sizeof(struct Node));
		if(NULL == pNew)
		{
			printf("�ڴ����ʧ�ܣ������˳���");
			exit(-1);
		}

		//��pTail��pNewָ���ڴ���������ָ��������޸ģ�Ȼ���pTailָ���½����Ľ�㡣
		pNew->data = val;
		pTail->pNext = pNew;
		pNew->pNext = NULL;
		pTail = pNew;
	}

    return pHead;
}

void traverse_list(struct Node * pHead)
{
    if (pHead->pNext == NULL)
	{
		printf("����Ϊ��\n");
	}
	pHead = pHead->pNext;
	while(pHead != NULL)
	{
		printf("%d ",pHead->data);
		pHead = pHead->pNext;
	}

	return;
}

/*
    �޸�ʧ���ĵã�
	1.ָ���ͱ��������������壻
	2.��pTail = pHeadʱ�����pHead��ָ��һ���ڴ棬��ֵ���в�ͨ�ġ�
*/