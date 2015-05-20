/*
    2014-02-08 11:26:07
    Practice the utility of QTextStream

*/
#include <QFile>
#include <QDebug>

int main()
{
    QFile file("file.txt");
    if (!file.open(QIODevice::ReadWrite | QIODevice::Text))
    {
        qDebug() << "fail to oppen" << endl;
        return 1;
    }

    //Output
    QTextStream out(&file);
    out << "Result: " << qSetFieldWidth(10) << left << 3.14 << 2.7;
    out.flush();

    //Input
    out.seek(0);
    while (!out.atEnd())
    {
        qDebug() << out.readLine();
    }

    return 0;
}

/*
    Notice:
    1. Every file has only one QTextStream,
so we need seek(0) when we want to read what we write just now.
    2. Had better open file(QIODevice::ReadWrite),
in case that your wanna to write and read the file.


*/
