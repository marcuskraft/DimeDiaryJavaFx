package com.dimediary.view.main;

import com.dimediary.view.design.UiMainWindow;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;

public class Main {

	public static void main(String[] args) {
		
		QApplication application = new QApplication(args);
		
		UiMainWindow uiWindow = new UiMainWindow();
		
		QMainWindow window = new QMainWindow();
		
		uiWindow.setupUi(window);

		window.show();
		
		QApplication.setActiveWindow(window);
		
		
		application.exec();
		
	}

}
