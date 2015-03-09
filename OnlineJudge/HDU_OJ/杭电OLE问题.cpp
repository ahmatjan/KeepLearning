#include <stdio.h>

int main(void)
{
    int n, m, i, t, sum, yu, j, prime;

    while (scanf("%d %d", &n, &m)!=EOF)    /*要加个!=EOF,不然会超时*/
    {
        sum = prime = 0;
        for (i = 0; i < n; i++)
        {
            t = 2 * i + 2;
            sum += t;
            prime++;
            if (prime == m && i!=n-1)       /*i!=n-1 判断是不是已经最后一个数了*/
            {
                printf("%d ", sum / m);
                sum = prime = 0;
            }
        }
        if (prime)
            printf("%d", sum / prime);
        printf("\n");
    }

    return 0;
} 