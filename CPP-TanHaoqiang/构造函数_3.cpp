/*
    2012��4��12��14:57:10
    1. ʹ�� ��Ĭ�ϲ����Ĺ��캯����
	2. ���캯���У�¼�� �ַ��� �����ݳ�Ա
*/
#include <iostream>
using namespace std;

class student
{
public:
	/*
	    ��������õ����㣺
		1.Ĭ�ϲ���
		2.¼���ַ�������Ա����
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
	cout << "ѧ�ţ�" << num << endl;
	cout << "�Ա�" << sex << endl;
	cout << "������" << name << endl;
}

int main()
{
	student stu1(10003, 'm', "Wang_zihao");
	stu1.show();

	student stu2(10002, 'f', "Zhang_hua");
	stu2.show();

	return 0;
}