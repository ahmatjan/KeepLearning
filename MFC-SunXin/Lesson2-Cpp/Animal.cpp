# include "Animal.h"
# include <iostream>
using namespace std;

Animal::Animal(int a, int b)
{
	cout << "Animal construct" << endl;
}
Animal::~Animal()			
{
	cout << "Animal disconstruct" << endl;
}

void Animal::eat()
{
	cout << "Animal eat" << endl;
}

void Animal::sleep()
{
	cout << "Animal sleep" << endl;
}

void Animal::breath()
{
	cout << "Animal breath" << endl;
}
