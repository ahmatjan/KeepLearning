#ifndef SERVER_H
#define SERVER_H

#include "ui_server.h"

class QTcpServer;

class Server : public QDialog, private Ui::Server
{
    Q_OBJECT

public:
    explicit Server(QWidget *parent = 0);

private slots:
    void sendMessage();

private:
    QTcpServer *tcpServer;
};

#endif // SERVER_H
