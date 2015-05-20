#ifndef CLIENT_H
#define CLIENT_H

#include "ui_client.h"
#include <QAbstractSocket>

class QTcpSocket;

class Client : public QDialog, private Ui::Client
{
    Q_OBJECT

public:
    explicit Client(QWidget *parent = 0);

private slots:
    void on_pushButton_clicked();
    void displayError(QAbstractSocket::SocketError);
    void readMessage();

private:
    QTcpSocket *tcpSocket;
};

#endif // CLIENT_H
