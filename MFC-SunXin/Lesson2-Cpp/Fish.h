# include "Animal.h"

# ifndef FISH_H_H
# define FISH_H_H

class Fish : public Animal	//��ļ̳�
{
public:
	Fish();
	~Fish();

	void breath();		//���Ǻ����� ���������еĺ������Ǹ����еĺ�����
};

# endif
