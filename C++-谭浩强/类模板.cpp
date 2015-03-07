/*
    2012年4月29日21:21:32
	了解应用类模板

    类模板是参数化的类，是类的抽象。
	    即， 以往的 compare 要写成 compare<numtype>
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
/*以下即为类模板外部定义函数方式：*/
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
	compare <int> cmp1(3, 7);//此为类模板定义变量形式
	cout << cmp1.max() << ' ' << cmp1.min() << endl;
	compare <double> cmp2(5.33, 7.44);
	cout << cmp2.max() << ' ' << cmp2.min() << endl;
	compare <char> cmp3('a', 'A');
	cout << cmp3.max() << ' ' << cmp3.min() << endl;

	return 0;
}

