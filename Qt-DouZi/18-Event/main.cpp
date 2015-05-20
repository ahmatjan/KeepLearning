#include <QApplication>
#include "eventlabel.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    EventLabel *eventLabel = new EventLabel;
    eventLabel->resize(300, 200);
    eventLabel->setMouseTracking(true);
    eventLabel->show();

    return app.exec();
}
