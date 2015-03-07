/*
时间：2012年1月31日22:02:54
功能：求指针变量的长度。
目的：求指针变量的长度。
*/
# include <stdio.h>
int main(void)
{
	char ch = 'A';
	int a = 99;
	double b = 66.6;
	char * p = &ch;
	int * q = &a;
	double * i = &b;
	printf("%d %d %d \n",sizeof(p),sizeof(q),sizeof(i));//sizeof(变量类型)或sizeof(变量名)=所占字节数


	return 0;
}
/*PS:
1.不管什么类型的指针变量，都占4个字节。
2.【指针变量】存储，【所指向的变量】【所占空间】的【第一个字节】的地址。
3.一个字节的地址占4个字节：因为CPU与内存间有32条地址总线(控制4G内存)，因而占32位，即4个字节。
*/