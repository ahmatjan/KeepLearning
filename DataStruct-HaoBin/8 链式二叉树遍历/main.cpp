/*
	2012��9��30��22:13:49
	��ʽ���������������Ľṹͼ��ͬһ�ļ����С�
*/
#include <stdio.h>
#include <malloc.h>

typedef struct BTNode
{
	char data;
	struct BTNode * pLchild;
	struct BTNode * pRchild;
}* pBTNode;
	
pBTNode CreateBTree();				//����������
void PreTraverseTree(pBTNode);		//���������������printf�������ݹ��ǰ��
//void InTraverseTree(pBTNode);     //�����������������printf���������ݹ��м�
//void PostTraverseTree(pBTNode);   //�����������������printf���������ݹ����

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