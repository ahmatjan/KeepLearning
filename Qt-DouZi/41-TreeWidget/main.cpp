#include <QApplication>
#include <QtGui>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QTreeWidget treeWidget;
//    treeWidget.setColumnCount(1);
    QStringList headers;
    headers << "Name" << "Number";
    treeWidget.setHeaderLabels(headers);

    QTreeWidgetItem *root = new QTreeWidgetItem(&treeWidget, QStringList(QString("Root")));
    QList<QString> itemList;
    itemList << "Leaf1" << "Leaf1-2";
    QTreeWidgetItem *leaf1 = new QTreeWidgetItem(root, itemList);
    QTreeWidgetItem *leaf2 = new QTreeWidgetItem(root, QStringList(QString("Leaf2")));
    leaf2->setCheckState(0, Qt::Checked);

    QList<QTreeWidgetItem *> rootList;
    rootList << root;
    treeWidget.insertTopLevelItems(0, rootList);

    treeWidget.show();

    return app.exec();
}
