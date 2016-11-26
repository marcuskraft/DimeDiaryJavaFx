/********************************************************************************
 ** Form generated from reading ui file 'deletecontinuoustransactionwidget.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.core.Qt.Orientation;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiDeleteContinuousTransactionWidget implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout_3;
    public QLabel label;
    public QWidget widget;
    public QGridLayout gridLayout_2;
    public QGridLayout gridLayout;
    public QDateEdit dateEdit;
    public QRadioButton radioButtonFrom;
    public QRadioButton radioButtonAll;
    public QSpacerItem verticalSpacer;
    public QSpacerItem horizontalSpacer;
    public QDialogButtonBox buttonBox;

    public UiDeleteContinuousTransactionWidget() { super(); }

    public void setupUi(QDialog DeleteContinuousTransactionWidget)
    {
        DeleteContinuousTransactionWidget.setObjectName("DeleteContinuousTransactionWidget");
        DeleteContinuousTransactionWidget.resize(new QSize(240, 135).expandedTo(DeleteContinuousTransactionWidget.minimumSizeHint()));
        DeleteContinuousTransactionWidget.setModal(true);
        gridLayout_3 = new QGridLayout(DeleteContinuousTransactionWidget);
        gridLayout_3.setObjectName("gridLayout_3");
        label = new QLabel(DeleteContinuousTransactionWidget);
        label.setObjectName("label");

        gridLayout_3.addWidget(label, 0, 0, 1, 1);

        widget = new QWidget(DeleteContinuousTransactionWidget);
        widget.setObjectName("widget");
        gridLayout_2 = new QGridLayout(widget);
        gridLayout_2.setObjectName("gridLayout_2");
        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        dateEdit = new QDateEdit(widget);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setCalendarPopup(true);

        gridLayout.addWidget(dateEdit, 1, 1, 1, 1);

        radioButtonFrom = new QRadioButton(widget);
        radioButtonFrom.setObjectName("radioButtonFrom");

        gridLayout.addWidget(radioButtonFrom, 1, 0, 1, 1);

        radioButtonAll = new QRadioButton(widget);
        radioButtonAll.setObjectName("radioButtonAll");

        gridLayout.addWidget(radioButtonAll, 2, 0, 1, 1);


        gridLayout_2.addLayout(gridLayout, 0, 0, 1, 1);

        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_2.addItem(verticalSpacer, 1, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer, 0, 1, 1, 1);


        gridLayout_3.addWidget(widget, 1, 0, 1, 1);

        buttonBox = new QDialogButtonBox(DeleteContinuousTransactionWidget);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));

        gridLayout_3.addWidget(buttonBox, 2, 0, 1, 1);

        retranslateUi(DeleteContinuousTransactionWidget);
        buttonBox.accepted.connect(DeleteContinuousTransactionWidget, "accept()");
        buttonBox.rejected.connect(DeleteContinuousTransactionWidget, "reject()");

        DeleteContinuousTransactionWidget.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog DeleteContinuousTransactionWidget)
    {
        DeleteContinuousTransactionWidget.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("DeleteContinuousTransactionWidget", "Ab wann?", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("DeleteContinuousTransactionWidget", "Welche Transaktionen sollen gel\u00f6scht werden?", null));
        radioButtonFrom.setText(com.trolltech.qt.core.QCoreApplication.translate("DeleteContinuousTransactionWidget", "ab", null));
        radioButtonAll.setText(com.trolltech.qt.core.QCoreApplication.translate("DeleteContinuousTransactionWidget", "Alle", null));
    } // retranslateUi

}

