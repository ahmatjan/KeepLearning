/*
时间：2012年2月12日20:00:46
功能：测试数组跨函数调用。
目的：验证传统数组的缺陷。
*/
# include<stdio.h>

void g(int * pArr,int len)
{
	pArr[2] = 88;
}

void f(void)
{
	int a[5]={1,2,3,4,5};//数组占用的20字节内存，不能手动释放
	g(a,5);              //函数运行结束后，内存自动释放
	printf("%d\n",a[2]);
}

int main(void)
{
	f();

	return 0;
}
/*
传统数组缺陷：
1.数组的长度必须定义，且为长整数，不能为变量；
2.数组的长度一旦确定，就不能更改；
3.数组的内存不能手动释放；
4.传统数组不能跨函数使用。
*/
