#include "mainwindow.h"
#include <QtGui>
#include <QDebug>

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent)
{
    setWindowTitle(tr("Main Window"));

    openAction = new QAction(QIcon(":/Images/file-open"), tr("&Open..."), this);
    openAction->setShortcuts(QKeySequence::Open);
    openAction->setStatusTip(tr("Open an existing file"));

    saveAction = new QAction(QIcon(":/Images/file-save"), tr("&Save..."), this);
    saveAction->setShortcuts(QKeySequence::Save);
    saveAction->setStatusTip(tr("Save a new file"));


    QMenu *file = menuBar()->addMenu(tr("&File"));
    file->addAction(openAction);
    file->addAction(saveAction);

    QToolBar *toolBar = addToolBar(tr("&File"));
    toolBar->addAction(openAction);
    toolBar->addAction(saveAction);

    textEdit = new QTextEdit(this);
    setCentralWidget(textEdit);


    connect(openAction, SIGNAL(triggered()), this, SLOT(openFile()));
    connect(saveAction, SIGNAL(triggered()), this, SLOT(saveFile()));
    statusBar();
}

MainWindow::~MainWindow()
{
}

void MainWindow::openFile()
{
    QString path = QFileDialog::getOpenFileName
            (this, tr("Open file"), ".", tr("Text Files(*.txt)"));

    if (!path.isEmpty()) //检查路径名
    {
        QFile file(path);
        if (file.open(QIODevice::ReadWrite | QIODevice::Text)) //打开文件
        {
            QTextStream in(&file);
            textEdit->setText(in.readAll());
            file.close();
        }
        else
        {
            qDebug() << "open error.";
        }
    }
    else
    {
        qDebug() << "path is empty.";
    }
}

void MainWindow::saveFile()
{
    QString path = QFileDialog::getSaveFileName
            (this, tr("Save file"), ".", tr("Text Files(*.txt)"));

    if (!path.isEmpty())
    {
        QFile file(path);
        if (file.open(QIODevice::WriteOnly | QIODevice::Text))
        {
            QTextStream out(&file);
            out << textEdit->toPlainText();
            file.close();
        }
        else
        {
            qDebug() << "File open error.";
        }
    }
    else
    {
        qDebug() << "The path is empty.";
    }


}


























