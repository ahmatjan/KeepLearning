#include "Fish.h"
#include <iostream>
using namespace std;

Fish::Fish() : Animal(300, 400)	//����Fish����û��ȱʡ�Ĺ��캯������˱����ֶ����ø���Ĺ��캯����
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