/*
    2012年6月30日11:39:41
	1.派生类的构造函数和析构函数
	2.有子对象的构造函数和析构函数 
	     eg：student1():student(),monitor() {……};
*/
#include <iostream>
#include <string>
using namespace std;

class student
{
public:
	student(int n, string nam, char s): num(n), name(nam), sex(s) {}
	~student() {}
protected:
	int num;
	string name;
	char sex;
};

class student1: public student
{
public:
	student1(int n, string nam, char s, int a, string ad): student(n, nam, s)
	{
		age = a;
		addr = ad;
	}
	~student1() {}
	void show()
	{
		cout << "number:" << num << endl;
		cout << "name:" << name << endl;
		cout << "sex:" << sex << endl;
		cout << "age:" << age << endl;
		cout << "address:" << addr << endl << endl;
	}
private:
	int age;
	string addr;
};

int main()
{
	student1 stu1(1001, "WangLi", 'm', 15, "山东威海");
	student1 stu2(1002, "ZhangHua", 'f', 16, "山东青岛");
	stu1.show();
	stu2.show();
	
	return 0;
}