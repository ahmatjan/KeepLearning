/*
   2013年2月4日
   练习数据库的基本操作：
    1. 连接数据库
    2. 创建表
    3. 增删改查
*/

#include <QApplication>
#include <QSqlDatabase>
#include <QDebug>
#include <QVariant>
#include <QSqlQuery>
#include <QSqlError>

bool connectDatabase()
{
    QSqlDatabase db = QSqlDatabase::addDatabase("QSQLITE");
    db.setDatabaseName(":memory:");
    if (!db.open())
    {
        qDebug() << "Failed to open.";

        return false;
    }

    return true;
}

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    //连接数据库
    if (!connectDatabase())
    {
        qDebug() << "Failed to connect.";
        return 1;
    }
    //创建表格
    QSqlQuery query;
    query.exec("CREATE TABLE STUDENT (ID INT PRIMARY KEY, NAME VARCHAR(20))");
    ////qDebug() << query.lastError();

    //插入数据
    qDebug() << "After inserting:";
    query.exec("INSERT INTO STUDENT VALUES (0, 'Zhang San')");
    //qDebug() << query.lastError();
    query.exec("INSERT INTO STUDENT VALUES (1, 'Li Si')");
    //qDebug() << query.lastError();
    query.exec("INSERT INTO STUDENT VALUES (2, 'Wang Ermazi')");
    //qDebug() << query.lastError();
    //查询数据：插入后
    query.exec("SELECT * FROM STUDENT");
    //qDebug() << query.lastError();
    while (query.next())
    {
        qDebug() << query.value(0).toInt() << query.value(1).toString();
    }

    //删除数据
    query.exec("DELETE FROM STUDENT WHERE ID = 1");
    //qDebug() << query.lastError();
    //查询数据：删除后
    qDebug() << "After deleting:";
    query.exec("SELECT * FROM STUDENT");
    //qDebug() << query.lastError();
    while (query.next())
    {
        qDebug() << query.value(0).toInt() << query.value(1).toString();
    }

    //修改数据
    query.exec("UPDATE STUDENT SET NAME = 'Ha Ha' WHERE ID = 2");
    //qDebug() << query.lastError();
    //查询数据：修改后
    qDebug() << "After updating:";
    query.exec("SELECT * FROM STUDENT");
    //qDebug() << query.lastError();
    while (query.next())
    {
        qDebug() << query.value(0).toInt() << query.value(1).toString();
    }

    return 0;
}
