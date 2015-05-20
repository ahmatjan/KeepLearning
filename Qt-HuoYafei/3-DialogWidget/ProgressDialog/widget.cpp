#include "widget.h"
#include "ui_widget.h"
#include <QProgressDialog>

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
    QProgressDialog dialog(tr("文件复制进度"), tr("取消"), 0, 50000, this);
    dialog.setWindowTitle(tr("进度对话框"));
    dialog.setWindowModality(Qt::WindowModal);
    dialog.show();
    for (int i = 0; i <= 50000; i++)
    {
        dialog.setValue(i);
        QCoreApplication::processEvents();
        if (dialog.wasCanceled())
            break;
    }
}
