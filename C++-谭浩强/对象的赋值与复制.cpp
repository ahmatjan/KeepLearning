/*
     2012��4��26��0:11:46
	 ����ĸ�ֵ�븴��
*/
#include <iostream>
using namespace std;

class box
{
public:
	int length;
	int width;
	int height;

	box(int l = 10, int w = 10, int h = 10): length(l), width(w), height(h)  {}
};

int main()
{
	box box1(11, 15, 12);
	box box2;

	box2 = box1;//����ĸ�ֵ

	box box3 = box1;//����ĸ���
	box box4(box1);//����ĸ���
	
	cout << box1.length << endl;
	cout << box2.length << endl;
	cout << box3.length << endl;
	cout << box4.length << endl;

	return 0;
}