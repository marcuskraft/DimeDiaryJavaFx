/********************************************************************************
 ** Form generated from reading ui file 'mainwindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design;

import com.trolltech.qt.core.*;
import com.trolltech.qt.core.Qt.LayoutDirection;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

public class UiMainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionBeenden;
    public QWidget centralwidget;
    public QTableWidget QTableFinanceOverview;
    public QPushButton pushButton;
    public QDialogButtonBox buttonBox;
    public QMenuBar menubar;
    public QMenu menuDatei;
    public QStatusBar statusbar;

    public UiMainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(1096, 870).expandedTo(MainWindow.minimumSizeHint()));
        actionBeenden = new QAction(MainWindow);
        actionBeenden.setObjectName("actionBeenden");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        QTableFinanceOverview = new QTableWidget(centralwidget);
        QTableFinanceOverview.setObjectName("QTableFinanceOverview");
        QTableFinanceOverview.setGeometry(new QRect(0, 0, 911, 811));
        QTableFinanceOverview.setAcceptDrops(false);
        QTableFinanceOverview.setLayoutDirection(LayoutDirection.LeftToRight);
        QTableFinanceOverview.setAlternatingRowColors(true);
        QTableFinanceOverview.setSelectionBehavior(SelectionBehavior.SelectItems);
        QTableFinanceOverview.setSortingEnabled(true);
        pushButton = new QPushButton(centralwidget);
        pushButton.setObjectName("pushButton");
        pushButton.setGeometry(new QRect(600, 120, 93, 28));
        buttonBox = new QDialogButtonBox(centralwidget);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(370, 360, 193, 28));
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 1096, 26));
        menuDatei = new QMenu(menubar);
        menuDatei.setObjectName("menuDatei");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menuDatei.menuAction());
        menuDatei.addAction(actionBeenden);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        actionBeenden.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Beenden", null));
        QTableFinanceOverview.clear();
        QTableFinanceOverview.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        QTableFinanceOverview.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        QTableFinanceOverview.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        QTableFinanceOverview.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
        QTableFinanceOverview.setHorizontalHeaderItem(3, __colItem3);
        QTableFinanceOverview.setRowCount(0);
        pushButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "PushButton", null));
        menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
    } // retranslateUi

}

