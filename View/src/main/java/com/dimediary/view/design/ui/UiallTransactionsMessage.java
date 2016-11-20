/********************************************************************************
 ** Form generated from reading ui file 'alltransactionmessage.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiallTransactionsMessage implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer;
    public QPushButton pushButtonOnlyThis;
    public QPushButton pushButtonAll;
    public QPushButton pushButtonCancel;
    public QTextBrowser textBrowser;

    public UiallTransactionsMessage() { super(); }

    public void setupUi(QDialog allTransactionsMessage)
    {
        allTransactionsMessage.setObjectName("allTransactionsMessage");
        allTransactionsMessage.resize(new QSize(289, 142).expandedTo(allTransactionsMessage.minimumSizeHint()));
        gridLayout = new QGridLayout(allTransactionsMessage);
        gridLayout.setObjectName("gridLayout");
        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);

        pushButtonOnlyThis = new QPushButton(allTransactionsMessage);
        pushButtonOnlyThis.setObjectName("pushButtonOnlyThis");

        horizontalLayout.addWidget(pushButtonOnlyThis);

        pushButtonAll = new QPushButton(allTransactionsMessage);
        pushButtonAll.setObjectName("pushButtonAll");

        horizontalLayout.addWidget(pushButtonAll);

        pushButtonCancel = new QPushButton(allTransactionsMessage);
        pushButtonCancel.setObjectName("pushButtonCancel");

        horizontalLayout.addWidget(pushButtonCancel);


        gridLayout.addLayout(horizontalLayout, 1, 0, 1, 1);

        textBrowser = new QTextBrowser(allTransactionsMessage);
        textBrowser.setObjectName("textBrowser");

        gridLayout.addWidget(textBrowser, 0, 0, 1, 1);

        retranslateUi(allTransactionsMessage);

        allTransactionsMessage.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog allTransactionsMessage)
    {
        allTransactionsMessage.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("allTransactionsMessage", "Dauertransaktion", null));
        pushButtonOnlyThis.setText(com.trolltech.qt.core.QCoreApplication.translate("allTransactionsMessage", "Nur dieses", null));
        pushButtonAll.setText(com.trolltech.qt.core.QCoreApplication.translate("allTransactionsMessage", "Alle", null));
        pushButtonCancel.setText(com.trolltech.qt.core.QCoreApplication.translate("allTransactionsMessage", "Abbrechen", null));
        textBrowser.setHtml(com.trolltech.qt.core.QCoreApplication.translate("allTransactionsMessage", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Diese Transaktion geh\u00f6rt zu einer Dauertransaktion. Wollen Sie nur dieses Element oder alle Transaktionen bearbeiten?</span></p></body></html>", null));
    } // retranslateUi

}

