/*
    2012年4月23日23:28:28
	掌握对象指针（郁闷。。。离散落下好多）
*/
#include <iostream>
using namespace std;

class time
{
public:
	time(int, int, int);
	void show_time();

	int hour;
	int minute;
	int second;
};

time::time(int h, int m, int s)
{
	hour = h;
	minute = m;
	second = s;
}

void time::show_time()
{
	cout << hour << ':' << minute << ':' << second << endl; 
}

int main()
{
	time t1(10, 18, 56);
	/*指向数据成员*/
	int* p1 = &t1.hour;
	cout << *p1 << endl;
	/*指向对象*/
	time* p2 = &t1;
	p2->show_time();
	/*指向成员函数*/
	void (time::* p3)();
	p3 = time::show_time;
	(t1.*p3)();

	return 0;
}