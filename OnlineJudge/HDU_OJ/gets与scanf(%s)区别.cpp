/*
    2012��3��31��13:40:34
	̽�� scanf("%s", st) �� gets(st) ������
*/

#include <stdio.h>
#include <string.h>

int main()
{
	char st[50];
	int m, n;

	scanf("%d", &n);
	getchar();
	gets(st);
	m = strlen(st);
	printf("%d\n", m);

	return 0;
}
/*
    scanf("%s", st)���ո�ֹͣ,gets(st)������ֹͣ;
	���������пո���ַ�����Ҫ��gets(st)����Ҫ��getchar()���̻س�

*/