#include "mywidget.h"
#include <QDebug>

MyWidget::MyWidget(QWidget *parent)
    : QWidget(parent)
{
    lineEdit = new MyLineEdit(this);
    lineEdit->move(100, 100);
}

MyWidget::~MyWidget()
{

}

void MyWidget::keyPressEvent(QKeyEvent *event)
{
    qDebug() << "Key Event in MyWidget.";
}
