/*
    2012��4��11��22:25:24
	���캯���� ���غ������������Ĺ��캯����������ʼ��������Ĭ�ϲ����Ĺ��캯����
*/
#include <iostream>
using namespace std;

class box
{
public:
	box();
	/*��������õ��ˣ�
	               1.����������
			       2.������ʼ�����ɵȼ۱任Ϊ �������Ĺ����������  aע�������ݣ�
	  ע�⣺
	       ���������Դ�Ĭ�ϲ��������������в���������Ĭ�ϲ���,��box(int l = 10, int w = 10, int h = 10)������
		   box box3���ᷢ�����塣
	*/
	box(int l, int w, int h):length(l), width(w), height(h) {}//����+������ʼ����
	int volume();

private:
	int length;
	int width;
	int height;
};

box::box()
{
	length = 5;
	width = 5;
	height = 5;
}

/*   aע�ͣ�
box::box(int l, int w, int h)
{
    length = l;
	width = w;
	height = h;
}
*/

int box::volume()
{
	return length * width * height;
}

int main()
{
	box box1;
	cout << "The volume of box1: " <<  box1.volume() << endl;

	box box2(3, 4, 5);
	cout << "The volume of box2: " << box2.volume() << endl;

	return 0;
}