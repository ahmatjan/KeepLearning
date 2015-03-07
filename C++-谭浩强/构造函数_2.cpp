/*
    2012年4月11日22:25:24
	构造函数的 重载函数、带参数的构造函数（参数初始化表）、带默认参数的构造函数。
*/
#include <iostream>
using namespace std;

class box
{
public:
	box();
	/*下面这句用到了：
	               1.函数的重载
			       2.参数初始化表（可等价变换为 带参数的构造参数，即  a注释中内容）
	  注意：
	       以下语句可以带默认参数，但不能所有参数都含有默认参数,（box(int l = 10, int w = 10, int h = 10)）否则
		   box box3；会发生歧义。
	*/
	box(int l, int w, int h):length(l), width(w), height(h) {}//重载+参数初始化表
	int volume();

private:
	int length;
	int width;
	int height;
};

box::box()
{
	length = 5;
	width = 5;
	height = 5;
}

/*   a注释：
box::box(int l, int w, int h)
{
    length = l;
	width = w;
	height = h;
}
*/

int box::volume()
{
	return length * width * height;
}

int main()
{
	box box1;
	cout << "The volume of box1: " <<  box1.volume() << endl;

	box box2(3, 4, 5);
	cout << "The volume of box2: " << box2.volume() << endl;

	return 0;
}