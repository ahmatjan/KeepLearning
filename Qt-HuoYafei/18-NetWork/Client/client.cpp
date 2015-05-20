#include "client.h"
#include <QtNetwork>
#include <QDebug>

Client::Client(QWidget *parent) :
    QDialog(parent)
{
    setupUi(this);

    tcpSocket = new QTcpSocket(this);
    connect(tcpSocket, SIGNAL(error(QAbstractSocket::SocketError)),
            this, SLOT(displayError(QAbstractSocket::SocketError)));
    connect(tcpSocket, SIGNAL(readyRead()),
            this, SLOT(readMessage()));
}

void Client::on_pushButton_clicked()
{
    tcpSocket->abort();
    tcpSocket->connectToHost(le_hostAddress->text(), le_port->text().toInt());
}

void Client::displayError(QAbstractSocket::SocketError)
{
    qDebug() << tcpSocket->errorString();
}

void Client::readMessage()
{
    qint16 blockSize = 0;
    QByteArray message;


    qDebug() << blockSize;
    QDataStream in(tcpSocket);
    if (blockSize == 0)
    {
        if (tcpSocket->bytesAvailable() < (int)sizeof(qint16))
            return;

        in >> blockSize;
    }
    if (tcpSocket->bytesAvailable() < blockSize)
        return;
    in >> message;

    qDebug() << endl;
    qDebug() << blockSize;
    qDebug() << message;
    label_3->setText(message);
}










