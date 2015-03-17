/*
    2012年4月24日23:30:18
	了解 常对象 与 常对象成员（包括常数据成员和常成员函数）
*/
#include <iostream>
using namespace std;

class time
{
public:
	void get_time() const;//常成员函数，希望某个函数调用数据成员，却不修改时用到
	int hour;//常数据成员，希望对象中某个数据不被修改时用到
};

int main()
{
	const time t1;//常对象，希望所有数据成员不被修改时用到，要调用数据成员需用
	              //                                               常成员函数。

	return 0;
}
