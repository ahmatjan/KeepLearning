/*
    2012��2��15��16:29:45
	���졢ʹ�á��ͷŶ�̬һά����
*/
# include <stdio.h>
# include <malloc.h>

int main(void)
{
	int a[5];//��̬�����һά���飺��ռ��20���ֽڣ�ÿ4���ֽ����һ��Ԫ�أ��������н����󣬿ռ��Զ��ͷš�
	int len;
	int * pArr;
	int i;

	//���춯̬һά����
	printf("����������Ԫ������");
	scanf("%d",&len);
	pArr = (int *)malloc(4 * len);//��̬����һά���飺��������pArr����len��Ԫ�ء�����Ч��������int pArr[len];

	//����һλ�����Ԫ��
	printf("����������Ԫ�أ�\n");
	for (i=0;i<len;++i)
		scanf("%d",&pArr[i]);

	//���һά�����Ԫ��
	printf("�����Ԫ�����£�\n");
	for (i=0;i<len;++i)
		printf("%d ",pArr[i]);

	//�������С����
	printf("\n");
	realloc(pArr,100);

    //�ͷŶ�̬һά����
	free(pArr);

	return 0;
}