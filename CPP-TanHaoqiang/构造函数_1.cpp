/*
    2012��4��11��22:23:55
	��򵥵Ĺ��캯��
*/
#include <iostream>
using namespace std;

class time
{
public:
	time()//���캯���������������������ͬ
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