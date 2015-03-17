/*
    2012年7月4日13:58:41
	虚基类的 作用：在继承间接共同基类时，只保留一份成员。
	虚基类的初始化：不仅负责直接基类的 初始化，还负责虚基类的初始化。
	                虚基类的构造函数被调用多次，但只有最后一个派生类的起作用。
*/
#include <iostream>
using namespace std;
#include <string>

class person
{
public:
	person(string nam, char s, int a): name(nam), sex(s), age(a) {}
protected:
	string  name;
	char sex;
	int age;
};

class teacher: virtual public person
{
public:
	teacher(string nam, char s, int a, string  t): person(nam, s, a)
	{
		title = t;
	}
protected:
	string title;
};

class student: virtual public person
{
public:
	student(string nam, char s, int a, float sco): person(nam, s, a)
	{
		score = sco;
	}
protected:
	float score;
};

class graduate: public teacher, public student
{
public:
	graduate(string nam, char s, int a, string t, float sco, float w)
		: person(nam, s, a), teacher(nam, s, a, t), student(nam, s, a, sco), wage(w) {}
	void show()
	{
		cout << "name:" << name << endl;
		cout << "sex:" << sex << endl;
		cout << "age:" << age << endl;
		cout << "title:" << title << endl;
		cout << "score:" << score << endl;
		cout << "wage:" << wage << endl;
	}
protected:
	float wage;
};

int main()
{
	graduate grad1("小明",'m', 15, "非常牛X的课题", 100, 5000);
	grad1.show();

	return 0;
}
