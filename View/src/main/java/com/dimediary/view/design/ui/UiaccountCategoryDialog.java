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
    public QGridLayout gridLayout_2;
    public QDialogButtonBox buttonBox;
    public QGridLayout gridLayout;
    public QLabel label;
    public QLineEdit lineEditName;
    public QSpacerItem horizontalSpacer_2;
    public QPushButton pushButtonDelete;
    public QSpacerItem verticalSpacer;
    public QCheckBox checkBoxRealAccount;
    public QSpacerItem horizontalSpacer;
    public QListWidget listCategories;
    public QPushButton pushButtonAdd;

    public UiaccountCategoryDialog() { super(); }

    public void setupUi(QDialog accountCategoryDialog)
    {
        accountCategoryDialog.setObjectName("accountCategoryDialog");
        accountCategoryDialog.resize(new QSize(325, 209).expandedTo(accountCategoryDialog.minimumSizeHint()));
        gridLayout_2 = new QGridLayout(accountCategoryDialog);
        gridLayout_2.setObjectName("gridLayout_2");
        buttonBox = new QDialogButtonBox(accountCategoryDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));

        gridLayout_2.addWidget(buttonBox, 7, 2, 1, 2);

        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(accountCategoryDialog);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        lineEditName = new QLineEdit(accountCategoryDialog);
        lineEditName.setObjectName("lineEditName");

        gridLayout.addWidget(lineEditName, 0, 1, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_2, 0, 2, 1, 1);


        gridLayout_2.addLayout(gridLayout, 0, 0, 1, 3);

        pushButtonDelete = new QPushButton(accountCategoryDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_2.addWidget(pushButtonDelete, 5, 2, 1, 1);

        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_2.addItem(verticalSpacer, 3, 0, 1, 1);

        checkBoxRealAccount = new QCheckBox(accountCategoryDialog);
        checkBoxRealAccount.setObjectName("checkBoxRealAccount");

        gridLayout_2.addWidget(checkBoxRealAccount, 1, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer, 5, 1, 1, 1);

        listCategories = new QListWidget(accountCategoryDialog);
        listCategories.setObjectName("listCategories");
        listCategories.setSelectionMode(SelectionMode.ExtendedSelection);

        gridLayout_2.addWidget(listCategories, 0, 3, 7, 1);

        pushButtonAdd = new QPushButton(accountCategoryDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");

        gridLayout_2.addWidget(pushButtonAdd, 2, 0, 1, 1);

        retranslateUi(accountCategoryDialog);
        buttonBox.accepted.connect(accountCategoryDialog, "accept()");
        buttonBox.rejected.connect(accountCategoryDialog, "reject()");

        accountCategoryDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog accountCategoryDialog)
    {
        accountCategoryDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Kontoart erstellen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Name", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "L\u00f6schen", null));
        checkBoxRealAccount.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Reales Konto", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("accountCategoryDialog", "Hinzuf\u00fcgen", null));
    } // retranslateUi

}

