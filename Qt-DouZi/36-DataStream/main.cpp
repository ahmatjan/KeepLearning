#include <QApplication>
#include <QFile>
#include <QDataStream>
#include <QDebug>

/*
int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QFile file("file.dat");
    if (!file.open(QIODevice::ReadWrite))
    {
        qDebug() << "Failed to open.";
        return 1;
    }

    //写入数据
    QDataStream out(&file);
    QString strIn = "The answer is 42";

    out << "The answer is 42";
    file.flush();

    //读出数据
    QDataStream in(&file);
    QString strOut;

    in >> strOut;
    qDebug() << strOut;
    file.close();

    return 0;
}
*/
int main(int argc, char *argv[])
{
    QFile file("file.dat");
    file.open(QIODevice::ReadWrite);

    QDataStream stream(&file);
    QString str = "the answer is 42";
    QString strout;

    stream << str;
    stream.device()->seek(0);
    stream >> strout;

    return 0;
}
