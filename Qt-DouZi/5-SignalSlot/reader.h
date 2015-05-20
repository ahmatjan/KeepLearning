#include <QObject>
#include <QDebug>

class Reader : public QObject
{
    Q_OBJECT
public:
        Reader()
        {
        }

private slots:
        void receiveNewspaper(const QString &name)
        {
                qDebug() << "Receive" << name;
        }
};
