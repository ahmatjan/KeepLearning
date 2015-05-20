#include <QApplication>
#include <QStandardItemModel>
#include <QTreeView>
#include <QDebug>


int main(int argc, char *argv[])
{
    QApplication a(argc, argv);

    //Model部分
    QStandardItemModel model;

    //根项
    QStandardItem *parentItem;
    parentItem = model.invisibleRootItem();

    //标准项item0
    QStandardItem *item0 = new QStandardItem;
    item0->setText("A");
    QPixmap pixmap0(50, 50);
    pixmap0.fill("red");
    item0->setIcon(QIcon(pixmap0));
    item0->setToolTip("Index A");
    parentItem->appendRow(item0);

    //标准项item1
    QStandardItem *item1 = new QStandardItem;
    QPixmap pixmap1(50, 50);
    item1->setText("B");
    pixmap1.fill("blue");
    item1->setIcon(QIcon(pixmap1));
    item1->setToolTip("Index B");
    item0->appendRow(item1);

    //标准项item2
    QStandardItem *item2 = new QStandardItem;
    QPixmap pixmap2(50, 50);
    pixmap2.fill("green");
    item2->setText("C");
    item2->setIcon(QIcon(pixmap2));
    item2->setToolTip("Index C");
    item0->appendRow(item2);

    //标准项item3
    QStandardItem *item3 = new QStandardItem;
    QPixmap pixmap3(50, 50);
    pixmap3.fill("pink");
    item3->setData("C", Qt::EditRole);
    item3->setData("Index D", Qt::ToolTipRole);
    item3->setData(QIcon(pixmap3), Qt::DecorationRole);
    item0->appendRow(item3);

    //视图部分
    QTreeView tree;
    tree.setModel(&model);
    tree.show();

    //ModelIndex
    QModelIndex index0 = model.index(0, 0, QModelIndex());
    qDebug() << "index0 row count:" << model.rowCount(index0);

    QModelIndex index1 = model.index(0, 0, index0);
    qDebug() << "index1 EditRole:" << model.data(index1, Qt::EditRole).toString();
    qDebug() << "index1 ToolTipRole:" << model.data(index1, Qt::ToolTipRole).toString();

    return a.exec();
}
