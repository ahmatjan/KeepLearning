#include <iostream>
#include <string>
using namespace std;

int main()
{
	string a, b, c, d;
	int i;

	a = "China";
	b = "C++";
	c = "language";
	d = b + c;                                             //字符串运算符
	cout << a << '\n' 
		 << b << '\n'
		 << c << '\n'
		 << d << '\n' << endl;
	b[0] = 'D';                                            //修改字符串中单个字符
	cout << b << endl; 
	string st[5] = {"Zhang", "Wang", "Li", "Zhao", "Qian"};//字符串数组的使用
	for (i = 0; i < 5; i++)
	{
		cout << st[i] << '\n';
	}

	return 0;
}