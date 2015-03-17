/*
    2012年4月24日23:31:56
	了解 常指针 与 常对象 的关系，及进行应用
*/
#include <iostream>
using namespace std;

class time
{
public:

};

int main()
{
	time t1;
	time * const p1;//指向对象的常指针，用于一指针固定指向一个对象。
	const time * p2;//指向常对象的指针，用于使指针指向的对象不能修改。
                    //    主要应用之一是，用于函数形参，使此函数不能修改对象。
	return 0;
}
