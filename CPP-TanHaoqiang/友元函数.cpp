/*
    2012��4��29��22:42:19
	��Ԫ����������������Ԫ�������Է��ʶ����ڵ� ˽�ܳ�Ա��
*/
#include <iostream>
using namespace std;

class time
{
public:
	time(int h, int m, int s): hour(h), minute(m), second(s) {}
	friend void display(time &);

private:
	int hour;
	int minute;
	int second;
};

void display(time & t)
{
	cout << t.hour << ":" << t.minute << ":" << t.second << endl;
}

int main()
{
	time t1(10, 12, 14);
	display(t1);

	return 0;
}