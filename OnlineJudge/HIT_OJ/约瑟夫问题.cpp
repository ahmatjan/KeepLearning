/*
	2012��10��17��17:12:55
	Լɪ������
	����˼·��	1.����һ��nԪ��ѭ�����飬��ÿ��Ԫ�ص�ֵΪ1
				2.ÿm��ֵΪ1��Ԫ�أ���̭һ����ֱ��ȫ��̭
*/
#include <iostream>
using namespace std;

int joseph(int n, int m);

int main()
{
	int m, n;

	cout << "�����빲�����ˣ�" << endl;
	cin >> n;
	cout << "������һ�����֣�" << endl;
	cin >> m;
	cout << "���ʤ�����˵ı���ǣ�" << joseph(n, m) << endl;

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
		if (people[i] == 1)	//δ����̭�ߣ�Ϊ1�� �ɱ���̭
			j++;
		if (j == m)			//������ÿ����m������̭
		{
			people[i] = 0;
			j = 0;
			executed++;
		}

		if (executed == n)	//��ȫ��̭�����������̭�ߵı��
		{
			return i;
			break;
		}

		if (i == n)		//����䣬����ѭ��
			i = 0;
	}
}