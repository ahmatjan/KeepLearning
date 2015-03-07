#include <iostream>
using namespace std;

class box
{
public:
	box(int l, int w, int h): height(h), width(w), length(l) {}
	int volume();

private:
	int height;	
	int width;
	int length;

};

int box::volume()
{
	return (length * width * height);
}

int main()
{
	box a[3] = {
		box(1, 2, 3),
		box(2, 3, 4),
		box(3, 4, 5)
	};

	cout << a[0].volume() << endl;
	cout << a[1].volume() << endl;
	cout << a[2].volume() << endl;

	return 0;
}