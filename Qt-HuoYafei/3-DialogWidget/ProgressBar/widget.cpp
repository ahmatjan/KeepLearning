#include "widget.h"
#include "ui_widget.h"

Widget::Widget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Widget)
{
    ui->setupUi(this);
}

Widget::~Widget()
{
    delete ui;
}

void Widget::on_pushButton_clicked()
{
    ui->progressBar->reset();
    ui->progressBar->setMinimum(0);
    ui->progressBar->setMaximum(50000);
    for (int i = 0; i <= 50000; i++)
    {
        ui->progressBar->setValue(i);
        QCoreApplication::processEvents();
        //if (ui->progressBar->)
    }
}
