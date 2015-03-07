filename = app_two

${filename}.exe: ${filename}.o ${filename}_res.o
	gcc -o ${filename}.exe ${filename}.o ${filename}_res.o -lgdi32 -lcomdlg32

${filename}.o:
	gcc -o ${filename}.o -c ${filename}.c

${filename}_res.o:
	windres ${filename}.rc ${filename}_res.o

clean:
	rm *.o
