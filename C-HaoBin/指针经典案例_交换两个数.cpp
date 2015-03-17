/*
    时间：2012年1月24日22:25:00
	功能：互换两个数
	目的：弄懂指针的功能
*/
# include <stdio.h>
/*方法一失败：形参在swap函数结束后，即释放，并没有返回到main函数*/
void swap_1(int a,int b)
{
	int t;

	t = a;
	a = b;
	b = t;
}
/*方法二失败：a、b的地址存在p、q中，swap_2只是交换了p、q的内容，并没有改变a和b的地址*/
/*总结：swap_2想要交换a和b的地址，但这是不可能的*/
void swap_2(int * p,int * q)
{
	int * t;

	t = p;
	p = q;
	q = t;
}
/*方法三成功:通过指针，改变了a、b所在内存的存储内容*/
void swap_3(int * p,int * q)
{
	int t;
	t = *p;
	*p = *q;
	*q = t;
}
void main()
{
	int a = 3;
	int b = 5;

	swap_3(&a,&b);
	printf("a = %d\nb = %d\n",a,b);
	return 0;
}