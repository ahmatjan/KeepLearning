/*
    2012年4月29日22:44:07

*/
#include <iostream>
using namespace std;

class complex
{
public:
	complex(double r = 0, double i = 0): real(r), image(i) {}
	complex operator+(complex &);
	void display();

private:
	double real;
	double image;
};
/* 运算符重载函数 */
complex complex::operator+(complex & c2)
{
	return complex(real + c2.real, image + c2.image);
}

void complex::display()
{
	cout << '(' << real << '+' << image << "i)" << endl;
}

int main()
{
	complex c1(10, 12), c2(6, 7);
	complex c3;

	c3 = c1 + c2;
	c1.display();
	c2.display();
	c3.display();


	return 0;
}
