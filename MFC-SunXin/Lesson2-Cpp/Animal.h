#ifndef ANIMAL_H_H
#define ANIMAL_H_H

class Animal
{
public:
	Animal(int height, int weight);	//���캯��
	~Animal();						//��������
	void eat();
	void sleep();
	virtual void breath();// = 0;	//�麯��

	int weight, height;
};

#endif