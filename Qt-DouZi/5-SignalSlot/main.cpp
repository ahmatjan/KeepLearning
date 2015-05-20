#include <QCoreApplication>
#include "newspaper.h"
#include "reader.h"

int main(int argc, char *argv[])
{
    QCoreApplication app(argc, argv);

    Newspaper *newspaper = new Newspaper("Newspaper A.");
    Reader *reader = new Reader;

    QObject::connect(newspaper, SIGNAL(newPaper(const QString&)),
                     reader, SLOT(receiveNewspaper(const QString&)));

    newspaper->send();

    return app.exec();
}
