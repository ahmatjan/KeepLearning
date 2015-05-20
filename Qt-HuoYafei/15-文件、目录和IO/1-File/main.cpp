#include <QFile>
#include <QDebug>
#include <QFileInfo>
#include <QDateTime>

int main(int argc, char *argv[])
{
    //文件写入数据
    QFile file("myfile.txt");
    if (!file.open(QIODevice::WriteOnly | QIODevice::Text))
    {
        qDebug() << file.errorString();
        return 1;
    }
    file.write("Hello Qt! \n I'm Jason Chen.");
    file.close();

    //文件读出数据
    if (!file.open(QIODevice::ReadOnly | QIODevice::Text))
    {
        qDebug() << file.errorString();
        return 1;
    }
    qDebug() << "The file's content is" << endl
             << file.readAll() << endl;
    qDebug() << "The position is" << file.pos() << endl;

    file.seek(0);
    QString array;
    array = file.read(5);
    qDebug() << "\nThe first 5 byte is:" << endl
             << array << endl;
    file.close();

    //文件的相关信息
    QFileInfo info(file);
    qDebug() << "The absolute file path is:" << info.absoluteFilePath() << endl
             << "The file name is:" << info.fileName() << endl
             << "The base name is:" << info.baseName() << endl
             << "The suffix is:" << info.suffix() << endl
             << "The create time is:" << info.created() << endl
             << "The size is:" << info.size() << endl;

    return 0;
}























