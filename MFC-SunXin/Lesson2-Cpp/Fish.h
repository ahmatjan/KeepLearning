# include "Animal.h"

# ifndef FISH_H_H
# define FISH_H_H

class Fish : public Animal	//类的继承
{
public:
	Fish();
	~Fish();

	void breath();		//覆盖函数： 用派生类中的函数覆盖父类中的函数。
};

# endif
