/*
	2012年9月30日22:13:49
	链式二叉树遍历，树的结构图在同一文件夹中。
*/
#include <stdio.h>
#include <malloc.h>

typedef struct BTNode
{
	char data;
	struct BTNode * pLchild;
	struct BTNode * pRchild;
}* pBTNode;
	
pBTNode CreateBTree();				//创建二叉树
void PreTraverseTree(pBTNode);		//先序遍历二叉树，printf在两个递归的前面
//void InTraverseTree(pBTNode);     //中序遍历二叉树，把printf换到两个递归中间
//void PostTraverseTree(pBTNode);   //后序遍历二叉树，把printf换到两个递归后面

int main()
{
	pBTNode pT = CreateBTree();
	
	PreTraverseTree(pT);
	
	return 0;
}

pBTNode CreateBTree()
{
	pBTNode pA = (pBTNode)malloc(sizeof(BTNode));
	pBTNode pB = (pBTNode)malloc(sizeof(BTNode));
	pBTNode pC = (pBTNode)malloc(sizeof(BTNode));
	pBTNode pD = (pBTNode)malloc(sizeof(BTNode));
	pBTNode pE = (pBTNode)malloc(sizeof(BTNode));
	
	pA->pLchild = pB;
	pA->pRchild = pC;
	pA->data = 'A';
	pB->pLchild = pB->pRchild = NULL;
	pB->data = 'B';
	pC->pLchild = pD;
	pC->pRchild = NULL;
	pC->data = 'C';
	pD->pLchild = NULL;
	pD->pRchild = pE;
	pD->data = 'D';
	pE->pLchild = pE->pRchild = NULL;
	pE->data = 'E';
	
	return pA;
}

void PreTraverseTree(pBTNode pT)
{
	if (NULL != pT)
	{
		printf("%c\n", pT->data);
		PreTraverseTree(pT->pLchild);
		PreTraverseTree(pT->pRchild);
	}
}