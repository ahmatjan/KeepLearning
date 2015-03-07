/*
    2012年4月11日22:23:55
	最简单的构造函数
*/
#include <iostream>
using namespace std;

class time
{
public:
	time()//构造函数，函数名跟类的名字相同
	{
		hour = 0;
		minute = 0;
		second = 0;
	}
	void set_time();
	void show_time();
private:
	int hour;
	int minute;
	int second;
};

void time::set_time()
{
	cin >> hour;
	cin >> minute;
	cin >> second;
}

void time::show_time()
{
	cout << hour << ":" << minute << ":" << second << endl;
}

int main()
{
	time t1, t2;

	t1.set_time();
	t1.show_time();
	t2.show_time();

	return 0;
}