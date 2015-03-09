/*
    2012年3月4日13:46:18(acm第1091题)
	while的特殊使用
    while有时并不用于条件的判断，只用于制造循环，如while (1)
*/
# include <stdio.h>

int main(void)
{
    int a, b;

    while(scanf( "%d %d" , &a , &b ))
    {
        if(a == 0 && b == 0)
			break;
        else 
			printf("%d\n", a+b);
    }

	return 0;
}
