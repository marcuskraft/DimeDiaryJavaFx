package com.dimediary.view.main;

import com.dimediary.view.design.UiMainWindow;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QTableWidgetItem;

public class Main {

	public static void main(String[] args) {
		
		
		QApplication application = new QApplication(args);
		
		UiMainWindow uiWindow = new UiMainWindow();
		
		QTableWidgetItem item = new QTableWidgetItem("test");
		
		//uiWindow.QTableFinanceOverview.row(item);
		
		QMainWindow window = new QMainWindow();
		
		uiWindow.setupUi(window);

		uiWindow.QTableFinanceOverview.setRowCount(5);
		
		uiWindow.QTableFinanceOverview.setItem(1, 1, item);
		
		window.show();
		
		QApplication.setActiveWindow(window);
		
		
		application.exec();
		
	}

}
