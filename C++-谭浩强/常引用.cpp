/*
    2012��4��24��23:46:58
	�˽�Ӧ�� ������
	��ָ�� �� ������ ���ƣ��ŵ㣺
	              1.ֱ��Ѱַ�����ؿ��������Ч��
				  2.��֤�βζ��󲻱��޸�
*/
#include <iostream>
using namespace std;

class time
{
public:
	int hour;
	int minute;
	int second;

	time(int, int, int);
};

time::time(int h, int m, int s)
{
	hour = h;
	minute = m;
	second = s;
}

void fun(const time & t)//�����ã�����ᱨ����Ϊ��� �����ò������޸Ķ��󣡣���
{
	t.hour = 18;
}

int main()
{
	time t1(10, 11,12);
	fun(t1);
	cout << t1.hour << endl;
	
	return 0;
}