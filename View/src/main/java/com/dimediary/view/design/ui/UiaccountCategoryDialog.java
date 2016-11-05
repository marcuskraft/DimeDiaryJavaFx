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
import com.trolltech.qt.gui.QAbstractItemView.SelectionMode;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiaccountCategoryDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QCheckBox checkBoxRealAccount;
    public QListWidget listCategories;
    public QPushButton pushButtonAdd;
    public QPushButton pushButtonDelete;
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QLabel label;
    public QLineEdit lineEditName;

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
        checkBoxRealAccount = new QCheckBox(accountCategoryDialog);
        checkBoxRealAccount.setObjectName("checkBoxRealAccount");
        checkBoxRealAccount.setGeometry(new QRect(10, 50, 121, 17));
        listCategories = new QListWidget(accountCategoryDialog);
        listCategories.setObjectName("listCategories");
        listCategories.setGeometry(new QRect(210, 10, 121, 131));
        listCategories.setSelectionMode(SelectionMode.ExtendedSelection);
        pushButtonAdd = new QPushButton(accountCategoryDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");
        pushButtonAdd.setGeometry(new QRect(90, 70, 75, 23));
        pushButtonDelete = new QPushButton(accountCategoryDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");
        pushButtonDelete.setGeometry(new QRect(210, 140, 75, 23));
        gridLayoutWidget = new QWidget(accountCategoryDialog);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(10, 10, 151, 41));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(gridLayoutWidget);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        lineEditName = new QLineEdit(gridLayoutWidget);
        lineEditName.setObjectName("lineEditName");

        gridLayout.addWidget(lineEditName, 0, 1, 1, 1);

        retranslateUi(accountCategoryDialog);
        buttonBox.accepted.connect(accountCategoryDialog, "accept()");
        buttonBox.rejected.connect(accountCategoryDialog, "reject()");

        accountCategoryDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog accountCategoryDialog)
    {
        accountCategoryDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Kontoart erstellen", null));
        checkBoxRealAccount.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Reales Konto", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Hinzuf\u00fcgen", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "L\u00f6schen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Name", null));
    } // retranslateUi

}

