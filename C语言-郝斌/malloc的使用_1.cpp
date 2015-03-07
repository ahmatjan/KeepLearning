/*
    2012年2月12日21:23:42
	静态分配4个字节的内存，再动态分配4个内存的空间。
	熟悉malloc函数的使用语法。
	PS:malloc是memory(内存)和allocate(分配的缩写)。
*/
# include <stdio.h>
# include <malloc.h>
int main(void)
{
	int i = 5;//11行
	int * p = (int *)malloc(4);//12行
	          /*
			  malloc函数使用：
			  1.使用malloc函数必须加头文件<stdio.h>
			  2.malloc函数只有一个形参，且形参是整型
			  3.4表示系统为本程序分配4个字节
			  4.malloc的返回值是第一个字节的地址，所以必须通过(int *)把这个地址强制转换成(int *)类型，来确定动态分配的内存，多少个字节算一个变量
			  5.12行分配了8个字节，p变量本身占4个字节，p指向的变量也占4个字节
			  6.p所占内存是静态分配的，p所指向的内存是动态分配的
	          */
	*p = 5;
	printf("%d\n",*p);//*p代表的是一个int变量，只不过这个变量的内存分配方式是动态的，而11行变量内存分配方式是静态的
	free(p);//通过free()函数来释放p所指向的内存;p本身的内存是静态的，不能通过程序员手动释放
	printf("%d\n",*p);//此时p所指向的内存，是个垃圾值

	return 0;
}
