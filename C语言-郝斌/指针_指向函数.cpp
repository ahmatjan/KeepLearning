/*
    2012年4月23日23:20:19
	掌握指向函数的指针
*/
#include <iostream>
using namespace std;

void max(int a, int b)
{
	if (a > b)
		cout << "最大值是：" << a << endl;
	else
		cout << "最大值是：" << b << endl;
}

int main()
{
	void (*p)(int, int);

	p = max;
	(*p)(3, 4);

	return 0;
}