#ifndef MYWIDGET_H
#define MYWIDGET_H

#include <QtGui/QWidget>
#include "mylineedit.h"

class MyWidget : public QWidget
{
    Q_OBJECT

public:
    MyWidget(QWidget *parent = 0);
    ~MyWidget();

private:
    MyLineEdit *lineEdit;

    void keyPressEvent(QKeyEvent *event);
};

#endif // MYWIDGET_H
