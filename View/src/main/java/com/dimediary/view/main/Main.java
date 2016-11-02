package com.dimediary.view.main;

import com.dimediary.view.design.UiMainWindow;
import com.dimediary.view.initializer.Initializer;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;

public class Main {

	public static void main(final String[] args) {

		final QApplication application = new QApplication(args);

		final UiMainWindow uiWindow = new UiMainWindow();

		final QMainWindow window = new QMainWindow();

		uiWindow.setupUi(window);

		Initializer.initMainWindow(uiWindow);

		uiWindow.actionBeenden.triggered.connect(application, "exit()");

		window.show();

		QApplication.setActiveWindow(window);

		application.exec();

	}

}
