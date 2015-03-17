/*
    2012年4月24日23:46:58
	了解应用 常引用
	常指针 与 常引用 类似，优点：
	              1.直接寻址，不必拷贝，提高效率
				  2.保证形参对象不被修改
*/
#include <iostream>
using namespace std;

class time
{
public:
	int hour;
	int minute;
	int second;

	time(int, int, int);
};

time::time(int h, int m, int s)
{
	hour = h;
	minute = m;
	second = s;
}

void fun(const time & t)//常引用：程序会报错，因为这的 常引用不允许修改对象！！！
{
	t.hour = 18;
}

int main()
{
	time t1(10, 11,12);
	fun(t1);
	cout << t1.hour << endl;
	
	return 0;
}