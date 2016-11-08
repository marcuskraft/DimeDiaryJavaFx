/********************************************************************************
 ** Form generated from reading ui file 'categorydialog.jui'
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

public class UiCategoryDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QLabel label;
    public QLineEdit lineEditName;
    public QPushButton pushButtonAdd;
    public QListWidget listCategories;
    public QPushButton pushButtonDelete;

    public UiCategoryDialog() { super(); }

    public void setupUi(QDialog CategoryDialog)
    {
        CategoryDialog.setObjectName("CategoryDialog");
        CategoryDialog.resize(new QSize(287, 244).expandedTo(CategoryDialog.minimumSizeHint()));
        buttonBox = new QDialogButtonBox(CategoryDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(-60, 210, 341, 32));
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));
        gridLayoutWidget = new QWidget(CategoryDialog);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(10, 20, 151, 41));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(gridLayoutWidget);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        lineEditName = new QLineEdit(gridLayoutWidget);
        lineEditName.setObjectName("lineEditName");

        gridLayout.addWidget(lineEditName, 0, 1, 1, 1);

        pushButtonAdd = new QPushButton(CategoryDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");
        pushButtonAdd.setGeometry(new QRect(10, 70, 75, 23));
        listCategories = new QListWidget(CategoryDialog);
        listCategories.setObjectName("listCategories");
        listCategories.setGeometry(new QRect(170, 10, 111, 191));
        listCategories.setSelectionMode(SelectionMode.ExtendedSelection);
        pushButtonDelete = new QPushButton(CategoryDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");
        pushButtonDelete.setGeometry(new QRect(90, 160, 75, 23));
        retranslateUi(CategoryDialog);
        buttonBox.accepted.connect(CategoryDialog, "accept()");
        buttonBox.rejected.connect(CategoryDialog, "reject()");

        CategoryDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog CategoryDialog)
    {
        CategoryDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "Kategorie erstellen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "Name", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "Hinzuf\u00fcgen", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "L\u00f6schen", null));
    } // retranslateUi

}

