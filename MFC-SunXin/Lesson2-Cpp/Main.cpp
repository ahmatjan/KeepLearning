/*
	2013年2月13日14:07:56
	通过该程序，复习C++。
	具体包括：	三大特性：封装、继承、多态。
				其他特性：构造函数、 析构函数、 函数重载、 函数覆盖、 虚函数、 纯虚函数、
					抽象类、 变量引用、 宏定义避免重复包含头文件 等知识点。
*/
#include "Animal.h"
#include "Fish.h"
#include <iostream>

using namespace std;

int main()
{
//	Animal ani(300, 400);
//	ani.eat();
//	ani.sleep();

	Fish fis;	//构造和析构的调用顺序：通过构造函数和析构函数的提示，可以发现构造函数和析构函数的调用顺序。
	Animal * pAni;

	pAni = &fis;
	pAni->breath();		// 这一步体现了多态性， 根据breath 是否为虚函数，体现不同的结果。

	return 0;
}

/*
总结：
	1. 编写工程可以遵循以下顺序：
		① 创建WinMain.cpp
		② 编写 基类.cpp —— 编译调试 —— 把 基类.h 分离出去
		③ 编写 派生类.cpp 和 派生类.h
		④ 添加宏定义， 避免头文件重复包含。

	2. 一个类的父类没有缺省构造函数， 则需要在编写构造函数的时候手动调用调用。

	3. 编写类时，记得最后要加分号。否则会提示“constructors not allowed a return type”；
*/
