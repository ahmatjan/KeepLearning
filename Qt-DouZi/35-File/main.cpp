#include <QApplication>
#include <QFile>
#include <QFileInfo>
#include <QDebug>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QFile file("in.txt");
    if (!file.open(QIODevice::ReadOnly | QIODevice::Text))
    {
        qDebug() << "Failed to open.";
        return 1;
    }

    while (!file.atEnd())
    {
        qDebug() << file.readLine();
    }

    QFileInfo info(file);
    qDebug() << "Dir" << info.isDir();
    qDebug() << "Exe" << info.isExecutable();
    qDebug() << "BaseName" << info.baseName();
    qDebug() << "CompleteBaseName" << info.completeBaseName();
    qDebug() << "Suffix" << info.suffix();
    qDebug() << "CompleteSuffix" << info.completeSuffix();

    return app.exec();
}
