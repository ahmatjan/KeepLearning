#include <iostream>
using namespace std;
const int N = 100;

class set
{
public:
	set();//Ĭ�Ϲ��캯��	
	set(int a[], int s);//���ع��캯��	
	void empty();//��ռ���	
	int isempty();//�ж��Ƿ�ռ�
	int member(int a);//�ж��Ƿ��Ǽ�����Ԫ��
	int add(int a);//�򼯺������Ԫ��
	int del(int a);//ɾ�������е�ĳ��Ԫ��
	int equ(set & set2);//�ж����������Ƿ����	
	set intersection (set & set2);//�������Ͻ���
	set merge(set & set2);//�������ϲ���
	void copy(set & set2);//���Ƽ���
	void disp();//�������

	int elem[N];
	int num;
};

set::set()
{
	num = 0;
}

set::set(int a[], int s)
{
	num = s;
	for (int i = 0; i < s; i++)
	{
		elem[i] = a[i];
	}
}

void set::empty()
{
	num = 0;
}

int set::isempty()
{
	if (num == 0)
		return 1;
	else
		return 0;
}

int set::member(int a)
{
	for (int i = 0; i < num; i++)
	{
		if (elem[i] == a)
			return 1;
	}
	return 0;
}

int set::add(int a)
{
	if (member(a) == 0)
	{
		elem[num++] = a;
		return 1;
	}
	return 0;
}

int set::del(int a)
{
	
	for (int i = 0; i < num; i++)
	{
		if (elem[i] == a)
		{
			elem[i] = elem[num--];
			return 1;
		}
	}
	return 0;
}

int set::equ(set & set2)
{
	if (num == set2.num)
	{
		for (int i = 0; i < set2.num; i++)
		{
			if (member(set2.elem[i]) == 0)
				return 0;
		}
		return 1;
	}
	else
		return 0;
}

set set::intersection(set & set2)
{
	set set3;
	for (int i = 0; i < set2.num; i++)
	{
		if (member(set2.elem[i]))
			set3.add(set2.elem[i]);
	}
	return set3;
}

set set::merge(set & set2)
{
	set set3(this->elem, this->num);
	for (int i = 0; i < set2.num; i++)
	{
		if (set3.member(set2.elem[i]) == 0)
			set3.add(set2.elem[i]);
	}
	return set3;
}

void set::copy(set & set2)
{
	num = set2.num;
	for (int i = 0; i < num; i++)
	{
		elem[i] = set2.elem[i];
	}
}

void set::disp()
{
	for (int i = 0; i < num; i++)
	{
		cout << elem[i] << ' ';
	}
	cout << endl;
}

int main()
{
	int a[7] = {0, 1, 2, 3, 4, 5, 6};
	int b[5] = {0, 1, 2, 13, 14};

	set set1(a, 7);
	set set2(b, 5);

	//�ж��Ƿ�ռ�
	if (set1.isempty() == 1)
		cout << "set1 is empty" << endl;
	else
		cout << "set1 is not empty" << endl;
	set1.disp();
	set2.disp();

	//�󽻼�
	set set3 = set1.intersection(set2);
	set3.disp();
	//�󲢼�
	set set4 = set1.merge(set2);
	set4.disp();

	return 0;

}
