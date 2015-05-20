#include <QApplication>
#include <QtGui>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QTableWidget tableWidget;
    tableWidget.setColumnCount(3);
    tableWidget.setRowCount(5);
    QList<QString> headerLabels;
    headerLabels << "ID" << "Name" << "Sex";
    tableWidget.setHorizontalHeaderLabels(headerLabels);

    tableWidget.setItem(0, 0, new QTableWidgetItem(QString("0001")));
    tableWidget.setItem(1, 1, new QTableWidgetItem(QString("0002")));
    tableWidget.setItem(2, 2, new QTableWidgetItem(QString("0003")));
    tableWidget.setItem(3, 3, new QTableWidgetItem(QString("0004")));

    tableWidget.show();

    return app.exec();
}
