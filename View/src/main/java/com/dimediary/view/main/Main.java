package com.dimediary.view.main;

import com.dimediary.view.design.UiMainWindow;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QTableWidgetItem;

public class Main {

	public static void main(String[] args) {
		
		
		QApplication application = new QApplication(args);
		
		UiMainWindow uiWindow = new UiMainWindow();
		
		QTableWidgetItem item = new QTableWidgetItem("test");
		QPushButton button = new QPushButton("testButton");
		QPushButton button2 = new QPushButton("testButton2");
		
		//uiWindow.QTableFinanceOverview.row(item);
		
		QMainWindow window = new QMainWindow();
		
		uiWindow.setupUi(window);

		uiWindow.tableWidget.setRowCount(5);
		
		
		uiWindow.tableWidget.setColumnCount(5);
		
		
		
		uiWindow.tableWidget.setItem(1, 1, item);
		uiWindow.tableWidget.setIndexWidget(uiWindow.tableWidget.model().index(2, 3), button);
		uiWindow.tableWidget.setIndexWidget(uiWindow.tableWidget.model().index(2, 4), button2);
		
		
		QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "", null));
        uiWindow.tableWidget.setHorizontalHeaderItem(4, __colItem3);
		
		uiWindow.actionBeenden.triggered.connect(application, "exit()");
		
		window.show();
		
		QApplication.setActiveWindow(window);
		
		
		application.exec();
		
	}

}
