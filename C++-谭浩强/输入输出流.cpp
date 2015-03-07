#include <iostream>
#include <iomanip>
using namespace std;

int  main()
{
	double  c = 123.455, d = 3.14159, e = -3214.67;

	cout << setiosflags(ios::fixed) << setiosflags(ios::right) << setprecision(2);
	cout << setw(10) << c << endl;
	cout << setw(10) << d << endl;
	cout << setw(10) << e << endl;

	return 0;
}