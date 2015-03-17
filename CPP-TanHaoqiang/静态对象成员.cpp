/*
    2012年4月28日10:55:59
	了解应用对象的静态成员
*/
#include <iostream>
using namespace std;

class student
{
public:
	student(int n, int a, float g): num(n), age(a), grade(g) {}
	void total();
	static float average();//静态成员函数

private:
	int num;
	int age;
	float grade;
	static float sum;//静态数据成员
	static int count;//静态数据成员
};

void student::total()//当同时需要用this指针和静态数据成员时，可以用非静态成员函数。
{
	sum += grade;
	count++;
}

float student::average()//主要通过静态成员函数来调用静态数据成员
{
	return (sum / count);
}

float student::sum = 0;
int student::count = 0;

int  main()
{
	student a[3] = 
	{
		student(1001, 20, 78),
		student(1002, 23, 100),
		student(1003, 48, 122)
	};
	for (int i = 0; i < 3; i++)
	{
		a[i].total();
	}

	cout << "The average of three student is:" << student::average() << endl;

	return 0;
}