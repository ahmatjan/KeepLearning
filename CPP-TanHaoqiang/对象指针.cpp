/*
    2012��4��23��23:28:28
	���ն���ָ�루���ơ�������ɢ���ºöࣩ
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
	/*ָ�����ݳ�Ա*/
	int* p1 = &t1.hour;
	cout << *p1 << endl;
	/*ָ�����*/
	time* p2 = &t1;
	p2->show_time();
	/*ָ���Ա����*/
	void (time::* p3)();
	p3 = time::show_time;
	(t1.*p3)();

	return 0;
}