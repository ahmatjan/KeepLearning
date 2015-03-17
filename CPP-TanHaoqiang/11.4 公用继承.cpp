#include <iostream>
#include <string>
using namespace  std;

class student
{
public:
	void get_value();
	void display();

private:
	int num;
	string name;
	char sex;
};

void student::get_value()
{
	cin >> num >> name >> sex;
}


void student::display()
{
	cout << "number:" << num << endl;
	cout << "name:" << name << endl;
	cout << "sex:" << sex << endl;
}

class student1: public student
{
public:
	void get_value_1();
	void display_1();

private:
	int age;
	string addr;
};

void student1::get_value_1()
{
	get_value();
	cin >> age >> addr;
}

void student1::display_1()
{
	display();
	cout << "age:" << age << endl;
	cout << "address:" << addr << endl;
}


int main()
{
	student1 stu1;
	cout << "Please input the number name sex age & address:" << endl;
	stu1.get_value_1();
	stu1.display_1();

	return 0;
}