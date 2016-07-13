package com.dimediary.view.main;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

public class Main {

	public static void main(String[] args) {
		
		QApplication application = new QApplication(args);
		
		QWidget window = new QWidget();
		
		QPushButton button = new QPushButton("Ende");
		
		
		button.clicked.connect(application, "exit()");
		
		window.setWindowTitle("Hallo QT");
		QVBoxLayout layout = new QVBoxLayout();
		layout.addWidget(button);
		window.setLayout(layout);
		window.show();
		
		application.exec();
		
	}

}
