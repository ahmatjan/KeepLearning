/*
    2012年4月26日0:01:42
	掌握应用对象的动态建立和释放
*/
#include <iostream>
using namespace std;

class box
{
public:
	int hour;
	int minute;
	int second;

	box(int h, int m, int s): hour(h), minute(m), second(s) {}
};

int main()
{
	box * p;

	p = new box(10, 12, 15);
	cout << p->hour << endl;
	delete p;

	return 0;
}
/*
    C++中申请动态内存： box * p = new box;
	C中申请动态内存：   int * p = (int *)malloc(sizeof(int));
*/