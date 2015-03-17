/*
    2012年4月29日22:44:07

*/
#include <iostream.h>

class complex
{
public:
	complex(double r = 0, double i = 0): real(r), image(i) {}
	complex operator+(complex &);
	void display();
	friend complex operator+(int &i, complex &t);
	friend complex operator+(complex &t, int &i);

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

complex operator+(int &i, complex &t)
{
	return complex(i + t.real, t.image);
}

complex operator+(complex &t, int &i)
{
	return complex(i + t.real, t.image);
}

int main()
{
	complex c1(10, 12), c2(6, 7);
	complex c3, c4;

	c3 = c1 + c2;
	c1.display();
	c2.display();
	c3.display();

	int i = 1;
	c4 = i + c1;
	c4.display();


	return 0;
}
