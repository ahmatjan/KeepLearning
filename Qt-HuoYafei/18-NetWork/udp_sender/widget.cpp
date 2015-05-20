#include "widget.h"
#include "ui_widget.h"
#include <QUdpSocket>

Widget::Widget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Widget)
{
    ui->setupUi(this);

    sender = new QUdpSocket(this);
}

Widget::~Widget()
{
    delete ui;
}

void Widget::on_pushButton_clicked()
{
    QByteArray datagram = "Hello World!";

    sender->writeDatagram(datagram.data(), datagram.size(),
                          QHostAddress::Broadcast, 45454);
}
