#include <stdio.h>
#include <malloc.h>

int main()
{
	/*��̬�����ڴ�*/
	int a[5] = {5, 34, 2, 5, 8};

	/*��̬�����ڴ�*/
	printf("�����������Ԫ������len = ");
	int len;
	scanf("%d", &len);
	int * pArr = (int *)malloc(sizeof(int) * len);
	    /*malloc������һ���ֵ��ڴ棬��Ҫ��(int *)ǿ������ת������Ϊmalloc���ص���һ���ֽ��׵�ַ��������ȷ��һ��
	     һ������ռ�����ֽڡ�*/
	printf("������%d��Ԫ�أ�", len);
	for(int i = 0; i < len; i++)
		scanf("%d", pArr + i);
	for(i = 0; i < len; i++)
		printf("%d ",*(pArr + i));
	free(pArr);
	printf("\n");

	return 0;
}