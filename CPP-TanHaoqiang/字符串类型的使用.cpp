#include <iostream>
#include <string>
using namespace std;

int main()
{
	string a, b, c, d;
	int i;

	a = "China";
	b = "C++";
	c = "language";
	d = b + c;                                             //�ַ��������
	cout << a << '\n' 
		 << b << '\n'
		 << c << '\n'
		 << d << '\n' << endl;
	b[0] = 'D';                                            //�޸��ַ����е����ַ�
	cout << b << endl; 
	string st[5] = {"Zhang", "Wang", "Li", "Zhao", "Qian"};//�ַ��������ʹ��
	for (i = 0; i < 5; i++)
	{
		cout << st[i] << '\n';
	}

	return 0;
}