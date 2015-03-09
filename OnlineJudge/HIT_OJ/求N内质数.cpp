/*
	2012年10月14日22:03:49
	试除法求NUM内的所有质数。。。  
	基本思想是： 1.第一个质数为2
				 2.剩下的质数，从3开始尝试， 从2到sqrt（i）来试除它，一旦被整除，则不是质数
	Orz。。花了N个小时才彻底搞定。。
	更多算法：http://blog.csdn.net/mxdlove00/article/details/8066111
*/
#include <stdio.h>
#include <math.h>
#include <malloc.h>

#define NUM 40000

int * test_prime(int n)
{
    int count = 0;
    int *prime = (int *)malloc(sizeof(int) * n);//此处必须用malloc申请数组空间，用int prime[4000]会失败！
    prime[count++] = 2;

    for(int i = 3; i <= n; i += 2)			//i代表NUM内被测试的数字；因为3以上偶数肯定不是质数，所以i每次+2
    {
		int is_prime = 1;

        for(int j = 2; j <= sqrt(i); j++)	//j代表被除数
        {
            if(i % j == 0)
            {
				is_prime = 0;
                break;
            }
        }
        if(is_prime)
            prime[count++] = i;
    }

    return prime;
}

int main()
{
	int * prime = test_prime(NUM);

	for (int i = 0; i < 3600; i++)       //几万内，质数的密度比约为 1/10
		printf("%d\n", prime[i]);

    return 0;
}
