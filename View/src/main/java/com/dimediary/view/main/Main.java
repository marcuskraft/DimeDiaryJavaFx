package com.dimediary.view.main;

import com.dimediary.view.design.UiMainWindow;
import com.dimediary.view.initializer.Initializer;
import com.trolltech.qt.gui.QApplication;

public class Main {

	public static void main(final String[] args) {

		final QApplication application = new QApplication(args);

		final UiMainWindow uiWindow = new UiMainWindow();

		Initializer.initMainWindow(uiWindow, application);

		application.exec();

	}

}
