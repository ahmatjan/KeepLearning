/*
    2012��7��4��13:58:41
	������ ���ã��ڼ̳м�ӹ�ͬ����ʱ��ֻ����һ�ݳ�Ա��
	�����ĳ�ʼ������������ֱ�ӻ���� ��ʼ���������������ĳ�ʼ����
	                �����Ĺ��캯�������ö�Σ���ֻ�����һ��������������á�
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
	graduate grad1("С��",'m', 15, "�ǳ�ţX�Ŀ���", 100, 5000);
	grad1.show();

	return 0;
}
