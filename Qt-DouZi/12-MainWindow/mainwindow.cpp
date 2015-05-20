#include <QAction>
#include <QMenuBar>
#include <QMessageBox>
#include <QToolBar>
#include <QDebug>

#include "mainwindow.h"

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent)
{
    setWindowTitle(tr("Main Window"));

    openAction = new QAction(QIcon(":/images/doc-open"), tr("&Open..."), this);
    openAction->setShortcuts(QKeySequence::Open);
    openAction->setStatusTip(tr("Open an existing file"));
    connect(openAction, SIGNAL(triggered()), this, SLOT(open()));

    QMenu *file = menuBar()->addMenu(tr("&File"));
    file->addAction(openAction);

    QToolBar *toolBar = addToolBar(tr("&File"));
    toolBar->addAction(openAction);

    statusBar();
}

MainWindow::~MainWindow()
{
}

void MainWindow::open()
{
//  QMessageBox::information(this, tr("Infor"), tr("Open"));

    /*
    QDialog dialog;
    dialog.setWindowTitle(tr("Hello, Dialog"));
    dialog.exec();
    qDebug() << dialog.result();
    */

    /*
    QDialog *dialog = new QDialog;
    dialog->setAttribute(Qt::WA_DeleteOnClose);
    dialog->setWindowTitle(tr("Hello, Dialog2"));
    dialog->show();
    */

    /*
    if (QMessageBox::Yes == QMessageBox::question(this,
                                                  tr("Qustion"),
                                                  tr("Are you OK?"),
                                                  QMessageBox::Yes | QMessageBox::No,
                                                  QMessageBox::Yes))
    {
        QMessageBox::information(this, tr("Hmmm..."), tr("I'm glad to hear that!"));
    }
    else
    {
        QMessageBox::information(this, tr("Humm..."), tr("I'm sorry."));
    }
    */

    QMessageBox msgBox;
    msgBox.setText(tr("The document has been modified."));
    msgBox.setInformativeText(tr("Do you want to save your changes?"));
    msgBox.setDetailedText(tr("Defferences here.."));
    msgBox.setStandardButtons(QMessageBox::Save | QMessageBox::Discard | QMessageBox::Close);
    msgBox.setDefaultButton(QMessageBox::Save);

    int ret = msgBox.exec();
    switch (ret)
    {
    case QMessageBox::Save:
        qDebug() << "Sava document.";
        break;
    case QMessageBox::Discard:
        qDebug() << "Discard changes.";
        break;
    case QMessageBox::Close:
        qDebug() << "Close the pro.";
        break;
    }
}






























