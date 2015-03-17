/*
     2012年5月16日23:46:16
	 简单派生类构造函数
*/
#include <iostream>
#include <string>
using namespace std;

class student
{
public:
	student(int n, string nam, char s)
	{
		num = n;
		name = nam;
		sex = s;
	}
	~student() {};

protected:
	int num;
	string name;
	char sex;
};

class student1: public student
{
public:
	student1(int n, string nam, char s, int a, string add):student(n, nam, s)
	{
		age = a;
		addr = add;
	}
	void show()
	{
		cout << "num:" << num << endl;
		cout << "name:" << name << endl;
		cout << "sex:" << sex << endl;
		cout << "age:" << age << endl;
		cout << "address:" << addr << endl;
		cout << endl;
	}
	~student1() {};

protected:
	int age;
	string addr;
};

int main()
{
	student1 stu1(1001, "小明", 'm', 15, "山东威海");
	student1 stu2(1002, "小红", 'f', 15, "山东威海");

	stu1.show();
	stu2.show();
	
	return 0;
}