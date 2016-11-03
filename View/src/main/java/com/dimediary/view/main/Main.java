package com.dimediary.view.main;

import com.dimediary.view.design.MainWindow;
import com.dimediary.view.design.ui.UiMainWindow;
import com.trolltech.qt.gui.QApplication;

public class Main {

	private static MainWindow mainWindow;
	private static QApplication application;

	public static void main(final String[] args) {

		Main.application = new QApplication(args);
		Main.mainWindow = new MainWindow();

		Main.mainWindow.initialize();

		Main.application.exec();

	}

	public static UiMainWindow getMainWindow() {
		return Main.mainWindow;
	}

	public static QApplication getApplication() {
		return Main.application;
	}

}
