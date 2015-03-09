#include <stdio.h>

void filecopy(FILE *ifp, FILE *ofp);

int main(int argc, char *argv[])
{
	FILE *fp;

	if (argc == 0)
	{
		filecopy(stdin, stdout);
	}
	else
	{
		while (--argc > 0)
		{
			if (NULL == (fp=fopen(*++argv, "r")))
			{
				printf("cat: can't open %s.", *argv);
				return 1;
			}
			else
			{
				filecopy(fp, stdout);
				fclose(fp);
			}
		}
	}

	return 0;
}

void filecopy(FILE *ifp, FILE *ofp)
{
	int c;

	while ((c=getc(ifp)) != EOF)
	{
		putc(c, ofp);
	}
}
