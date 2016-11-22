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
    public QGridLayout gridLayout_2;
    public QListWidget listCategories;
    public QDialogButtonBox buttonBox;
    public QPushButton pushButtonAdd;
    public QPushButton pushButtonDelete;
    public QGridLayout gridLayout;
    public QLabel label;
    public QLineEdit lineEditName;
    public QSpacerItem verticalSpacer;
    public QSpacerItem horizontalSpacer;
    public QSpacerItem horizontalSpacer_2;

    public UiCategoryDialog() { super(); }

    public void setupUi(QDialog CategoryDialog)
    {
        CategoryDialog.setObjectName("CategoryDialog");
        CategoryDialog.resize(new QSize(292, 207).expandedTo(CategoryDialog.minimumSizeHint()));
        CategoryDialog.setModal(true);
        gridLayout_2 = new QGridLayout(CategoryDialog);
        gridLayout_2.setObjectName("gridLayout_2");
        listCategories = new QListWidget(CategoryDialog);
        listCategories.setObjectName("listCategories");
        listCategories.setSelectionMode(SelectionMode.ExtendedSelection);

        gridLayout_2.addWidget(listCategories, 0, 2, 4, 1);

        buttonBox = new QDialogButtonBox(CategoryDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));

        gridLayout_2.addWidget(buttonBox, 4, 0, 1, 3);

        pushButtonAdd = new QPushButton(CategoryDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");

        gridLayout_2.addWidget(pushButtonAdd, 1, 0, 1, 1);

        pushButtonDelete = new QPushButton(CategoryDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_2.addWidget(pushButtonDelete, 3, 1, 1, 1);

        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(CategoryDialog);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        lineEditName = new QLineEdit(CategoryDialog);
        lineEditName.setObjectName("lineEditName");

        gridLayout.addWidget(lineEditName, 0, 1, 1, 1);


        gridLayout_2.addLayout(gridLayout, 0, 0, 1, 2);

        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_2.addItem(verticalSpacer, 2, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer, 3, 0, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer_2, 1, 1, 1, 1);

        retranslateUi(CategoryDialog);
        buttonBox.accepted.connect(CategoryDialog, "accept()");
        buttonBox.rejected.connect(CategoryDialog, "reject()");

        CategoryDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog CategoryDialog)
    {
        CategoryDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "Kategorie erstellen", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "Hinzuf\u00fcgen", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "L\u00f6schen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("CategoryDialog", "Name", null));
    } // retranslateUi

}

