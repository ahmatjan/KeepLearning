

/*
    2012��4��6��21:36:56
	ģ�����ӹ��ܡ�
	��ϰʹ��c++������������ơ�
*/

/*����һ�����ӵ���*/
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
	cout << Hour << "��" << Minute << "��" << Second << "��" << endl;
}

/*ShouTime ������*/
void clock::ShowTime()
{
	cout << Hour << ":" << Minute << ":" << Second << endl;
}

