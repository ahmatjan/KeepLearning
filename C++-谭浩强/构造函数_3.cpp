/*
    2012年4月12日14:57:10
    1. 使用 带默认参数的构造函数，
	2. 构造函数中，录入 字符串 给数据成员
*/
#include <iostream>
using namespace std;

class student
{
public:
	/*
	    以下语句用到两点：
		1.默认参数
		2.录入字符串给成员函数
	*/
	student(int n, char s, char nam[]):num(n), sex(s) {strcpy(name, nam);}
	student();
	void show();

private:
	int num;
	char sex;
	char name[20];
};


void student::show()
{
	cout << "学号：" << num << endl;
	cout << "性别：" << sex << endl;
	cout << "姓名：" << name << endl;
}

int main()
{
	student stu1(10003, 'm', "Wang_zihao");
	stu1.show();

	student stu2(10002, 'f', "Zhang_hua");
	stu2.show();

	return 0;
}