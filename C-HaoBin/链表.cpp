/*
    2012年2月20日15:41:38(到学校外洗了个澡，拔了个罐，O(∩_∩)O哈哈~)
	学习链表相关知识
*/
# include <stdio.h>
# include <malloc.h>
# include <stdlib.h>

struct Node
{
	int data;//数据域
	struct Node * pNext;//指针域
};

//函数声明
struct Node * create_list(void);
void traverse_list(struct Node * pHead);

int main (void)
{
	struct Node * pHead = NULL;

    pHead = create_list();//creat_list()函数的返回值是头结点的指针;pHead是头指针。
	traverse_list(pHead);//遍历链表函数。

	return 0;
}

struct Node * create_list(void)
{
	int len;    //用来存储链表的元素数。
	int i;      //用来控制for循环。
	int val;    //用来临时存储链表结点的数据域。
	
	//定义一个头结点和一个尾结点，并指向同一块动态分配内存。
	struct Node * pHead;
	struct Node * pTail;
	pHead = (struct Node *)malloc(sizeof(struct Node));
	if(NULL == pHead)
	{
		printf("分配动态空间失败，程序将退出！\n");
		exit(-1);
	}
    pTail = pHead;
	pTail->pNext = NULL;

	//定义len个新结点，并接到到pTail之后。
	printf("请输入链表结点数：");
	scanf("%d",&len);
	for(i=0;i<len;++i)
	{
		printf("请输入第%d个元素的值：",i+1);
		scanf("%d",&val);
		struct Node * pNew = (struct Node *)malloc(sizeof(struct Node));
		if(NULL == pNew)
		{
			printf("内存分配失败，程序退出！");
			exit(-1);
		}

		//对pTail和pNew指向内存的数据域和指针域进行修改；然后把pTail指向新建立的结点。
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
		printf("链表为空\n");
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
    修改失败心得：
	1.指针型变量不能连续定义；
	2.在pTail = pHead时，如果pHead不指向一块内存，则赋值是行不通的。
*/