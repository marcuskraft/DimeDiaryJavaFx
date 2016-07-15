/********************************************************************************
 ** Form generated from reading ui file 'tb2.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiForm implements com.trolltech.qt.QUiForm<QWidget>
{
    public QToolBox toolBox;
    public QWidget page;
    public QWidget page_2;
    public QLineEdit lineEdit;
    public QCheckBox checkBox;

    public UiForm() { super(); }

    public void setupUi(QWidget Form)
    {
        Form.setObjectName("Form");
        Form.resize(new QSize(400, 300).expandedTo(Form.minimumSizeHint()));
        toolBox = new QToolBox(Form);
        toolBox.setObjectName("toolBox");
        toolBox.setGeometry(new QRect(30, 90, 69, 123));
        page = new QWidget();
        page.setObjectName("page");
        page.setGeometry(new QRect(0, 0, 69, 69));
        toolBox.addItem(page, com.trolltech.qt.core.QCoreApplication.translate("Form", "Page 1", null));
        page_2 = new QWidget();
        page_2.setObjectName("page_2");
        page_2.setGeometry(new QRect(0, 0, 98, 28));
        toolBox.addItem(page_2, com.trolltech.qt.core.QCoreApplication.translate("Form", "Page 2", null));
        lineEdit = new QLineEdit(Form);
        lineEdit.setObjectName("lineEdit");
        lineEdit.setGeometry(new QRect(240, 120, 113, 20));
        checkBox = new QCheckBox(Form);
        checkBox.setObjectName("checkBox");
        checkBox.setGeometry(new QRect(130, 210, 70, 17));
        retranslateUi(Form);

        toolBox.setCurrentIndex(0);


        Form.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Form)
    {
        Form.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "Form", null));
        toolBox.setItemText(toolBox.indexOf(page), com.trolltech.qt.core.QCoreApplication.translate("Form", "Page 1", null));
        toolBox.setItemText(toolBox.indexOf(page_2), com.trolltech.qt.core.QCoreApplication.translate("Form", "Page 2", null));
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "CheckBox", null));
    } // retranslateUi

}

