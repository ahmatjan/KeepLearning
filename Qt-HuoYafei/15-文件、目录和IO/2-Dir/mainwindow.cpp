#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QDir>
#include <QFile>
#include <QDebug>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    //关联信号和槽
    connect(&myWatcher, SIGNAL(directoryChanged(QString)),
            this, SLOT(showMessage(QString)));
    connect(&myWatcher, SIGNAL(fileChanged(QString)),
            this, SLOT(showMessage(QString)));

    //Display current path's .h file
    QDir myDir(QDir::currentPath());
    myDir.setNameFilters(QStringList("*.h"));
    ui->listWidget->addItem("The .h files under path" + QDir::currentPath());
    ui->listWidget->addItems(myDir.entryList());

    //创建目录，放到listWidget和myWatcher中
    myDir.mkdir("mydir");
    myDir.cd("mydir");
    ui->listWidget->addItem("The watched dir: " + myDir.absolutePath());
    myWatcher.addPath(myDir.absolutePath());

    //Create file, put it in listWidget and myWatcher.
    QFile file(myDir.absolutePath() + "/myfile.txt");
    if (!file.open(QIODevice::WriteOnly | QIODevice::Text))
    {
        qDebug() << "Failed to open.";
    }
    QFileInfo info(file);
    ui->listWidget->addItem("The watched file: " + info.absoluteFilePath());
    myWatcher.addPath(info.absoluteFilePath());
    file.close();
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::showMessage(const QString &path)
{
    QDir dir(QDir::currentPath() + "/mydir");
    if (path == dir.absolutePath())     //If the path is dir
    {
        ui->listWidget->addItem("The directory changed. " + dir.absolutePath());
        ui->listWidget->addItems(dir.entryList());
    }
    else        //If the path is file
    {
        ui->listWidget->addItem("The file changed. " + path);
    }
}



















