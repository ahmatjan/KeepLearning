/*
	2012��10��14��22:03:49
	�Գ�����NUM�ڵ���������������  
	����˼���ǣ� 1.��һ������Ϊ2
				 2.ʣ�µ���������3��ʼ���ԣ� ��2��sqrt��i�����Գ�����һ������������������
	Orz��������N��Сʱ�ų��׸㶨����
	�����㷨��http://blog.csdn.net/mxdlove00/article/details/8066111
*/
#include <stdio.h>
#include <math.h>
#include <malloc.h>

#define NUM 40000

int * test_prime(int n)
{
    int count = 0;
    int *prime = (int *)malloc(sizeof(int) * n);//�˴�������malloc��������ռ䣬��int prime[4000]��ʧ�ܣ�
    prime[count++] = 2;

    for(int i = 3; i <= n; i += 2)			//i����NUM�ڱ����Ե����֣���Ϊ3����ż���϶���������������iÿ��+2
    {
		int is_prime = 1;

        for(int j = 2; j <= sqrt(i); j++)	//j��������
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

	for (int i = 0; i < 3600; i++)       //�����ڣ��������ܶȱ�ԼΪ 1/10
		printf("%d\n", prime[i]);

    return 0;
}
