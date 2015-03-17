#include "clock1.cpp"

int  main()
{
	clock MyClock;

	MyClock.SetTime (12, 40, 6);
	MyClock.ShowTime (2);
	MyClock.ShowTime ();

	return 0;
}
