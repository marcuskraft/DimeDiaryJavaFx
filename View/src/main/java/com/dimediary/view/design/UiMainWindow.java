/********************************************************************************
 ** Form generated from reading ui file 'mainwindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design;

import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.QSize;
import com.trolltech.qt.core.Qt.LayoutDirection;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;
import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QDialogButtonBox;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QMenu;
import com.trolltech.qt.gui.QMenuBar;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QStatusBar;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class UiMainWindow implements com.trolltech.qt.QUiForm<QMainWindow> {
	public QAction actionBeenden;
	public QWidget centralwidget;
	public QTableWidget QTableFinanceOverview;
	public QPushButton pushButton;
	public QDialogButtonBox buttonBox;
	public QMenuBar menubar;
	public QMenu menuDatei;
	public QStatusBar statusbar;

	public UiMainWindow() {
		super();
	}

	@Override
	public void setupUi(final QMainWindow MainWindow) {
		MainWindow.setObjectName("MainWindow");
		MainWindow.resize(new QSize(1096, 870).expandedTo(MainWindow.minimumSizeHint()));
		this.actionBeenden = new QAction(MainWindow);
		this.actionBeenden.setObjectName("actionBeenden");
		this.centralwidget = new QWidget(MainWindow);
		this.centralwidget.setObjectName("centralwidget");
		this.QTableFinanceOverview = new QTableWidget(this.centralwidget);
		this.QTableFinanceOverview.setObjectName("QTableFinanceOverview");
		this.QTableFinanceOverview.setGeometry(new QRect(0, 0, 911, 811));
		this.QTableFinanceOverview.setAcceptDrops(false);
		this.QTableFinanceOverview.setLayoutDirection(LayoutDirection.LeftToRight);
		this.QTableFinanceOverview.setAlternatingRowColors(true);
		this.QTableFinanceOverview.setSelectionBehavior(SelectionBehavior.SelectItems);
		this.QTableFinanceOverview.setSortingEnabled(true);
		this.pushButton = new QPushButton(this.centralwidget);
		this.pushButton.setObjectName("pushButton");
		this.pushButton.setGeometry(new QRect(600, 120, 93, 28));
		this.buttonBox = new QDialogButtonBox(this.centralwidget);
		this.buttonBox.setObjectName("buttonBox");
		this.buttonBox.setGeometry(new QRect(370, 360, 193, 28));
		this.buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel, StandardButton.Ok));
		MainWindow.setCentralWidget(this.centralwidget);
		this.menubar = new QMenuBar(MainWindow);
		this.menubar.setObjectName("menubar");
		this.menubar.setGeometry(new QRect(0, 0, 1096, 26));
		this.menuDatei = new QMenu(this.menubar);
		this.menuDatei.setObjectName("menuDatei");
		MainWindow.setMenuBar(this.menubar);
		this.statusbar = new QStatusBar(MainWindow);
		this.statusbar.setObjectName("statusbar");
		MainWindow.setStatusBar(this.statusbar);

		this.menubar.addAction(this.menuDatei.menuAction());
		this.menuDatei.addAction(this.actionBeenden);
		this.retranslateUi(MainWindow);

		MainWindow.connectSlotsByName();
	} // setupUi

	void retranslateUi(final QMainWindow MainWindow) {
		MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
		this.actionBeenden.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Beenden", null));
		this.QTableFinanceOverview.clear();
		this.QTableFinanceOverview.setColumnCount(4);

		final QTableWidgetItem __colItem = new QTableWidgetItem();
		__colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.QTableFinanceOverview.setHorizontalHeaderItem(0, __colItem);

		final QTableWidgetItem __colItem1 = new QTableWidgetItem();
		__colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.QTableFinanceOverview.setHorizontalHeaderItem(1, __colItem1);

		final QTableWidgetItem __colItem2 = new QTableWidgetItem();
		__colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.QTableFinanceOverview.setHorizontalHeaderItem(2, __colItem2);

		final QTableWidgetItem __colItem3 = new QTableWidgetItem();
		__colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
		this.QTableFinanceOverview.setHorizontalHeaderItem(3, __colItem3);
		this.QTableFinanceOverview.setRowCount(0);
		this.pushButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "PushButton", null));
		this.menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
	} // retranslateUi

}
