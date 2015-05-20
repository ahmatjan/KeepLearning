/*
   2013年2月4日
   练习数据库的基本操作：
    1. 连接数据库
    2. 创建表
    3. 增删改查(数据的绑定)
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

    qDebug() << "After inserting:";
    //插入数据：1
    /*
    query.exec("INSERT INTO STUDENT VALUES (0, 'Zhang San')");
    query.exec("INSERT INTO STUDENT VALUES (1, 'Li Si')");
    query.exec("INSERT INTO STUDENT VALUES (2, 'Wang Ermazi')");
    */

    //插入数据：2
    /*
    query.prepare("INSERT INTO STUDENT VALUES (:id, :name)");
    int idValue = 0;
    QString nameValue = "Xiao Zhang";
    query.bindValue(":id", idValue);
    query.bindValue(":name", nameValue);
    query.exec();
    */

    //插入数据：3
    /*
    query.prepare("INSERT INTO STUDENT VALUES (?, ?)");
    int idValue = 0;
    QString nameValue = "Xiao Wang";
    query.addBindValue(idValue);
    query.addBindValue(nameValue);
    query.exec();
    */

    //插入数据：4
    /**/
    query.prepare("INSERT INTO STUDENT VALUES (?, ?)");
    QVariantList ids;
    ids << 0 << 1 << 2;
    QVariantList names;
    names << "Zhang San" << "Li Si" << "Wang Wu";
    query.addBindValue(ids);
    query.addBindValue(names);
    query.execBatch();


    //查询数据：插入后
    query.exec("SELECT * FROM STUDENT");
    while (query.next())
    {
        qDebug() << query.value(0).toInt() << query.value(1).toString();
    }

    return 0;
}
