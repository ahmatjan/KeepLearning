#include "server.h"
#include <QtNetwork>
#include <QDebug>

Server::Server(QWidget *parent) :
    QDialog(parent)
{
    setupUi(this);

    tcpServer = new QTcpServer(this);
    if (!tcpServer->listen(QHostAddress::LocalHost, 6666))
    {
        qDebug() << tcpServer->errorString();
        tcpServer->close();
    }
    qDebug() << (new QHostInfo)->hostName();

    connect(tcpServer, SIGNAL(newConnection()), this, SLOT(sendMessage()));
}

void Server::sendMessage()
{
    QByteArray block;
    QDataStream out(&block, QIODevice::WriteOnly);
    out << (qint16)0;
    out << "Hello Tcp!";
    out.device()->seek(0);
    out << (qint16)(block.size() - sizeof(qint16));

    QTcpSocket *clientConnection = tcpServer->nextPendingConnection();
    connect(clientConnection, SIGNAL(disconnected()), clientConnection, SLOT(deleteLater()));
    clientConnection->write(block);
    clientConnection->close();

    label->setText("Send message successfully.");
}
