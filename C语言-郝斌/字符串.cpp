/*
    2012��2��13��14:46:21
	�ַ����Ĵ洢�����
*/
# include <stdio.h>

int main()
{
	char st[15];
	printf("Input string:");
	gets(st);
	puts(st);

	return 0;
}
/*
     �ַ�����¼�룺
	 3.char * st = "C language";
	 7.char * st;
	   st = "C language"                      PS:����Ǵ�˵�е��ַ���ָ��洢, ��char * st���ȼ��� ��char st[]��;
     4.char c[] = "C program";                PS:ʵ�ʴ洢����"C program\0"

	
	 5.char st[15];                      
	   scanf("%s",st);
	 6.char st[15];
	   gets(st);							  PS:scanf��gets������scanf���ո������gets�����н���




	 �ַ����������
	 1.printf("%s\n",c);
	 2.puts(c);                               PS������ַ����󣬻��Զ��ӻ��У�
	 
*/

/*
	2012��11��20��22:09:19����

	C�������ַ����洢��Ҫ�����ַ����飺
	����ռ䣺  char st[15];    char st[];   char * st;
	��ֵ��		��һ��ֱ�Ӹ�ֵ��scanf�Կ�
				�ڶ����б���ֱ�Ӹ�ֵ������scanf
*/