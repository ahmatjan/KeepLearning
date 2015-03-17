/*
    2012Äê8ÔÂ6ÈÕ15:46:56
    
*/
#include <stdio.h>

typedef struct Student
{
	int num;
	char name[20];
	float grade;
}* PSTU, STU;

int main()
{
	STU st;
	PSTU pst = &st;
	pst->num = 200;

	printf("%d\n", pst->num);

	return 0;
}