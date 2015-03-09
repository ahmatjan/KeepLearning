#ifndef ANIMAL_H_H
#define ANIMAL_H_H

class Animal
{
public:
	Animal(int height, int weight);	//构造函数
	~Animal();						//析构函数
	void eat();
	void sleep();
	virtual void breath();// = 0;	//虚函数

	int weight, height;
};

#endif