#include <stdio.h>
#include <malloc.h>
#include <math.h>

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
			if (people[i] == 1)	//δ����̭�ߣ�Ϊ1�� �ɱ���̭
				j++;
			if (j == prime[executed])			//������ÿ����m������̭
			{
				people[i] = 0;
				j = 0;
				executed++;
			}
			
			if (executed == n)	//��ȫ��̭�����������̭�ߵı��
			{
				printf("%d\n", i);
				break;
			}
			
			if (i == n)		//����䣬����ѭ��
				i = 0;
		}
	}

	return 0;
}



