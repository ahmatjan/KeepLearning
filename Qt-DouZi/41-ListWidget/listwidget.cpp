#include "listwidget.h"
#include <QtGui>

ListWidget::ListWidget(QWidget *parent)
    : QWidget(parent)
{
    label = new QLabel(this);
    label->setFixedWidth(70);

    listWidget = new QListWidget(this);
    listWidget->addItem(new QListWidgetItem(QIcon(":/Images/iCal"), tr("iCal")));
    listWidget->addItem(new QListWidgetItem(QIcon(":/Images/iChat"), tr("iChat")));
    listWidget->addItem(new QListWidgetItem(QIcon(":/Images/iDVD"), tr("iDVD")));
    listWidget->addItem(new QListWidgetItem(QIcon(":/Images/iMovie"), tr("iMovie")));
    listWidget->addItem(new QListWidgetItem(QIcon(":/Images/iPhoto"), tr("iPhoto")));
    listWidget->addItem(new QListWidgetItem(QIcon(":/Images/iTunes"), tr("iTunes")));

    QHBoxLayout *layout;
    layout = new QHBoxLayout;
    layout->addWidget(label);
    layout->addWidget(listWidget);

    setLayout(layout);
    listWidget->setViewMode(QListView::IconMode);

    connect(listWidget, SIGNAL(currentTextChanged(const QString &)),
            label, SLOT(setText(const QString &)));
}

ListWidget::~ListWidget()
{

}
