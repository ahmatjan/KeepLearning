#include <QtGui/QApplication>
#include "listwidget.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    ListWidget w;
    w.show();

    return a.exec();
}
