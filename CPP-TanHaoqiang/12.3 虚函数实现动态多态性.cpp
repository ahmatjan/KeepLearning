#include <iostream>
#include <string>
using namespace std;

class Student
{
public:
	Student(int, string, float);
	virtual void display();
protected:
	int num;
	string name;
	float score;
};
Student::Student(int n, string nam, float sco)
{
	num = n;
	name = nam;
	score = sco;
}
void Student::display()
{
	cout << "Number:" << num << "\tName:" << name << "\tScore:" << score << endl;
}

class Graduate: public Student
{
public:
	Graduate(int, string, float, float);
	void display();
protected:
	float wage;
};
Graduate::Graduate(int n, string nam, float sco, float wag): Student(n, nam, sco), wage(wag) {}
void Graduate::display()
{
	cout << "Number:" << num << "\tName:" << name << "\tScore:" << score << "\tWage:" << wage << endl;
}
int main()
{
	Student stu1(110410309, "陈中正", 80);
	Graduate gra1(111111111, "李华", 90, 5000);
	Student * pt = &stu1;
	pt->display();
	pt = &gra1;
	pt->display();

	getchar();
	return 0;
}