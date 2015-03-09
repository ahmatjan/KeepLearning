/*
    2012年3月31日13:40:34
	探讨 scanf("%s", st) 与 gets(st) 的区别
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
    scanf("%s", st)遇空格停止,gets(st)遇换行停止;
	所以遇到有空格的字符串，要用gets(st)，但要加getchar()来吞回车

*/