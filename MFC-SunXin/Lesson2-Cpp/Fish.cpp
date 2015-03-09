#include "Fish.h"
#include <iostream>
using namespace std;

Fish::Fish() : Animal(300, 400)	//由于Fish父类没有缺省的构造函数，因此必须手动调用父类的构造函数。
{
	cout << "Fish construct" << endl; 
}

Fish::~Fish()
{
	cout << "Fish disconstruct" << endl;
}

void Fish::breath()
{
	cout << "Fish bubble" << endl;
}