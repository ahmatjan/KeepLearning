/*
     2012年4月26日0:11:46
	 对象的赋值与复制
*/
#include <iostream>
using namespace std;

class box
{
public:
	int length;
	int width;
	int height;

	box(int l = 10, int w = 10, int h = 10): length(l), width(w), height(h)  {}
};

int main()
{
	box box1(11, 15, 12);
	box box2;

	box2 = box1;//对象的赋值

	box box3 = box1;//对象的复制
	box box4(box1);//对象的复制
	
	cout << box1.length << endl;
	cout << box2.length << endl;
	cout << box3.length << endl;
	cout << box4.length << endl;

	return 0;
}