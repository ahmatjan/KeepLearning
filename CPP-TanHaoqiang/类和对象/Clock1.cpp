

/*
    2012年4月6日21:36:56
	模拟闹钟功能。
	练习使用c++面向对象程序设计。
*/

/*构造一个闹钟的类*/
#include <iostream>
using namespace std;

class clock
{public:
	void SetTime(int, int, int);
	void ShowTime(int);
	void ShowTime();
private:
	int Hour;
	int Minute;
	int Second;
};

void clock::SetTime(int newH, int newM, int newS)
{
	Hour = newH;
	Minute = newM;
	Second = newS;
}

void clock::ShowTime(int n)
{
	cout << Hour << "点" << Minute << "分" << Second << "秒" << endl;
}

/*ShouTime 的重载*/
void clock::ShowTime()
{
	cout << Hour << ":" << Minute << ":" << Second << endl;
}

