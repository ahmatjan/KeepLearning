#include <QFile>
#include <QDebug>

int main()
{
    QFile file("file.dat");
    if (!file.open(QIODevice::ReadWrite))
    {
        qDebug() << "fail to open." << endl;
        return 1;
    }

    QDataStream stream(&file);

    //Write File
    QString str = "The answer is:";
    qint32 answer = 42;
    stream << str << answer;
    file.flush();

    //Read File
    QString str2;
    qint32 answer2;
    stream.device()->seek(0);
    stream >> str2 >> answer2;
    qDebug() << str2 << answer2 << endl;

    return 0;
}
