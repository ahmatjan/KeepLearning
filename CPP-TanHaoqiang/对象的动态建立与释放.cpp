/*
    2012��4��26��0:01:42
	����Ӧ�ö���Ķ�̬�������ͷ�
*/
#include <iostream>
using namespace std;

class box
{
public:
	int hour;
	int minute;
	int second;

	box(int h, int m, int s): hour(h), minute(m), second(s) {}
};

int main()
{
	box * p;

	p = new box(10, 12, 15);
	cout << p->hour << endl;
	delete p;

	return 0;
}
/*
    C++�����붯̬�ڴ棺 box * p = new box;
	C�����붯̬�ڴ棺   int * p = (int *)malloc(sizeof(int));
*/