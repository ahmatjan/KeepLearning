filename = app_four

${filename}.exe: ${filename}.o ${filename}_res.o
	gcc -o ${filename}.exe ${filename}.o ${filename}_res.o -lgdi32 -lcomdlg32 -lcomctl32

${filename}.o:
	gcc -o ${filename}.o -c ${filename}.c -g

${filename}_res.o:
	windres ${filename}.rc ${filename}_res.o

clean:
	rm *.o
