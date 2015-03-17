# include <stdio.h>
# include <malloc.h>

void f(int * q)
{
	*q = 200;
}

int main(void)
{
	int * p = (int *)malloc(sizeof(int));//sizeof(int)表示的是int所占字节数。
	*p = 10;
	printf("%d\n",*p);//10
	f(p);
	printf("%d\n",*p);//200

	return 0;
}