#include <stdio.h>
#include <malloc.h>
#include <math.h>

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
	int n;
	
	while (scanf("%d", &n) != EOF)
	{
		if (n == 0)
			return 0;
		
		int * prime;
		prime = test_prime(40000);
		int people[3600];
		int i, j = 0;
		int executed = 0;
		
		for (i = 0; i < 3600; i++)
			people[i] = 1;
		
		for (i = 1; i <= n; i++)
		{
			if (people[i] == 1)	//未被淘汰者，为1， 可被淘汰
				j++;
			if (j == prime[executed])			//报数，每报到m，就淘汰
			{
				people[i] = 0;
				j = 0;
				executed++;
			}
			
			if (executed == n)	//若全淘汰，返回最后被淘汰者的编号
			{
				printf("%d\n", i);
				break;
			}
			
			if (i == n)		//此语句，构成循环
				i = 0;
		}
	}

	return 0;
}



