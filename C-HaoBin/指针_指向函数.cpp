/*
    2012��4��23��23:20:19
	����ָ������ָ��
*/
#include <iostream>
using namespace std;

void max(int a, int b)
{
	if (a > b)
		cout << "���ֵ�ǣ�" << a << endl;
	else
		cout << "���ֵ�ǣ�" << b << endl;
}

int main()
{
	void (*p)(int, int);

	p = max;
	(*p)(3, 4);

	return 0;
}