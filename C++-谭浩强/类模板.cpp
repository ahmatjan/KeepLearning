/*
    2012��4��29��21:21:32
	�˽�Ӧ����ģ��

    ��ģ���ǲ��������࣬����ĳ���
	    ���� ������ compare Ҫд�� compare<numtype>
*/
# include <iostream>
using namespace std;
template <class numtype>

class compare
{
public:
	compare(numtype a, numtype b): x(a), y(b) {}
	numtype max();
	numtype min();

private:
	numtype x;
	numtype y;
};
/*���¼�Ϊ��ģ���ⲿ���庯����ʽ��*/
template <class numtype>            
numtype compare <numtype>::max()   
{
	return (x > y) ? x : y;
}

template <class numtype>
numtype compare <numtype>::min()
{
	return (x < y) ? x : y;
}

int main()
{
	compare <int> cmp1(3, 7);//��Ϊ��ģ�嶨�������ʽ
	cout << cmp1.max() << ' ' << cmp1.min() << endl;
	compare <double> cmp2(5.33, 7.44);
	cout << cmp2.max() << ' ' << cmp2.min() << endl;
	compare <char> cmp3('a', 'A');
	cout << cmp3.max() << ' ' << cmp3.min() << endl;

	return 0;
}

