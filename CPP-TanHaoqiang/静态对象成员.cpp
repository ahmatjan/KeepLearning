/*
    2012��4��28��10:55:59
	�˽�Ӧ�ö���ľ�̬��Ա
*/
#include <iostream>
using namespace std;

class student
{
public:
	student(int n, int a, float g): num(n), age(a), grade(g) {}
	void total();
	static float average();//��̬��Ա����

private:
	int num;
	int age;
	float grade;
	static float sum;//��̬���ݳ�Ա
	static int count;//��̬���ݳ�Ա
};

void student::total()//��ͬʱ��Ҫ��thisָ��;�̬���ݳ�Աʱ�������÷Ǿ�̬��Ա������
{
	sum += grade;
	count++;
}

float student::average()//��Ҫͨ����̬��Ա���������þ�̬���ݳ�Ա
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