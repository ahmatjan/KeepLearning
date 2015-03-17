/*
    2012年9月5日10:36:48
	了解联系链表数据结构
*/
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

typedef struct Node
{
	int data;                //数据域
	struct Node * pNext;     //指针域
}NODE, * PNODE;

PNODE create_list(void);   //创建链表
void traverse_list(PNODE); //遍历链表
bool is_empty(PNODE);      //判断链表是否为空
int length_list(PNODE);    //求链表长度
void sort_list(PNODE);     //链表排序
bool insert_list(PNODE pHead, int pos, int val);     //插入节点
bool delete_list(PNODE pHead, int pos, int * val);   //删除节点

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
	//	printf("链表为空\n");
	//else
	//	printf("链表不为空\n");
	//printf("链表的长度为:%d\n", length_list(pHead));

	//sort_list(pHead);
	//traverse_list(pHead);
	
	return 0;
}

/*创建链表*/
PNODE create_list(void)
{
	int len;         //链表长度
	int val;         //临时存放数据域
	int i;
	
	/*创建头结点*/
	PNODE pHead;
	pHead = (PNODE)malloc(sizeof(NODE));
	if (NULL == pHead)
	{
		printf("动态分配内存失败\n");
		exit(-1);
	}
	
    /*创建尾节点*/
	PNODE pTail = pHead;
	
	/*追加节点*/
	printf("请输入您要创建节点的个数： len = ");
	scanf("%d", &len);
	for (i = 0; i < len; ++i)
	{
		printf("请输入第%d个数的数值：", i + 1);
		scanf("%d", &val);
		PNODE pNew = (PNODE)malloc(sizeof(NODE));
		if(NULL == pNew)
		{
			printf("动态分配内存失败\n");
			exit(-1);
		}
		pNew->data = val;
		pNew->pNext = NULL;
		pTail->pNext = pNew;
		pTail = pNew;
	}
	
	return pHead;
}

/*遍历链表*/
void traverse_list(PNODE pHead)
{
	
	PNODE p = pHead->pNext;
	
	printf("遍历链表结果为：\n");
	while(NULL != p)
	{
		printf("%d ", p->data);
		p = p->pNext;
	}
	
	printf("\n\n");
	return;
}

/*判断链表是否为空*/
bool is_empty(PNODE pHead)
{
	if (NULL == pHead->pNext)
		return true;
	else
		return false;
}

/*求链表长度*/
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


/*链表大小排序*/
void sort_list(PNODE pHead)
{
	int i, j, t;
	int len = length_list(pHead);
	PNODE p, q;
/*理解泛型的概念，用p=p->pNext代替了p++*/
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


/*插入节点*/
bool insert_list(PNODE pHead, int pos, int val)
{
	PNODE p = pHead;
	int i = 0;

	/*把p的指针移到pos的前一个节点*/
	while (i<pos-1 && NULL!=p)
	{
		p = p->pNext;
		i++;
	}

	/*增强程序健壮性，避免【pos为-1】 或者 【pos大于length】的情况，程序崩溃*/
	if (i>pos-1 || NULL==p)
		return false;

	PNODE pNew = (PNODE)malloc(sizeof(NODE));
	if (NULL == pNew)
	{
		printf("动态内存分配失败\n");
		exit(-1);
	}

	pNew->data = val;
    pNew->pNext = p->pNext;
	p->pNext = pNew;

	return true;
}

/*删除节点*/
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