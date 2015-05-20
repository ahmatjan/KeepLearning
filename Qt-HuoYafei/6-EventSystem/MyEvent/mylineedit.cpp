#include "mylineedit.h"
#include <QDebug>
#include <QKeyEvent>

MyLineEdit::MyLineEdit(QWidget *parent) :
    QLineEdit(parent)
{
}

void MyLineEdit::keyPressEvent(QKeyEvent *event)
{
    qDebug() << "Key Event in MyLineEdit.";
    QLineEdit::keyPressEvent(event);
    event->ignore();
}
