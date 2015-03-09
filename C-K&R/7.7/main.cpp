char *fgets(char *s, int n, FILE *iop)
{
	int c;
	char *cs;

	cs = s;
	while ((--n>0) && (c=getc(iop)) != EOF)
	{
		if ((*cs = c) == '\n')
			break;

		*cs = '\0';

		return (c == EOF && cs == s) ? NULL : s;
	}
}

int fputs(char *s, FILE *fp)
{
	int c;

	while (c = *s++)
	{
		putc(c, fp);
	}

	return ferror(fp) ? EOF : 1;
}
