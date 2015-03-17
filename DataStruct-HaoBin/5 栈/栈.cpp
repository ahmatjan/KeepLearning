/*
    2012年9月11日11:45:30
	了解栈的构造方法
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

void init(PSTACK);             //初始化栈
void push(PSTACK, int);        //压栈
bool empty(PSTACK);            //判断栈是否为空
void traverse(PSTACK);         //遍历栈
void pop(PSTACK);              //出栈
void clear(PSTACK);            //清空栈

int main()
{
	STACK S;
	int val;
    /*测试初始化栈及压栈函数*/
	init(&S);
	push(&S, 1);
	push(&S, 2);
	push(&S, 3);
	push(&S, 4);
	push(&S, 5);
	traverse(&S);
    /*测试出栈*/
	pop(&S);
	traverse(&S);
	/*测试清空栈*/
	clear(&S);
	traverse(&S);

	return 0;
}

/*初始化栈——使pTop和pBottom指向同一节点*/
void init(PSTACK pS)
{
	pS->pBottom = (PNODE)malloc(sizeof(NODE));
	if (pS->pBottom == NULL)
	{
		printf("动态内存分配失败！\n");
		exit(-1);
	}
	pS->pBottom->pNext = NULL;
	pS->pTop = pS->pBottom;

	return;
}
/*压栈——创建一个新节点，连到定节点上面，把新节点标记为顶节点*/
void push(PSTACK pS, int val)
{
	PNODE pNew;
	pNew = (PNODE)malloc(sizeof(NODE));
	if (NULL == pNew)
	{
		printf("动态内存分配失败！\n");
		exit(-1);
	}
	pNew->data = val;
	pNew->pNext = pS->pTop;
	pS->pTop = pNew;

	return;
}

/*判断栈是否为空*/
bool empty(PSTACK pS)
{
	if (pS->pTop == pS->pBottom)
		return true;
	else
		return false;
}

/*遍历栈——定义临时变量temp，从pTop开始一直往下指*/
void traverse(PSTACK pS)
{
	if (empty(pS))
		printf("栈为空 ！\n");
	else
	{
		PNODE temp;
		temp = pS->pTop;
		printf("遍历栈：");
		while (temp != pS->pBottom)
		{
			printf("%d ", temp->data);
			temp = temp->pNext;
		}
		printf("\n");
	}

	return;
}

/*出栈—— pTop下移，且把原pTop占用的空间释放*/
void pop(PSTACK pS)
{
	if (empty(pS))
		printf("栈为空！\n");
	else
	{
		PNODE temp = pS->pTop;
		pS->pTop = pS->pTop->pNext;
		printf("被删除的栈的数据域为：%d\n", temp->data);
		free(temp);
	}

	return;
}

/*清空栈——类似出栈*/
void clear(PSTACK pS)
{
	if (empty(pS))
		printf("栈为空！\n");
	else
	while (pS->pTop != pS->pBottom)
	{
		PNODE temp = pS->pTop;
		pS->pTop = pS->pTop->pNext;
		free(temp);
	}

	return;
}