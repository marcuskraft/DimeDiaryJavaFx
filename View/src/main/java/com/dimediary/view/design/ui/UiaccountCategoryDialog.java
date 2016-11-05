/********************************************************************************
 ** Form generated from reading ui file 'accountcategorydialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.core.Qt.Orientation;
import com.trolltech.qt.gui.QFormLayout.FieldGrowthPolicy;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiaccountCategoryDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QWidget formLayoutWidget;
    public QFormLayout formLayout;
    public QLabel label;
    public QLineEdit lineEdit;
    public QCheckBox checkBox;
    public QListWidget listCategories;
    public QPushButton pushButton;

    public UiaccountCategoryDialog() { super(); }

    public void setupUi(QDialog accountCategoryDialog)
    {
        accountCategoryDialog.setObjectName("accountCategoryDialog");
        accountCategoryDialog.resize(new QSize(337, 228).expandedTo(accountCategoryDialog.minimumSizeHint()));
        buttonBox = new QDialogButtonBox(accountCategoryDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(130, 190, 191, 32));
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));
        formLayoutWidget = new QWidget(accountCategoryDialog);
        formLayoutWidget.setObjectName("formLayoutWidget");
        formLayoutWidget.setGeometry(new QRect(20, 10, 160, 22));
        formLayout = new QFormLayout(formLayoutWidget);
        formLayout.setObjectName("formLayout");
        formLayout.setFieldGrowthPolicy(FieldGrowthPolicy.AllNonFixedFieldsGrow);
        label = new QLabel(formLayoutWidget);
        label.setObjectName("label");

        formLayout.addWidget(label);

        lineEdit = new QLineEdit(formLayoutWidget);
        lineEdit.setObjectName("lineEdit");

        formLayout.addWidget(lineEdit);

        checkBox = new QCheckBox(accountCategoryDialog);
        checkBox.setObjectName("checkBox");
        checkBox.setGeometry(new QRect(20, 40, 121, 17));
        listCategories = new QListWidget(accountCategoryDialog);
        listCategories.setObjectName("listCategories");
        listCategories.setGeometry(new QRect(200, 10, 121, 171));
        pushButton = new QPushButton(accountCategoryDialog);
        pushButton.setObjectName("pushButton");
        pushButton.setGeometry(new QRect(20, 70, 75, 23));
        retranslateUi(accountCategoryDialog);
        buttonBox.accepted.connect(accountCategoryDialog, "accept()");
        buttonBox.rejected.connect(accountCategoryDialog, "reject()");

        accountCategoryDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog accountCategoryDialog)
    {
        accountCategoryDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Kontoart erstellen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Name", null));
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Reales Konto", null));
        pushButton.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Hinzuf\u00fcgen", null));
    } // retranslateUi

}

