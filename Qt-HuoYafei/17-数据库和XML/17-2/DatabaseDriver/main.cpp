#include <QApplication>
#include <QVariant>
#include <QSqlDatabase>
#include <QSqlQuery>
#include <QDebug>
#include <QSqlError>

bool connect()
{
    QSqlDatabase db = QSqlDatabase::addDatabase("QSQLITE");
    db.setDatabaseName(":memory:");

    if (!db.open())
    {
        qDebug() << "Can not open database.";

        return false;
    }

    return true;
}

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    //链接数据库
    if (!connect())
        return 1;

    QSqlQuery query;
    //创建表格
    query.exec("CREATE TABLE STUDENT (ID INT PRIMARY KEY, NAME VCHAR(20))");
    qDebug() << query.lastError();
    //插入数据
    query.exec("INSERT INTO STUDENT VALUES(0,'LiMing')");
    qDebug() << query.lastError();
    query.exec("INSERT INTO STUDENT VALUES(1, 'LiuTao')");
    qDebug() << query.lastError();
    query.exec("INSERT INTO STUDENT VALUES(2, 'WangHong')");
    qDebug() << query.lastError();
    //查询数据
    query.exec("SELECT * FROM STUDENT");
    while (query.next())
    {
        qDebug() << query.value(0).toInt() << query.value(1).toString();
    }

    //return app.exec();
    return 0;
}
