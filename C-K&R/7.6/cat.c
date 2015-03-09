#include <stdio.h>

void filecopy(FILE *, FILE *);

int main(int argc, char *argv[])
{
	FILE *fp;
	char *prog;

	prog = argv[0];

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
				fprintf(stderr, "%s: can't open %s.\n", prog, *argv);
				exit(1);
			}
			else
			{
				filecopy(fp, stdout);
				fclose(fp);
			}
		}
	}

	if (ferror(stdout))
	{
		fprintf(stderr, "%s: error writing stdout.\n", prog);
		exit(2);
	}

	exit(0);
}

void filecopy(FILE *ifp, FILE *ofp)
{
	int c;

	while ((c=getc(ifp)) != EOF)
	{
		putc(c, ofp);
	}
}
