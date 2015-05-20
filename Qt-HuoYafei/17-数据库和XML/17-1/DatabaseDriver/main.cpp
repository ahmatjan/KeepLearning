#include <QApplication>
#include <QSqlDatabase>
#include <QStringList>
#include <QDebug>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QStringList drivers;
    QString driver;

    drivers = QSqlDatabase::drivers();
    foreach (driver, drivers)
    {
        qDebug() << driver;
    }

    return app.exec();
}
