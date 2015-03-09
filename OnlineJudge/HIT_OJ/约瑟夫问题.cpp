/*
	2012年10月17日17:12:55
	约瑟夫问题
	基本思路：	1.建立一个n元素循环数组，且每个元素的值为1
				2.每m个值为1的元素，淘汰一个。直到全淘汰
*/
#include <iostream>
using namespace std;

int joseph(int n, int m);

int main()
{
	int m, n;

	cout << "请输入共多少人：" << endl;
	cin >> n;
	cout << "请输入一个数字：" << endl;
	cin >> m;
	cout << "最后胜出的人的编号是：" << joseph(n, m) << endl;

	return 0;
}

int joseph(int n, int m)
{
	int people[3600];
	int i, j = 0;
	int executed = 0;

	for (i = 0; i < 3600; i++)
		people[i] = 1;

	for (i = 1; i <= n; i++)
	{
		if (people[i] == 1)	//未被淘汰者，为1， 可被淘汰
			j++;
		if (j == m)			//报数，每报到m，就淘汰
		{
			people[i] = 0;
			j = 0;
			executed++;
		}

		if (executed == n)	//若全淘汰，返回最后被淘汰者的编号
		{
			return i;
			break;
		}

		if (i == n)		//此语句，构成循环
			i = 0;
	}
}